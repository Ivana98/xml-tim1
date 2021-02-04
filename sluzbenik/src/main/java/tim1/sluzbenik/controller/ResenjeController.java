package tim1.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.sluzbenik.soap.client.ResenjeClient;

@RestController
@RequestMapping(value = "/resenja")
public class ResenjeController {
  @Autowired
  private ResenjeClient client;

  @GetMapping(path = "/xml", produces = "application/xml")
  public ResponseEntity<?> findAllFromCollection() throws Exception{

      try {
          String listaResenje = client.getAllResenje();
          return new ResponseEntity<>(listaResenje, HttpStatus.OK);
      } catch (Exception e) {
          e.printStackTrace();
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
  }
}