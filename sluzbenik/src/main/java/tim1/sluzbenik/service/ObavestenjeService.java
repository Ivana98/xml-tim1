package tim1.sluzbenik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.obavestenje.Obavestenje;
import tim1.sluzbenik.repository.ObavestenjeRepository;
import tim1.sluzbenik.utils.XSLFORTransformer;

import static tim1.sluzbenik.utils.PathConstants.*;

@Service
public class ObavestenjeService extends AbstractService {

    @Autowired
    public ObavestenjeService(ObavestenjeRepository repository) {
        super(repository, "/db/sluzbenik/obavestenje/", "/obavestenje/");
    }

    public JaxbLista<Obavestenje> findAllFromCollection() throws Exception {

        List<Obavestenje> listaObavestenja = this.findAllFromCollection(Obavestenje.class);
        JaxbLista<Obavestenje> listaObj = new JaxbLista<Obavestenje>(listaObavestenja);
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
		String html_path = SAVE_HTML + "obavestenje_" + id + ".html";

		try {
			ok = transformer.generateHTML(doc_str, html_path, OBAVESTENJE_XSL);
			if (ok)
				return html_path;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
        } catch (XMLDBException e1) {
            e1.printStackTrace();
        }

		boolean ok = false;
        String pdf_path = SAVE_PDF + "obavestenje_" + id + ".pdf";

		try {
			ok = transformer.generateHTML(doc_str, pdf_path, OBAVESTENJE_XSL_FO);
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
