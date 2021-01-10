package tim1.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.service.ObavestenjeService;

@RestController
@RequestMapping(value = "/obavestenje")
public class ObavestenjeController {

    @Autowired
    private ObavestenjeService obavestenjeService;

    @GetMapping("/XML/{obavestenjeId}")
    public ResponseEntity<XMLResource> readObavestenjeXML(@PathVariable("obavestenjeId") String obavestenjeId){
        XMLResource obavestenje = obavestenjeService.readXML(obavestenjeId);
        return new ResponseEntity<>(obavestenje, HttpStatus.OK);
    }

    @PostMapping("/XML/{obavestenjeId}")
    public ResponseEntity<String> saveObavestenjeXML(@PathVariable("obavestenjeId") String obavestenjeId){
        obavestenjeService.saveXML(obavestenjeId);
        return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    }

    @GetMapping("/RDF/{obavestenjeURI}")
    public ResponseEntity<String> readObavestenjeRDF(@PathVariable("obavestenjeURI") String obavestenjeURI){
        obavestenjeService.readRDF(obavestenjeURI);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/RDF/{obavestenjeId}/{obavestenjeURI}")
    public ResponseEntity<String> saveObavestenjeRDF(@PathVariable("obavestenjeId") String obavestenjeId, @PathVariable("obavestenjeURI") String obavestenjeURI){
        obavestenjeService.saveRDF(obavestenjeId, obavestenjeURI);
        return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    }
    
}
