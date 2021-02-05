package tim1.backend.service;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.resenje.Resenje;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.model.zalbacutanje.PodnosilacZalbe.Ime;
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
	public ResenjeService(ResenjeRepository repository) {
		super(repository, "/db/poverenik/resenje/", "/resenje/");
	}

	public JaxbLista<Resenje> findAllFromCollection() throws Exception {

		List<Resenje> listaZalbi = this.findAllFromCollection(Resenje.class);
		JaxbLista<Resenje> listaObj = new JaxbLista<Resenje>(listaZalbi);
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

	public void posaljiMejlove(String idZalbe) throws Exception {
		// nadji mejl korisnika i ime korisnika u zalbi na cutanje.
		JAXBContext context = JAXBContext.newInstance(ZalbaNaCutanje.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		XMLResource xmlZalba = zalbaNaCutanjeService.readXML(idZalbe);
		String s = xmlZalba.getContent().toString();
		StringReader reader = new StringReader(s);
		ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(reader);

		String emailGradjanina = zalba.getPodnosilacZalbe().getEmail();

		String sadrzajMejla = "Postovani," + "\nU prilogu se nalazi resenje za zalbu broj: " + idZalbe;
		// TODO: POSLATI MEJL PRAVOM KORISNIKU
		// TODO: POSLATI I PDF I HTML

		//slanje resenja sluzbeniku
		emailClient.posaljiResenje("konstrukcijaitestiranje@gmail.com", "Resenje",
		sadrzajMejla, "asdf.pdf", "asdf.html");
		//slanje resenja gradjaninu
		emailClient.posaljiResenje(emailGradjanina, "Resenje", sadrzajMejla,
		"asdf.pdf", "asdf.html");
	}

}
