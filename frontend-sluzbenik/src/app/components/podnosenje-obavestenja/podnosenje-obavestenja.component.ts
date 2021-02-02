import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ObavestenjaService } from 'src/app/services/obavestenja-service/obavestenja.service';

declare const Xonomy: any;

@Component({
  selector: 'app-podnosenje-obavestenja',
  templateUrl: './podnosenje-obavestenja.component.html',
  styleUrls: ['./podnosenje-obavestenja.component.scss']
})
export class PodnosenjeObavestenjaComponent implements OnInit, AfterViewInit {

  constructor(
    private obavestenjaService: ObavestenjaService,
  ) { }

  ngAfterViewInit(): void {
    //prikaz xonomy editora
    let element = document.getElementById("editor");
    let xmlStr = this.obavestenjaService.xmlString;
    let specification = this.obavestenjaService.obavestenjeSpecifikacija;
    Xonomy.render(xmlStr, element, specification);
  }

  ngOnInit(): void {
  }

  send(): void {
    let text: string = Xonomy.harvest();

    text = text.replace(this.obavestenjaService.searchArhivi, this.obavestenjaService.replaceArhivi);
    text = text.replace(this.obavestenjaService.searchImenovanom, this.obavestenjaService.replaceImenovanom);

    console.log(text);

    this.obavestenjaService.addNew(text)
    .subscribe(
      data => {
        console.log("dodato valjda")
      }
    );
  }

}
