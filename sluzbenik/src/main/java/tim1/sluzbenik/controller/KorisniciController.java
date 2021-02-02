package tim1.sluzbenik.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.modules.XMLResource;

import tim1.sluzbenik.dto.UserDTO;
import tim1.sluzbenik.helper.UserMapper;
import tim1.sluzbenik.model.korisnici.Korisnik;
import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.service.KorisnikService;

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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/korisnici")
public class KorisniciController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(path = "/xml/{id}", produces = "application/xml")
    public ResponseEntity<String> getXML(@PathVariable("id") String id) {

        try {
            XMLResource korisnik = korisnikService.readXML(id);
            return new ResponseEntity<>(korisnik.getContent().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Dodavanje novog korisnika - registracija
     * Registracija nece biti na frontu. Ovo je samo u svrhu
     * popunjavanja baze sa korisnicima.
     * 
     * @param content Korisnik u XML formatu
     * @return http status
     */
    @PostMapping(consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) {

        String documentId = UUID.randomUUID().toString();

        try {
            korisnikService.saveXML(documentId, content);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
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
}
