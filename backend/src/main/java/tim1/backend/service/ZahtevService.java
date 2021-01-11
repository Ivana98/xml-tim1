package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ZahtevRepository;

@Service
public class ZahtevService implements ServiceInterface {

    @Autowired
    private ZahtevRepository repository;

    @Override
    public void saveXML(String id, String content) throws Exception {

        repository.saveXML(id, content);

    }

    @Override
    public XMLResource readXML(String name) throws Exception {

        return repository.readXML(name);
    }

    @Override
    public void saveRDF(String name, String uri) {
        repository.saveRDF(name, uri);
    }

    @Override
    public void readRDF(String uri) {
        repository.readRDF(uri);

    }

}
