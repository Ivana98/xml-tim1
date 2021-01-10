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

import tim1.backend.service.ZalbaNaCutanjeService;

@RestController
@RequestMapping(value = "/zalba-na-cutenje")
public class ZalbaNaCutanjeController {

    @Autowired
    private ZalbaNaCutanjeService zalbaService;

    @GetMapping("/XML/{id}")
    public ResponseEntity<XMLResource> readZalbaXML(@PathVariable("id") String id) {
        XMLResource xml = zalbaService.readXML(id);
        return new ResponseEntity<>(xml, HttpStatus.OK);
    }

    @PostMapping("/XML/{id}")
    public ResponseEntity<String> saveZalbaXML(@PathVariable("id") String id) {
        zalbaService.saveXML(id);
        return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    }

    @GetMapping("/RDF/{uri}")
    public ResponseEntity<String> readZalbaRDF(@PathVariable("uri") String uri) {
        zalbaService.readRDF(uri);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/RDF/{id}/{uri}")
    public ResponseEntity<String> saveZalbaRDF(@PathVariable("id") String id, @PathVariable("uri") String uri) {
        zalbaService.saveRDF(id, uri);
        return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
    }

}
