package tim1.backend.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
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
import org.xmldb.api.base.XMLDBException;
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
        
        try {
            zalbaService.saveXML(UUID.randomUUID().toString(), content);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
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

    @GetMapping("/generateHTML/{id}")
	public ResponseEntity<byte[]> generateHTML(@PathVariable("id") String id) throws XMLDBException {

        //uses id of obavestenje
		String file_path = this.zalbaService.generateHTML(id);

		try {
			File file = new File(file_path);
			FileInputStream fileInputStream = new FileInputStream(file);
			return new ResponseEntity<byte[]>(IOUtils.toByteArray(fileInputStream), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

    }
}
