package tim1.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.sluzbenik.model.izvestaj.Izvestaj;
import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.service.IzvestajService;

@RestController
@RequestMapping(value = "/izvestaji")
public class IzvestajController {
  
  @Autowired
  IzvestajService izvestajService;


  @GetMapping(path = "/podnesi-izvestaj")
  public ResponseEntity<?> podnesiIzvestaj(){
    try{
      izvestajService.podnesiIzvestaj();
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    catch(Exception e){
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(path = "/xml", produces = "application/xml")
  public ResponseEntity<JaxbLista<Izvestaj>> findAllFromCollection() throws Exception {

      try {
          JaxbLista<Izvestaj> lista = izvestajService.findAllFromCollection();
          return new ResponseEntity<>(lista, HttpStatus.OK);
      } catch (Exception e) {
          e.printStackTrace();
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
  }
}
