package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ResenjeRepository;

@Service
public class ResenjeService implements ServiceInterface {

    @Autowired
    private ResenjeRepository repository;

    private String collectionId = "/db/poverenik/resenje/";

    private String fusekiCollectionId = "/resenje/";

    @Override
    public void saveRDF(String content, String rdfName, String uri) throws Exception {
        repository.saveRDF(content, rdfName, fusekiCollectionId + uri);
    }


    @Override
    public void saveXML(String documentId, String content) throws Exception {
        
        repository.saveXML(documentId, collectionId, content );

    }

    @Override
    public XMLResource readXML(String documentId) throws Exception {

        return repository.readXML(documentId, collectionId);
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
