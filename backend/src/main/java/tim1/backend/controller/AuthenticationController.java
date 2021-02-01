package tim1.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.backend.dto.AuthUserLoginResponseDTO;
import tim1.backend.service.AuthenticationService;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(path = "/login", consumes = "application/xml")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody String content) {
        System.out.println(content);

        try {
            AuthUserLoginResponseDTO response = authenticationService.createAuthenticationToken(content);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
