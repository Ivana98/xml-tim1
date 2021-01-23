package tim1.backend.service;

// import tim1.backend.model.Authority;
import tim1.backend.model.korisnici.*;
import tim1.backend.repository.UserRepository;

// import tim1.backend.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import java.util.List;

@Service
public class KorisnikService implements ServiceInterface {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;


    private String collectionId = "/db/poverenik/korisnik/";


    @Override
    public void saveXML(String documentId, String content) throws Exception {
        repository.saveXML(documentId, collectionId, content );

    }

    @Override
    public XMLResource readXML(String documentId) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveRDF(String xmlName, String uri) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public String readFileAsXML(String uri) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String readFileAsJSON(String uri) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
