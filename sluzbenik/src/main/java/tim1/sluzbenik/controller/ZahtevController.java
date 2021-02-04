package tim1.sluzbenik.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.util.ReaderInputStream;

import javax.websocket.server.PathParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zahtev.Zahtev;
import tim1.sluzbenik.service.ZahtevService;


@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevController {

    @Autowired
    private ZahtevService zahtevService;

    @GetMapping(path = "/xml/{id}", produces = "application/xml")
    public ResponseEntity<String> getXML(@PathVariable("id") String id) throws XMLDBException {

        try {
            XMLResource zahtev = zahtevService.readXML(id);
            return new ResponseEntity<>(zahtev.getContent().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/xml", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content) {

        String documentId = UUID.randomUUID().toString();
        InputStream inputStream = new ReaderInputStream(new StringReader(content));
        try {
            JAXBContext context = JAXBContext.newInstance(Zahtev.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Zahtev obavestenje = (Zahtev) unmarshaller.unmarshal(inputStream);
            obavestenje.setId(documentId);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            marshaller.marshal(obavestenje, stream);
            String finalString = new String(stream.toByteArray());
            System.out.println(finalString);
            content = finalString;
        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            System.out.println("unmarshaller error");
            e1.printStackTrace();
        }

        try {
            
            zahtevService.saveXML(documentId, content);
            zahtevService.saveRDF(content, documentId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/xml/{idZahteva}", consumes = "application/xml")
    public ResponseEntity<?> saveXML(@RequestBody String content, @PathVariable String idZahteva) {
        try {
            
            zahtevService.saveXML(idZahteva, content);
            zahtevService.saveRDF(content, idZahteva);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/rdf-xml/{uri}", produces = "application/xml")
    public ResponseEntity<String> getRdfAsXML(@PathVariable("uri") String uri) {

        try {
            String rdf = zahtevService.readFileAsXML(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/rdf-json/{uri}", produces = "application/json")
    public ResponseEntity<String> getRdfAsJSON(@PathVariable("uri") String uri) {

        try {
            String rdf = zahtevService.readFileAsJSON(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<Zahtev>> findAllFromCollection() throws Exception{

        try {
            JaxbLista<Zahtev> lista = zahtevService.findAllFromCollection();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/generateHTML/{id}")
	public ResponseEntity<byte[]> generateHTML(@PathVariable("id") String id) throws XMLDBException {

        //uses id of zahtev
		String file_path = this.zahtevService.generateHTML(id);

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
