package tim1.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.backend.dto.UserDTO;
import tim1.backend.helper.UserMapper;
import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.service.KorisnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/korisnici", produces = MediaType.APPLICATION_JSON_VALUE)
public class KorisniciController {

    @Autowired
    private KorisnikService userService;

    private UserMapper userMapper;

    // Metode klase kontrolera su anotirane sa @RequestMapping anotacijom koja
    // opisuje zahtev koji treba biti obrađen u toj metodi (URL i tip HTTP metode)
    /*
     * ResponseEntity objekat može da sadrži: telo (podatke) – metode anotirane
     * sa @RequestBody anotacijom sadrže samo telo zaglavlje (metapodatke) HTTP
     * status kod
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<Korisnik> users = userService.findAll();

        return new ResponseEntity<>(toUserDTOList(users), HttpStatus.OK);
    }

    // Parametar je u kontroler moguce poslati kao parametar koji je promenljiva u
    // URL-u zahteva - Path Variable
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {

        Korisnik user = userService.findOne(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {

        Korisnik user;

        try {
            user = userService.update(userMapper.toEntity(userDTO), id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        try {
            userService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public KorisniciController() {
        userMapper = new UserMapper();
    }

    private List<UserDTO> toUserDTOList(List<Korisnik> users) {

        List<UserDTO> userDTOS = new ArrayList<>();
        
        for (Korisnik user : users) {
            userDTOS.add(userMapper.toDto(user));
        }
        
        return userDTOS;
    }

}
