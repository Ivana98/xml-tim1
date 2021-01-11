package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ObavestenjeRepository;

@Service
public class ObavestenjeService implements ServiceInterface {

    @Autowired
    private ObavestenjeRepository repository;

    @Override
    public void saveRDF(String name, String uri) {
        repository.saveRDF(name, uri);
    }

    @Override
    public void readRDF(String uri) {
        repository.readRDF(uri);
    }

    @Override
    public void saveXML(String id, String content) throws Exception {

        repository.saveXML(id, content);

    }

    @Override
    public XMLResource readXML(String name) {

        XMLResource document = null;
        
        try {
            document = repository.readXML(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return document;
    }

}
