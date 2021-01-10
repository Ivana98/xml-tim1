package tim1.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.service.ZahtevService;

@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevController {

    @Autowired
    private ZahtevService zahtevService;

    @GetMapping("/xml/{id}")
    public ResponseEntity<XMLResource> readZahtevXML(@PathVariable("id") String id) {
        XMLResource zahtev = zahtevService.readXML(id);
        return new ResponseEntity<>(zahtev, HttpStatus.OK);
    }

    @PostMapping("/xml/{id}")
    public ResponseEntity<?> saveZahtevXML(@PathVariable("id") String id) {
        zahtevService.saveXML(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/rdf/{uri}")
    public ResponseEntity<String> readZahtevRDF(@PathVariable("uri") String uri) {
        zahtevService.readRDF(uri);
        return new ResponseEntity<>("Successfully read!", HttpStatus.OK);
    }

    @PostMapping("/rdf/{id}/{uri}")
    public ResponseEntity<String> saveZahtevRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {
        zahtevService.saveRDF(id, uri);
        return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    }
}
