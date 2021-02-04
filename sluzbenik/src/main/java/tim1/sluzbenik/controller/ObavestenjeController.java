package tim1.sluzbenik.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import java.io.StringReader;
import java.io.StringWriter;

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
import org.xml.sax.InputSource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.obavestenje.Obavestenje;
import tim1.sluzbenik.model.zahtev.Zahtev;
import tim1.sluzbenik.service.ObavestenjeService;
import tim1.sluzbenik.service.ZahtevService;

@RestController
@RequestMapping(value = "/obavestenja")
public class ObavestenjeController {

    @Autowired
    private ObavestenjeService obavestenjeService;

    @Autowired
    private ZahtevService zahtevService;

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
        String documentId = UUID.randomUUID().toString();
        System.out.println("------------------------------------------");
        System.out.println(content);
        System.out.println("----------------------------------------------");
        InputStream inputStream = new ReaderInputStream(new StringReader(content));
        System.out.println("Ovde");
        try {
            JAXBContext context = JAXBContext.newInstance(Obavestenje.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Obavestenje obavestenje = (Obavestenje) unmarshaller.unmarshal(inputStream);
            obavestenje.setId(documentId);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            marshaller.marshal(obavestenje, stream);
            String finalString = new String(stream.toByteArray());
            System.out.println(finalString);
            content = finalString;

            String idZahteva = obavestenje.getIdZahteva();
            XMLResource zahtevxml = zahtevService.readXML(idZahteva);
            InputStream inputStream1;
            try {
                inputStream1 = new ReaderInputStream(new StringReader(zahtevxml.getContent().toString()));
                JAXBContext contextZahtev = JAXBContext.newInstance(Zahtev.class);
                Unmarshaller unmarshallerZahtev = contextZahtev.createUnmarshaller();
                Zahtev zahtev = (Zahtev) unmarshallerZahtev.unmarshal(inputStream1);
                zahtev.setContent("prihvacen");
                Marshaller marshallerZahtev = contextZahtev.createMarshaller();
                marshallerZahtev.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                marshallerZahtev.marshal(zahtev, stream1);
                String finalStringZahtev = new String(stream1.toByteArray());

                zahtevService.saveXML(zahtev.getId(), finalStringZahtev);
                zahtevService.saveRDF(finalStringZahtev, zahtev.getId());

            } catch (XMLDBException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("save xml exception");
                e.printStackTrace();
            }
            
            
        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            System.out.println("unmarshaller error");
            e1.printStackTrace();
        }
        try {
            
            obavestenjeService.saveXML(documentId, content);
            obavestenjeService.saveRDF(content, documentId);
            System.out.println("1111111111111111111111111");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/rdf-xml/{uri}", produces = "application/xml")
    public ResponseEntity<String> getRdfAsXML(@PathVariable("uri") String uri) {

        try {
            String rdf = obavestenjeService.readFileAsXML(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/rdf-json/{uri}", produces = "application/json")
    public ResponseEntity<String> getRdfAsJSON(@PathVariable("uri") String uri) {

        try {
            String rdf = obavestenjeService.readFileAsJSON(uri);
            return new ResponseEntity<>(rdf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<Obavestenje>> findAllFromCollection() {

        try {
            JaxbLista<Obavestenje> lista = obavestenjeService.findAllFromCollection();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/generateHTML/{id}")
	public ResponseEntity<byte[]> generateHTML(@PathVariable("id") String id) throws XMLDBException {

        //uses id of obavestenje
		String file_path = this.obavestenjeService.generateHTML(id);

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
