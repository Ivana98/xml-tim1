package tim1.backend.service;

// import tim1.backend.model.Authority;
import tim1.backend.model.korisnici.*;
// import tim1.backend.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    public List<Korisnik> findAll() {

        // return userRepository.findAll();

        return null;
    }

    public Korisnik findOne(Long id) {

        // return userRepository.findById(id).orElse(null);

        return null;
    }

    public Korisnik create(Korisnik entity) throws Exception {

        // if (userRepository.findByEmail(entity.getEmail()) != null)
        // throw new Exception("User with given email address already exists");

        // Korisnik u = new Korisnik();
        // u.setUsername(entity.getUsername());
        // // pre nego sto postavimo lozinku u atribut hesiramo je
        // u.setPassword(passwordEncoder.encode(entity.getPassword()));
        // u.setFirstName(entity.getFirstName());
        // u.setLastName(entity.getLastName());
        // u.setEmail(entity.getEmail());

        // List<Authority> auth = authService.findByName("ROLE_USER");
        // // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i
        // // dodeljuje samo rola USER
        // u.setAuthorities(auth);

        // u = this.userRepository.save(u);
        // return u;

        return null;
    }

    public Korisnik update(Korisnik entity, Long id) throws Exception {

        // Korisnik existingUser = userRepository.findById(id).orElse(null);

        // if (existingUser == null)
        // throw new Exception("User with given id doesn't exist");

        // existingUser.setPassword(entity.getPassword());

        // return userRepository.save(existingUser);

        return null;
    }

    public void delete(Long id) throws Exception {

        // Korisnik existingUser = userRepository.findById(id).orElse(null);

        // if (existingUser == null)
        //     throw new Exception("User with given id doesn't exist");

        // userRepository.delete(existingUser);
    }

    public Korisnik findByEmail(String email) {

        // return userRepository.findByEmail(email);
        
        return null;
    }

}
