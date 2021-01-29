package tim1.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.backend.dto.UserDTO;
import tim1.backend.helper.UserMapper;
import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.model.liste.JaxbLista;
import tim1.backend.service.KorisnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@RestController
@RequestMapping(value = "/korisnici")
public class KorisniciController {

    @Autowired
    private KorisnikService korisnikService;

    private UserMapper userMapper;

    // Metode klase kontrolera su anotirane sa @RequestMapping anotacijom koja
    // opisuje zahtev koji treba biti obrađen u toj metodi (URL i tip HTTP metode)
    /*
     * ResponseEntity objekat može da sadrži: telo (podatke) – metode anotirane
     * sa @RequestBody anotacijom sadrže samo telo zaglavlje (metapodatke) HTTP
     * status kod
     */
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @GetMapping(value = "/xml", produces = "application/xml")
    // public ResponseEntity<JaxbLista<Korisnik>> getAllUsers() {

    // // try {
    // // JaxbLista<Korisnik> users = korisnikService.findAllFromCollection();
    // // return new ResponseEntity<>(users, HttpStatus.OK);
    // // } catch (Exception e) {

    // // }

    // // return new ResponseEntity<>(toUserDTOList(users), HttpStatus.OK);

    // return null;
    // }

    // Parametar je u kontroler moguce poslati kao parametar koji je promenljiva u
    // URL-u zahteva - Path Variable
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {

        // Korisnik user = userService.findOne(id);

        // if (user == null) {
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }

        // return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);

        return null;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {

        // Korisnik user;

        // try {
        // user = userService.update(userMapper.toEntity(userDTO), id);
        // } catch (Exception e) {
        // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        // }

        // return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);

        return null;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        // try {
        // userService.delete(id);
        // } catch (Exception e) {
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }

        // return new ResponseEntity<>(HttpStatus.OK);
        return null;
    }

    @PostMapping(consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(content);
        Korisnik person = (Korisnik) unmarshaller.unmarshal(reader);

        try {
            korisnikService.saveXML(person.getKorisnickoIme(), content);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<Korisnik>> findAllFromCollection() throws Exception {

        try {
            JaxbLista<Korisnik> lista = korisnikService.findAllFromCollection();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
