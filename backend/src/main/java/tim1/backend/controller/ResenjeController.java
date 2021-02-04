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

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.resenje.Resenje;
import tim1.backend.service.ResenjeService;
import tim1.backend.soap.client.EmailClient;

@RestController
@RequestMapping(value = "/resenja")
public class ResenjeController {

    @Autowired
    private ResenjeService resenjeService;

    @Autowired
    private EmailClient emailClient;
    

    @GetMapping(path = "/xml/{id}", produces = "application/xml")
    public ResponseEntity<String> getXML(@PathVariable("id") String id) {

        try {
            XMLResource xml = resenjeService.readXML(id);
            return new ResponseEntity<>(xml.getContent().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/xml", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) {
        String documentId = UUID.randomUUID().toString();
        try {
            resenjeService.saveXML(documentId, content);
            resenjeService.saveRDF(content, documentId);            
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/xml/{idZalbe}", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content, @PathVariable String idZalbe) {
        String documentId = UUID.randomUUID().toString();
        try {
            resenjeService.saveXML(documentId, content);
            resenjeService.saveRDF(content, documentId);

            String sadrzajMejla = "U prilogu se nalazi resenje za zalbu broj: " + idZalbe;
            //TODO: POSLATI MEJL PRAVOM KORISNIKU
            //TODO: POSLATI I PDF I HTML
            emailClient.posaljiResenje("konstrukcijaitestiranje@gmail.com","Resenje" , sadrzajMejla , "asdf.pdf", "asdf.html");
            emailClient.posaljiResenje("konstrukcijaitestiranje@gmail.com","Resenje" , sadrzajMejla, "asdf.pdf", "asdf.html");

            
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/rdf-xml/{uri}", produces = "application/xml")
    public ResponseEntity<String> getRdfAsXML(@PathVariable("uri") String uri) {

        try {
            String rdf = resenjeService.readFileAsXML(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/rdf-json/{uri}", produces = "application/json")
    public ResponseEntity<String> getRdfAsJSON(@PathVariable("uri") String uri) {

        try {
            String rdf = resenjeService.readFileAsJSON(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<Resenje>> findAllFromCollection() throws Exception{

        try {
            JaxbLista<Resenje> lista = resenjeService.findAllFromCollection();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
