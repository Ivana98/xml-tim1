package tim1.backend.controller;

import java.util.UUID;

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

import tim1.backend.service.ZalbaNaOdlukuService;

@RestController
@RequestMapping(value = "/zalbe-na-odluku")
public class ZalbaNaOdlukuController {

    @Autowired
    private ZalbaNaOdlukuService zalbaService;

    @GetMapping(path = "/xml/{id}", produces = "application/xml")
    public ResponseEntity<XMLResource> getXML(@PathVariable("id") String id) {
        XMLResource xml = zalbaService.readXML(id);
        return new ResponseEntity<>(xml, HttpStatus.OK);
    }

    @PostMapping(path = "/xml/{id}", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) {

        try {
            zalbaService.saveXML(UUID.randomUUID().toString(), content);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rdf-xml/{uri}")
    public ResponseEntity<String> getRdfAsXML(@PathVariable("uri") String uri) {

        try {
            String rdf = zalbaService.readFileAsXML(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rdf-json/{uri}")
    public ResponseEntity<String> getRdfAsJSON(@PathVariable("uri") String uri) {

        try {
            String rdf = zalbaService.readFileAsJSON(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/rdf/{id}/{uri}")
    public ResponseEntity<String> saveRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {

        try {
            zalbaService.saveRDF(id, uri);
            return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
