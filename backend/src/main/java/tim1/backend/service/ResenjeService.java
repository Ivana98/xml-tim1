package tim1.backend.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.tools.ant.util.ReaderInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.liste.JaxbLista;
//import tim1.backend.model.resenje.Resenje;
import tim1.backend.model.resenje.ResenjeObrazac;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.model.zalbacutanje.PodnosilacZalbe.Ime;
import tim1.backend.model.zalbaodluka.Podnosilac;
import tim1.backend.model.zalbaodluka.ZalbaNaOdluku;
import tim1.backend.repository.ResenjeRepository;
import tim1.backend.soap.client.EmailClient;
import tim1.backend.utils.XSLFORTransformer;

import static tim1.backend.utils.PathConstants.*;

@Service
public class ResenjeService extends AbstractService {

	@Autowired
	EmailClient emailClient;

	@Autowired
	private ZalbaNaCutanjeService zalbaNaCutanjeService;

	@Autowired
	private ZalbaNaOdlukuService zalbaNaOdlukuService;

	@Autowired
	public ResenjeService(ResenjeRepository repository) {
		super(repository, "/db/poverenik/resenje/", "/resenje/");
	}


	@Override
    public void saveXML(String documentId, String content) throws Exception {

        InputStream inputStream = new ReaderInputStream(new StringReader(content));

        JAXBContext context = JAXBContext.newInstance(ResenjeObrazac.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ResenjeObrazac resenje = (ResenjeObrazac) unmarshaller.unmarshal(inputStream);

        resenje.setId(documentId);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
        marshaller.marshal(resenje, stream);
        
        String finalString = new String(stream.toByteArray());
        System.out.println(finalString);
        
        content = finalString;
        
        repository.saveXML(documentId, collectionId, content);
        repository.saveRDF(content, documentId);
    }

	public JaxbLista<ResenjeObrazac> findAllFromCollection() throws Exception {

		List<ResenjeObrazac> listaZalbi = this.findAllFromCollection(ResenjeObrazac.class);
		JaxbLista<ResenjeObrazac> listaObj = new JaxbLista<ResenjeObrazac>(listaZalbi);
		return listaObj;
	}

	public String generateHTML(String id) throws XMLDBException {
		XSLFORTransformer transformer = null;

		try {
			transformer = new XSLFORTransformer();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		XMLResource xmlRes = this.readXML(id);
		String doc_str = xmlRes.getContent().toString();
		boolean ok = false;
		String html_path = SAVE_HTML + "resenje_" + id + ".html";

		try {
			ok = transformer.generateHTML(doc_str, html_path, RESENJE_XSL);
			if (ok)
				return html_path;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void posaljiMejlove(String idZalbe, String idResenja) throws Exception {
		// nadji mejl korisnika i ime korisnika u zalbi na cutanje.
		String emailGradjanina = getEmailGradjanina(idZalbe);

		// generisanje htmla
		String htmlPath = this.generateHTML(idResenja);

		String sadrzajMejla = "Postovani," + "\nU prilogu se nalazi resenje za zalbu broj: " + idZalbe;

		// TODO: POSLATI I PDF

		// slanje resenja sluzbeniku
		emailClient.posaljiResenje("konstrukcijaitestiranje@gmail.com", "Resenje", sadrzajMejla, "asdf.pdf", htmlPath);
		// slanje resenja gradjaninu
		emailClient.posaljiResenje(emailGradjanina, "Resenje", sadrzajMejla, "asdf.pdf", htmlPath);
	}

	private String getEmailGradjanina(String idZalbe) throws Exception {

		// probaj da nadjes zalbu na cutanje
		try {
			JAXBContext context = JAXBContext.newInstance(ZalbaNaCutanje.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			XMLResource xmlZalba = zalbaNaCutanjeService.readXML(idZalbe);
			String s = xmlZalba.getContent().toString();
			StringReader reader = new StringReader(s);
			ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(reader);
			String emailGradjanina = zalba.getPodnosilacZalbe().getEmail();
			return emailGradjanina;
		} catch (Exception e) {
		}

		try {
			// else probaj da nadjes zalbu na odluku
			JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			XMLResource xmlZalba = zalbaNaOdlukuService.readXML(idZalbe);
			String s = xmlZalba.getContent().toString();
			StringReader reader = new StringReader(s);
			ZalbaNaOdluku zalbaNaOdluku = (ZalbaNaOdluku) unmarshaller.unmarshal(reader);
			List listaXmlProperties = zalbaNaOdluku.getZalba().getContent();
			Podnosilac p = (Podnosilac) listaXmlProperties.get(11);
			String emailGradjanina = p.getEmail();
			System.out.println("------------------------------------");
			System.out.println(emailGradjanina);
			return emailGradjanina;
		} catch (Exception e) {
		}

		return null;
	}

	public String generatePDF(String id) {
		XSLFORTransformer transformer = null;

		try {
			transformer = new XSLFORTransformer();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

        XMLResource xmlRes = this.readXML(id);
        String doc_str = "";
		try {
			doc_str = xmlRes.getContent().toString();
			System.out.println(doc_str);
		} catch (XMLDBException e1) {
			e1.printStackTrace();
		}

		boolean ok = false;
        String pdf_path = SAVE_PDF + "resenje_" + id + ".pdf";

		try {
			ok = transformer.generatePDF(doc_str, pdf_path, RESENJE_XSL_FO);
			if (ok)
				return pdf_path;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
