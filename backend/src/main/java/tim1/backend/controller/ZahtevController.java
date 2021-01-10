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
@RequestMapping(value = "/zahtev")
public class ZahtevController {
    
    @Autowired
    private ZahtevService zahtevService;

    @GetMapping("/XML/{zahtevId}")
    public ResponseEntity<XMLResource> readZahtevXML(@PathVariable("zahtevId") String zahtevId){
        XMLResource zahtev = zahtevService.readXML(zahtevId);
        return new ResponseEntity<>(zahtev, HttpStatus.OK);
    }

    @PostMapping("/XML/{zahtevId}")
    public ResponseEntity<String> saveZahtevXML(@PathVariable("zahtevId") String zahtevId){
        zahtevService.saveXML(zahtevId);
        return new ResponseEntity<>("Successfully saved!" ,HttpStatus.OK);
    }

    @GetMapping("/RDF/{zahtevURI}")
    public ResponseEntity<String> readZahtevRDF(@PathVariable("zahtevURI") String zahtevURI){
        zahtevService.readRDF(zahtevURI);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/RDF/{zahtevId}/{zahtevURI}")
    public ResponseEntity<String> saveZahtevRDF(@PathVariable("zahtevId") String zahtevId, @PathVariable("zahtevURI") String zahtevURI){
        zahtevService.saveRDF(zahtevId, zahtevURI);
        return new ResponseEntity<>("Successfully saved!" ,HttpStatus.OK);
    }
}
