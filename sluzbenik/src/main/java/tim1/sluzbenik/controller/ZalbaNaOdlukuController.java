package tim1.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zalbaodluka.ZalbaNaOdluku;
import tim1.sluzbenik.soap.client.ZalbeClient;

@RestController
@RequestMapping(value = "/zalbe-na-odluku")
public class ZalbaNaOdlukuController {

    @Autowired
    private ZalbeClient zalbeClient;
    
    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<JaxbLista<ZalbaNaOdluku>> findAllFromCollection() throws Exception{

        try {
            JaxbLista<ZalbaNaOdluku> lista = zalbeClient.getAllZalbaNaOdluku();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
