package tim1.backend.service;

import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.model.liste.JaxbLista;
// import tim1.backend.model.Authority;
import tim1.backend.repository.UserRepository;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

        JaxbLista<Korisnik> lista;
        try {
            lista = this.findAllFromCollection();
        } catch (Exception e) {
            List<Korisnik> l = new ArrayList<>();
            lista = new JaxbLista<>(l);
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(content);
        Korisnik korisnik = (Korisnik) unmarshaller.unmarshal(reader);

        korisnik.setUloga(korisnik.getUloga().toUpperCase()); // uloga korisnika ide velikim slovima

        System.out.println(korisnik.getSifra());
        korisnik.setSifra(passwordEncoder.encode(korisnik.getSifra()));
        System.out.println(korisnik.getSifra());

        for (Korisnik k : lista.getLista()) {
            if (k.getKorisnickoIme().equals(korisnik.getKorisnickoIme())) {
                throw new IllegalArgumentException();
            }
        }

        JAXBContext context = JAXBContext.newInstance(Korisnik.class);
        Marshaller m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        StringWriter sw = new StringWriter();
        m.marshal(korisnik, sw);
        content = sw.toString();

        repository.saveXML(korisnik.getKorisnickoIme(), collectionId, content);
    }

}
