package tim1.backend.service;

// import tim1.backend.model.Authority;
import tim1.backend.repository.UserRepository;

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


}
