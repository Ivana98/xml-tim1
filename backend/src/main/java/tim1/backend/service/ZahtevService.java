package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ZahtevRepository;

@Service
public class ZahtevService implements ServiceInterface {

    @Autowired
    private ZahtevRepository repository;

    private String collectionId = "/db/poverenik/zahtev/";

    @Override
    public void saveRDF(String xmlName, String rdfName, String uri) throws Exception {
        repository.saveRDF(xmlName, rdfName, uri);
    }

    @Override
    public void readRDF(String uri) throws Exception {
        repository.readRDF(uri);
    }

    @Override
    public void saveXML(String documentId, String content) throws Exception {

        repository.saveXML(documentId, collectionId, content);

    }

    @Override
    public XMLResource readXML(String documentId) {

        XMLResource document = null;

        try {
            document = repository.readXML(documentId, collectionId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return document;
    }

}
