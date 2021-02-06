package tim1.backend.service;

import java.io.ByteArrayOutputStream;
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
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.model.zalbaodluka.ZalbaNaOdluku;
import tim1.backend.repository.ZalbaNaCutanjeRepository;
import tim1.backend.utils.XSLFORTransformer;

import static tim1.backend.utils.PathConstants.*;

@Service
public class ZalbaNaCutanjeService extends AbstractService {

    @Autowired
    private ZalbaNaOdlukuService zalbaNaOdlukuService;

    @Autowired
    public ZalbaNaCutanjeService(ZalbaNaCutanjeRepository repository) {
        super(repository, "/db/poverenik/zalbanacutanje/", "/zalbanacutanje/");
    }

    @Override
    public void saveXML(String documentId, String content) throws Exception {

        InputStream inputStream = new ReaderInputStream(new StringReader(content));

        JAXBContext context = JAXBContext.newInstance(ZalbaNaCutanje.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ZalbaNaCutanje zalbaNaCutanje = (ZalbaNaCutanje) unmarshaller.unmarshal(inputStream);

        zalbaNaCutanje.setId(documentId);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        marshaller.marshal(zalbaNaCutanje, stream);

        String finalString = new String(stream.toByteArray());
        System.out.println(finalString);

        content = finalString;

        repository.saveXML(documentId, collectionId, content);
        repository.saveRDF(content, documentId);
    }

    public JaxbLista<ZalbaNaCutanje> findAllFromCollection() throws Exception {

        List<ZalbaNaCutanje> listaZalbi = this.findAllFromCollection(ZalbaNaCutanje.class);
        JaxbLista<ZalbaNaCutanje> listaObj = new JaxbLista<ZalbaNaCutanje>(listaZalbi);
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
        String html_path = SAVE_HTML + "zalba_cutanje_" + id + ".html";
        System.out.println(doc_str);

        try {
            ok = transformer.generateHTML(doc_str, html_path, ZALBA_CUTANJE_XSL);
            if (ok)
                return html_path;
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String oznaciZalbuKaoProcitanu(String idZalbe) {
        // zalba moze da pripada i zalbi na cutanje i zalbi na odluku. svejedno je
        // probaj da nadjes zalbu na cutanje
        try {
            JAXBContext context = JAXBContext.newInstance(ZalbaNaCutanje.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            XMLResource xmlZalba = this.readXML(idZalbe);
            String s = xmlZalba.getContent().toString();
            StringReader reader = new StringReader(s);
            ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(reader);
            zalba.setStatus("pregledano");
            
            //cuvanje zalbe na cutanje
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            marshaller.marshal(zalba, stream);

            String finalString = new String(stream.toByteArray());
            System.out.println(finalString);

            repository.saveXML(idZalbe, collectionId, finalString);
            repository.saveRDF(finalString, idZalbe);
            return "uspesno promenjen status zalbe na pregledano";
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
            zalbaNaOdluku.setStatus("pregledano");
            
            //cuvanje zalbe na odluku
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            marshaller.marshal(zalbaNaOdluku, stream);

            String finalString = new String(stream.toByteArray());
            System.out.println(finalString);

            repository.saveXML(idZalbe, collectionId, finalString);
            repository.saveRDF(finalString, idZalbe);
            return "uspesno promenjen status zalbe na pregledano";
        } catch (Exception e) {
        }

        System.out.println(idZalbe);
        return "zalba je uspesno oznacena";
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
        String pdf_path = SAVE_PDF + "zalba_" + id + ".pdf";

		try {
			ok = transformer.generatePDF(doc_str, pdf_path, ZALBA_CUTANJE_XSL_FO);
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
