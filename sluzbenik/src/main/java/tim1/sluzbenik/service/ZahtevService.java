package tim1.sluzbenik.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zahtev.Zahtev;
import tim1.sluzbenik.repository.ZahtevRepository;
import tim1.sluzbenik.utils.XSLFORTransformer;

import static tim1.sluzbenik.utils.PathConstants.*;

@Service
public class ZahtevService extends AbstractService {

    @Autowired
    public ZahtevService(ZahtevRepository repository) {
        super(repository, "/db/sluzbenik/zahtev/", "/zahtev/");
    }

    public JaxbLista<Zahtev> findAllFromCollection() throws Exception {

        List<Zahtev> listaZahteva;
        JaxbLista<Zahtev> listaObj;

        try {
            listaZahteva = this.findAllFromCollection(Zahtev.class);
            listaObj = new JaxbLista<>(listaZahteva);
            return listaObj;
        } catch (Exception e) {
            listaZahteva = new ArrayList<>();
            listaObj = new JaxbLista<>(listaZahteva);
            return listaObj;
        }
        // List<Zahtev> listaZahteva = this.findAllFromCollection( Zahtev.class);
        // JaxbLista<Zahtev> listaObj = new JaxbLista<Zahtev>(listaZahteva);
        // return listaObj;
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
		String html_path = SAVE_HTML + "zahtev_" + id + ".html";

		try {
			ok = transformer.generateHTML(doc_str, html_path, ZAHTEV_XSL);
			if (ok)
				return html_path;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

}
