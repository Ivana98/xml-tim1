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

import tim1.backend.service.ResenjeService;

@RestController
@RequestMapping(value = "/resenja", produces = "application/xml")
public class ResenjeController {

    @Autowired
    private ResenjeService resenjeService;

    @GetMapping("/xml/{id}")
    public ResponseEntity<XMLResource> getXML(@PathVariable("id") String id) {

        try {
            XMLResource xml = resenjeService.readXML(id);
            return new ResponseEntity<>(xml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/xml/{id}")
    public ResponseEntity<?> saveResenjeXML(@PathVariable("id") String id, @RequestBody String content) {

        try {
            resenjeService.saveXML(id, content);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rdf/{uri}")
    public ResponseEntity<String> readResenjeRDF(@PathVariable("uri") String uri) {

        try {
            resenjeService.readRDF(uri);
            return new ResponseEntity<>("Successfully read!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/rdf/{id}/{uri}")
    public ResponseEntity<String> saveResenjeRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {

        try {
            resenjeService.saveRDF(id, uri);
            return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
