package tim1.backend.service;

import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.model.liste.JaxbLista;
// import tim1.backend.model.Authority;
import tim1.backend.repository.UserRepository;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

// import tim1.backend.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService extends AbstractService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    @Autowired
    public KorisnikService(UserRepository repository) {
        super(repository, "/db/poverenik/korisnik/", "/korisnik/");
    }

    public JaxbLista<Korisnik> findAllFromCollection() throws Exception {

        List<Korisnik> listaZalbi = this.findAllFromCollection(Korisnik.class);
        JaxbLista<Korisnik> listaObj = new JaxbLista<Korisnik>(listaZalbi);
        return listaObj;
    }

    @Override
    public void saveXML(String documentId, String content) throws Exception {

        JaxbLista<Korisnik> lista = this.findAllFromCollection();

        JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(content);
        Korisnik person = (Korisnik) unmarshaller.unmarshal(reader);

        for (Korisnik k : lista.getLista()) {
            if (k.getKorisnickoIme().equals(person.getKorisnickoIme())) {
                throw new IllegalArgumentException();
            }
        }

        repository.saveXML(documentId, collectionId, content);
    }

}
