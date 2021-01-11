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

import tim1.backend.service.ObavestenjeService;

@RestController
@RequestMapping(value = "/obavestenja")
public class ObavestenjeController {

    @Autowired
    private ObavestenjeService obavestenjeService;

    @GetMapping(path = "/xml/{id}", produces = "application/xml")
    public ResponseEntity<String> getXML(@PathVariable("id") String id) {

        try {
            XMLResource obavestenje = obavestenjeService.readXML(id);
            return new ResponseEntity<>(obavestenje.getContent().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/xml", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) {
        String xmlName = UUID.randomUUID().toString();
        String rdfName = "RDF" + xmlName;
        try {
            System.out.println("save obavestenje");
            obavestenjeService.saveXML(xmlName, content);
            obavestenjeService.saveRDF(content, rdfName, xmlName);
            System.out.println("ovde");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rdf-xml/{uri}")
    public ResponseEntity<String> getRdfAsXML(@PathVariable("uri") String uri) {

        try {
            String rdf = obavestenjeService.readFileAsXML(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rdf-json/{uri}")
    public ResponseEntity<String> getRdfAsJSON(@PathVariable("uri") String uri) {

        try {
            String rdf = obavestenjeService.readFileAsJSON(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // @PostMapping("/rdf/{id}/{uri}")
    // public ResponseEntity<String> saveRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {

    //     try {
    //         obavestenjeService.saveRDF(id, uri);
    //     return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }
    // }

}
