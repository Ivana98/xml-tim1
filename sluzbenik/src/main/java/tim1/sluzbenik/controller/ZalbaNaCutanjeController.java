package tim1.sluzbenik.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zalbacutanje.ZalbaNaCutanje;
import tim1.sluzbenik.soap.client.EmailClient;
import tim1.sluzbenik.soap.client.ZalbeClient;

@RestController
@RequestMapping(value = "/zalbe-na-cutenje")
public class ZalbaNaCutanjeController {

    @Autowired
    ZalbeClient zalbeClient;

    @Autowired
    EmailClient emailClient;

    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<ZalbaNaCutanje>> findAllFromCollection() throws Exception{

        try {
            JaxbLista<ZalbaNaCutanje>  listaZalbi = zalbeClient.getAllZalbaNaCutanje();
            return new ResponseEntity<>(listaZalbi, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @PostMapping(path = "/odgovor-povereniku-na-zalbu/{idZalbe}", consumes = "application/xml")
    public ResponseEntity<?>  posaljiMejlPovereniku(@RequestBody String content , @PathVariable("idZalbe") String idZalbe){

        try{
            //posalji mejl povereniku
            String subject = "Odgovor na zalbu broj: " + idZalbe;
            content += "\n Zalbu pogledajte na: http://localhost:4200/homepage/zalbe/";
            emailClient.odgovoriPovereniku("konstrukcijaitestiranje@gmail.com", subject, content);
            
            //promeni status zalbe na procitano
            zalbeClient.oznaciZalbuKaoProcitanu(idZalbe);
            
            return new ResponseEntity<>( HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
