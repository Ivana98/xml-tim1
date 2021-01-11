package tim1.backend.controller;

import java.util.UUID;

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

    @PostMapping(path = "/xml", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) {

        try {
            zahtevService.saveXML(UUID.randomUUID().toString(), content);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/rdf-xml/{uri}")
    public ResponseEntity<String> getRdfAsXML(@PathVariable("uri") String uri) {

        try {
            String rdf = zahtevService.readFileAsXML(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rdf-json/{uri}")
    public ResponseEntity<String> getRdfAsJSON(@PathVariable("uri") String uri) {

        try {
            String rdf = zahtevService.readFileAsJSON(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/rdf/{id}/{uri}")
    public ResponseEntity<String> saveRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {

        try {
            zahtevService.saveRDF(id, uri);
            return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
