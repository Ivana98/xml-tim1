package tim1.sluzbenik.service;

import tim1.sluzbenik.model.korisnici.Korisnik;
import tim1.sluzbenik.model.liste.JaxbLista;
// import tim1.sluzbenik.model.Authority;
import tim1.sluzbenik.repository.UserRepository;

import java.util.List;

// import tim1.sluzbenik.repository.KorisnikRepository;
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



}
