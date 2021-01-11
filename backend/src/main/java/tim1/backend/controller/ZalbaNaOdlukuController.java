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

import tim1.backend.service.ZalbaNaOdlukuService;

@RestController
@RequestMapping(value = "/zalbe-na-odluku", consumes = "application/xml", produces = "application/xml")
public class ZalbaNaOdlukuController {

    @Autowired
    private ZalbaNaOdlukuService zalbaService;

    @GetMapping("/xml/{id}")
    public ResponseEntity<XMLResource> readZalbaXML(@PathVariable("id") String id) {
        XMLResource xml = zalbaService.readXML(id);
        return new ResponseEntity<>(xml, HttpStatus.OK);
    }

    @PostMapping("/xml/{id}")
    public ResponseEntity<?> saveZalbaXML(@PathVariable("id") String id, @RequestBody String content) {

        try {
            zalbaService.saveXML(id, content);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rdf/{uri}")
    public ResponseEntity<String> readZalbaRDF(@PathVariable("uri") String uri) {

        try {
            zalbaService.readRDF(uri);
            return new ResponseEntity<>("Successfully read!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/rdf/{id}/{uri}")
    public ResponseEntity<String> saveZalbaRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {

        try {
            zalbaService.saveRDF(id, uri);
            return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
