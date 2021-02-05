package tim1.backend.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.tools.ant.util.ReaderInputStream;
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
import tim1.backend.model.zalbaodluka.ZalbaNaOdluku;
import tim1.backend.service.ZalbaNaOdlukuService;

@RestController
@RequestMapping(value = "/zalbe-na-odluku")
public class ZalbaNaOdlukuController {

    @Autowired
    private ZalbaNaOdlukuService zalbaService;

    @GetMapping(path = "/xml/{id}", produces = "application/xml")
    public ResponseEntity<String> getXML(@PathVariable("id") String id) {

        try {
            XMLResource xml = zalbaService.readXML(id);
            return new ResponseEntity<>(xml.getContent().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/xml", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) {
        String documentId = UUID.randomUUID().toString();
        InputStream inputStream = new ReaderInputStream(new StringReader(content));
        try {
            JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZalbaNaOdluku zalbaNaOdluku = (ZalbaNaOdluku) unmarshaller.unmarshal(inputStream);
            zalbaNaOdluku.setId(documentId);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            marshaller.marshal(zalbaNaOdluku, stream);
            String finalString = new String(stream.toByteArray());
            System.out.println(finalString);
            content = finalString;
        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            System.out.println("unmarshaller error");
            e1.printStackTrace();
        }
        try {
            zalbaService.saveXML(documentId, content);
            zalbaService.saveRDF(content,documentId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path= "/rdf-xml/{uri}", produces = "application/xml")
    public ResponseEntity<String> getRdfAsXML(@PathVariable("uri") String uri) {

        try {
            String rdf = zalbaService.readFileAsXML(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/rdf-json/{uri}", produces = "application/json")
    public ResponseEntity<String> getRdfAsJSON(@PathVariable("uri") String uri) {

        try {
            String rdf = zalbaService.readFileAsJSON(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<ZalbaNaOdluku>> findAllFromCollection() throws Exception{

        try {
            JaxbLista<ZalbaNaOdluku> lista = zalbaService.findAllFromCollection();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
