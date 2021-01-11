package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ZalbaNaOdlukuRepository;

@Service
public class ZalbaNaOdlukuService implements ServiceInterface {

    @Autowired
    private ZalbaNaOdlukuRepository repository;

    private String collectionId = "/db/poverenik/zalbanaodluku/";

    @Override
    public void saveRDF(String xmlName, String rdfName, String uri) throws Exception {
        repository.saveRDF(xmlName, rdfName, uri);
    }


    @Override
    public void saveXML(String documentId, String content) throws Exception {
        
        repository.saveXML(documentId, collectionId, content );

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

    @Override
    public String readFileAsXML(String uri) throws Exception {
        return repository.readFileAsXML(uri);
    }

    @Override
    public String readFileAsJSON(String uri) throws Exception {
        return repository.readFileAsJSON(uri);
    }
}
