package tim1.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim1.sluzbenik.service.IzvestajService;

@RestController
@RequestMapping(value = "/izvestaji")
public class IzvestajController {
  
  @Autowired
  IzvestajService izvestajService;

  
}
