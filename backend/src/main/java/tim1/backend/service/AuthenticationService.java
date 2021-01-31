package tim1.backend.service;

import java.io.StringReader;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.backend.dto.AuthUserLoginResponseDTO;
import tim1.backend.dto.UserLoginDTO;
import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.security.TokenUtils;

@Service
public class AuthenticationService {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthUserLoginResponseDTO createAuthenticationToken(String content) throws Exception {

            JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(content);
            Korisnik korisnik = (Korisnik) unmarshaller.unmarshal(reader);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(korisnik.getKorisnickoIme(), korisnik.getSifra()));
                    
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Korisnik user = (Korisnik) authentication.getPrincipal();

            System.out.println(user);

            String jwt = tokenUtils.generateToken(user.getKorisnickoIme()); // prijavljujemo se na sistem sa kor imenom
                                                                            // (email)
            int expiresIn = tokenUtils.getExpiredIn();

            return new AuthUserLoginResponseDTO(jwt, expiresIn);

    }

}
