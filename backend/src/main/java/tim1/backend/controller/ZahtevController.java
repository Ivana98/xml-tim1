package tim1.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zahtev.Zahtev;
import tim1.backend.soap.client.ZahtevClient;

@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevController {

    @Autowired
    private ZahtevClient zahtevClient;

    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<Zahtev>> findAllFromCollection() throws Exception {

        try {
            JaxbLista<Zahtev> listaZahteva = zahtevClient.findAll();
            return new ResponseEntity<>(listaZahteva, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
