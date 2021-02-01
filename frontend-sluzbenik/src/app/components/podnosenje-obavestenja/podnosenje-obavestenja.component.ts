import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ObavestenjaService } from 'src/app/services/obavestenja-service/obavestenja.service';

declare const Xonomy: any;

@Component({
  selector: 'app-podnosenje-obavestenja',
  templateUrl: './podnosenje-obavestenja.component.html',
  styleUrls: ['./podnosenje-obavestenja.component.scss']
})
export class PodnosenjeObavestenjaComponent implements OnInit, AfterViewInit {

  constructor(private obavestenjaService: ObavestenjaService) { }

  ngAfterViewInit(): void {
    //prikaz xonomy editora
    let element = document.getElementById("editor");
    let xmlStr = '<Obavestenje> </Obavestenje>';
    let specification = this.obavestenjaService.obavestenjeSpecifikacija;
    Xonomy.render(xmlStr, element, specification);
  }

  ngOnInit(): void {
  }

  send(): void {

  }

}
