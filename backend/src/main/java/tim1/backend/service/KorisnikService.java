package tim1.backend.service;

import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.model.liste.JaxbLista;
// import tim1.backend.model.Authority;
import tim1.backend.repository.UserRepository;

import java.util.List;

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
        super(repository, "/db/poverenik/korisnik/",  "/korisnik/");
    }

    public JaxbLista<Korisnik> findAllFromCollection() throws Exception{
        
        List<Korisnik> listaZalbi = this.findAllFromCollection( Korisnik.class);
        JaxbLista<Korisnik> listaObj = new JaxbLista<Korisnik>(listaZalbi);
        return listaObj;
    }

    @Override
    public void saveXML(String documentId, String content) throws Exception {

        JaxbLista<Korisnik> lista = this.findAllFromCollection();

        for (Korisnik k : lista.getLista()) {
            if (k.getKorisnickoIme().equals(documentId)) {
                throw new IllegalArgumentException();
            }
        }
      
        repository.saveXML(documentId, collectionId, content );
  
    }



}
