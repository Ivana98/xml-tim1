package tim1.backend.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.service.ZahtevService;

@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevController {

    @Autowired
    private ZahtevService zahtevService;

    @GetMapping(path = "/xml/{id}", produces = "application/xml")
    public ResponseEntity<String> getXML(@PathVariable("id") String id) throws XMLDBException {

        try {
            XMLResource zahtev = zahtevService.readXML(id);
            return new ResponseEntity<>(zahtev.getContent().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/xml/{id}", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@PathVariable("id") String id, @RequestBody String content) {

        try {
            zahtevService.saveXML(id, content);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/rdf/{uri}")
    public ResponseEntity<String> readZahtevRDF(@PathVariable("uri") String uri) {

        try {
            zahtevService.readRDF(uri);
            return new ResponseEntity<>("Successfully read!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/rdf/{id}/{uri}")
    public ResponseEntity<String> saveZahtevRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {

        try {
            zahtevService.saveRDF(id, uri);
            return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
