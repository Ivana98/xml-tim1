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
@RequestMapping(value = "/obavestenja")
public class ObavestenjeController {

    @Autowired
    private ObavestenjeService obavestenjeService;

    @GetMapping("/xml/{id}")
    public ResponseEntity<XMLResource> readObavestenjeXML(@PathVariable("id") String id){
        XMLResource obavestenje = obavestenjeService.readXML(id);
        return new ResponseEntity<>(obavestenje, HttpStatus.OK);
    }

    @PostMapping("/xml/{id}")
    public ResponseEntity<?> saveObavestenjeXML(@PathVariable("id") String id){
        obavestenjeService.saveXML(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/rdf/{uri}")
    public ResponseEntity<String> readObavestenjeRDF(@PathVariable("uri") String uri){
        obavestenjeService.readRDF(uri);
        return new ResponseEntity<>("Successfully read!", HttpStatus.OK);
    }

    @PostMapping("/rdf/{id}/{uri}")
    public ResponseEntity<String> saveObavestenjeRDF(@PathVariable("id") String id, @PathVariable("uri") String uri){
        obavestenjeService.saveRDF(id, uri);
        return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    }
    
}
