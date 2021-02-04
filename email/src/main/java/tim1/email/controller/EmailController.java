package tim1.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import tim1.email.service.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {
  
  @Autowired
  private EmailService emailService;

  @PostMapping(path = "odobriZahtev", consumes = "multipart/form-data")
  public ResponseEntity<?> sendEmail(@RequestPart("email") String email ,@RequestPart("content") String content){
    System.out.println(email);
    System.out.println("======================");
    System.out.println(content);
    try{
      emailService.posaljiMejl(email, "zahtev odobren", content);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    catch(Exception e){
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
