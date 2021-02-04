package tim1.sluzbenik.controller;

import java.util.List;
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

import tim1.sluzbenik.soap.client.ZalbeClient;

@RestController
@RequestMapping(value = "/zalbe-na-cutenje")
public class ZalbaNaCutanjeController {

    @Autowired
    ZalbeClient zalbeClient;

    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<?> findAllFromCollection() throws Exception{

        try {
            String listaZalbi = zalbeClient.getAllZalbaNaCutanje();
            return new ResponseEntity<>(listaZalbi, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
