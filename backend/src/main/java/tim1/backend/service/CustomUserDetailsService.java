package tim1.backend.service;

import tim1.backend.model.korisnici.*;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

// Ovaj servis je namerno izdvojen kao poseban u ovom primeru.
// U opstem slucaju UserServiceImpl klasa bi mogla da implementira UserDetailService interfejs.
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Funkcija koja na osnovu username-a iz baze vraca objekat User-a
    @Override
    public Korisnik loadUserByUsername(String email) throws UsernameNotFoundException {
        // ako se ne radi nasledjivanje, paziti gde sve treba da se proveri email

        XMLResource korisnikXML = korisnikService.readXML(email);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(korisnikXML.getContent().toString());
            Korisnik korisnik = (Korisnik) unmarshaller.unmarshal(reader);

            // Korisnik user = korisnikRepository.findByEmail(email);
            if (korisnik == null) {
                throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
            } else {
                return korisnik;
            }
        } catch (Exception e) {
            return null;
        }
    }

    // Funkcija pomocu koje korisnik menja svoju lozinku
    public void changePassword(String oldPassword, String newPassword) {

        // Ocitavamo trenutno ulogovanog korisnika
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((Korisnik) currentUser.getPrincipal()).getKorisnickoIme();

        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            return;
        }
        Korisnik user = (Korisnik) loadUserByUsername(username);

        // pre nego sto u bazu upisemo novu lozinku, potrebno ju je hesirati
        // ne zelimo da u bazi cuvamo lozinke u plain text formatu
        user.setSifra(passwordEncoder.encode(newPassword));

        // TODO: odkomentarisati ovo
        // userRepository.save(user);
    }

}
