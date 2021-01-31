package tim1.backend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.backend.dto.AuthUserLoginResponseDTO;
import tim1.backend.dto.UserLoginDTO;
import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.security.TokenUtils;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginDTO authenticationRequest,
            HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getKorisnickoIme(), authenticationRequest.getSifra()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Korisnik user = (Korisnik) authentication.getPrincipal();

        String jwt = tokenUtils.generateToken(user.getKorisnickoIme()); // prijavljujemo se na sistem sa kor imenom (email)
        int expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new AuthUserLoginResponseDTO(jwt, expiresIn));
        // return new ResponseEntity<>(new AuthUserLoginResponseDTO(jwt, expiresIn), HttpStatus.OK)
    }
}
