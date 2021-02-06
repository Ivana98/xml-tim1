package tim1.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.obavestenje.Obavestenje;
import tim1.backend.repository.ObavestenjeRepository;
import tim1.backend.utils.XSLFORTransformer;

import static tim1.backend.utils.PathConstants.*;

@Service
public class ObavestenjeService extends AbstractService {

    @Autowired
    public ObavestenjeService(ObavestenjeRepository repository) {
        super(repository, "/db/poverenik/obavestenje/", "/obavestenje/");
    }

    public JaxbLista<Obavestenje> findAllFromCollection() throws Exception{
        
        List<Obavestenje> listaZalbi = this.findAllFromCollection( Obavestenje.class);
        JaxbLista<Obavestenje> listaObj = new JaxbLista<Obavestenje>(listaZalbi);
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
		System.out.println(doc_str);

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
			System.out.println(doc_str);
		} catch (XMLDBException e1) {
			e1.printStackTrace();
		}

		boolean ok = false;
        String pdf_path = SAVE_PDF + "obavestenje_" + id + ".pdf";

		try {
			ok = transformer.generatePDF(doc_str, pdf_path, OBAVESTENJE_XSL_FO);
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
