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

import tim1.backend.service.ZalbaNaCutanjeService;

@RestController
@RequestMapping(value = "/zalbe-na-cutenje")
public class ZalbaNaCutanjeController {

    @Autowired
    private ZalbaNaCutanjeService zalbaService;

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

    @GetMapping("/rdf/{uri}")
    public ResponseEntity<String> getRDF(@PathVariable("uri") String uri) {

        try {
            zalbaService.readRDF(uri);
            return new ResponseEntity<>("Successfully read!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // @PostMapping("/rdf/{id}/{uri}")
    // public ResponseEntity<String> saveRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {

    //     try {
    //         zalbaService.saveRDF(id, uri);
    //         return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }
    // }

}
