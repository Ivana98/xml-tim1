package tim1.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.sluzbenik.service.IzvestajService;

@RestController
@RequestMapping(value = "/izvestaji")
public class IzvestajController {
  
  @Autowired
  IzvestajService izvestajService;


  @PostMapping(path = "/podnesi-izvestaj")
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

}
