package tim1.sluzbenik.controller;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.util.ReaderInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.sluzbenik.model.korisnici.Korisnik;
import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.obavestenje.Obavestenje;
import tim1.sluzbenik.model.zahtev.Zahtev;
import tim1.sluzbenik.service.ZahtevService;
import tim1.sluzbenik.soap.client.EmailClient;

@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevController {

    @Autowired
    private ZahtevService zahtevService;

    @Autowired
    private EmailClient emailClient;

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
            Zahtev zahtev = (Zahtev) unmarshaller.unmarshal(inputStream);
            zahtev.setId(documentId);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            marshaller.marshal(zahtev, stream);
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

            this.timer(documentId);
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
    public ResponseEntity<JaxbLista<Zahtev>> findAllFromCollection() throws Exception {

        try {
            JaxbLista<Zahtev> lista = zahtevService.findAllFromCollection();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/odbijanje/{idZahteva}", produces = "application/xml")
    public ResponseEntity<?> odbijanjeZahteva(@PathVariable String idZahteva) {
        // TODO: Marija trebas da ubacis ovde emailTo je email korisnika, subject
        // promeni, i u content ubaci idZahteva.
        // Ne zaboravi moras imati pokrenute aplikacije email i sluzbenik.
        XMLResource zahtevxml = zahtevService.readXML(idZahteva);
        //InputStream inputStream = new ReaderInputStream(new StringReader(content));
        try {
            InputStream inputStream = new ReaderInputStream(new StringReader(zahtevxml.getContent().toString()));
            JAXBContext contextZahtev = JAXBContext.newInstance(Zahtev.class);
            Unmarshaller unmarshallerZahtev = contextZahtev.createUnmarshaller();
            Zahtev zahtev = (Zahtev) unmarshallerZahtev.unmarshal(inputStream);
            String email;
            System.out.println(zahtev.getTrazilac().getEmail());
            if(zahtev.getTrazilac().getEmail() != null){
                email = zahtev.getTrazilac().getEmail();  
                if(email.equals("")){
                    email = "konstrukcijaitestiranje@gmail.com";
                }  
            }
            else {
                email = "konstrukcijaitestiranje@gmail.com";
            }

            emailClient.odbijZahtev(email, "Vas zahtev se odbija", "Vas zahtev "+ idZahteva + " se odbija jer ne zelimo da vam isporucimo dokumenta");
            zahtev.setContent("odbijen");

            Marshaller marshallerZahtev = contextZahtev.createMarshaller();
            marshallerZahtev.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            marshallerZahtev.marshal(zahtev, stream);
            String finalStringZahtev = new String(stream.toByteArray());

            zahtevService.saveXML(idZahteva, finalStringZahtev);
            zahtevService.saveRDF(finalStringZahtev, idZahteva);

        } catch (XMLDBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping(path = "/odobravanje", consumes = "application/xml")
    public ResponseEntity<?> odobravanjeZahteva(@RequestBody String content) {
        // TODO: Marija trebas da ubacis ovde emailTo je email korisnika, subject
        // promeni, i u content ubaci idZahteva. Takodje dodaj lokalne putanje do pdf i
        // html fajlova. Putanje dobijes kada pozoves:
        // this.zahtevService.generateHTML(id); to je ivana pravila
        // Ne zaboravi moras imati pokrenute aplikacije email i sluzbenik.
        // Korisnik user = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // System.out.println(user.getKorisnickoIme());
        InputStream inputStream = new ReaderInputStream(new StringReader(content));
        try {
            JAXBContext context = JAXBContext.newInstance(Obavestenje.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Obavestenje obavestenje = (Obavestenje) unmarshaller.unmarshal(inputStream);

            String idZahteva = obavestenje.getIdZahteva();
            XMLResource zahtevxml = zahtevService.readXML(idZahteva);
            InputStream inputStream1;
            try {
                inputStream1 = new ReaderInputStream(new StringReader(zahtevxml.getContent().toString()));
                JAXBContext contextZahtev = JAXBContext.newInstance(Zahtev.class);
                Unmarshaller unmarshallerZahtev = contextZahtev.createUnmarshaller();
                Zahtev zahtev = (Zahtev) unmarshallerZahtev.unmarshal(inputStream1);

                String email;
                if(zahtev.getTrazilac().getEmail() != null){
                    email = zahtev.getTrazilac().getEmail();  
                    if(email.equals("")){
                        email = "konstrukcijaitestiranje@gmail.com";
                    }  
                }
                else {
                    email = "konstrukcijaitestiranje@gmail.com";
                }

                String htmlPath = this.zahtevService.generateHTML(obavestenje.getId());
                
                emailClient.odobriZahtev(email,"Vas zahtev se odobrava" , "Zahtev " + idZahteva + "je odobren.", "asdf.pdf", htmlPath);
                zahtev.setContent("odobren");

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
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/generateHTML/{id}")
    public ResponseEntity<byte[]> generisiHTML(@PathVariable("id") String id) throws XMLDBException {

        // uses id of zahtev
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

    public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }

    public void timer(String id) {

        TimerTask task = new TimerTask() {

            public void run() {
                this.cutanje(id);
                System.out.println("Task performed on: " + new Date() + "n" +
                "Thread's name: " + Thread.currentThread().getName());
            }

            private void cutanje(String id) {
                XMLResource zahtevxml = zahtevService.readXML(id);
                InputStream inputStream1;
                try {
                    inputStream1 = new ReaderInputStream(new StringReader(zahtevxml.getContent().toString()));
                    JAXBContext contextZahtev = JAXBContext.newInstance(Zahtev.class);
                    Unmarshaller unmarshallerZahtev = contextZahtev.createUnmarshaller();
                    Zahtev zahtev = (Zahtev) unmarshallerZahtev.unmarshal(inputStream1);
                    if(zahtev.getContent().equals("na cekanju")){
                        zahtev.setContent("nema odgovora");
                        
                        Marshaller marshallerZahtev = contextZahtev.createMarshaller();
                        marshallerZahtev.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                        marshallerZahtev.marshal(zahtev, stream1);
                        String finalStringZahtev = new String(stream1.toByteArray());

                        zahtevService.saveXML(zahtev.getId(), finalStringZahtev);
                        zahtevService.saveRDF(finalStringZahtev, zahtev.getId());
                    }

                } catch (XMLDBException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Timer timer = new Timer("Timer");
        
        long delay = 2 * 60 * 1000L; //2 minuta
        timer.schedule(task, delay);
    }


    public void cutanjeTask(String idZahteva){
        
        XMLResource zahtevxml = zahtevService.readXML(idZahteva);
        InputStream inputStream1;
        try {
            inputStream1 = new ReaderInputStream(new StringReader(zahtevxml.getContent().toString()));
            JAXBContext contextZahtev = JAXBContext.newInstance(Zahtev.class);
            Unmarshaller unmarshallerZahtev = contextZahtev.createUnmarshaller();
            Zahtev zahtev = (Zahtev) unmarshallerZahtev.unmarshal(inputStream1);

            // String email;
            // if(zahtev.getTrazilac().getEmail() != null){
            //     email = zahtev.getTrazilac().getEmail();  
            //     if(email.equals("")){
            //         email = "konstrukcijaitestiranje@gmail.com";
            //     }  
            // }
            // else {
            //     email = "konstrukcijaitestiranje@gmail.com";
            // }
            // emailClient.odobriZahtev(email,"Vas zahtev se odobrava" , "Zahtev " + idZahteva + "je odobren.", "asdf.pdf", htmlPath);
            
            if(zahtev.getContent().equals("na cekanju")){
                zahtev.setContent("nema odgovora");
                
                Marshaller marshallerZahtev = contextZahtev.createMarshaller();
                marshallerZahtev.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                marshallerZahtev.marshal(zahtev, stream1);
                String finalStringZahtev = new String(stream1.toByteArray());
    
                zahtevService.saveXML(zahtev.getId(), finalStringZahtev);
                zahtevService.saveRDF(finalStringZahtev, zahtev.getId());
            }

        } catch (XMLDBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
