import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ObavestenjaService } from 'src/app/services/obavestenja-service/obavestenja.service';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';

declare const Xonomy: any;

@Component({
  selector: 'app-podnosenje-obavestenja',
  templateUrl: './podnosenje-obavestenja.component.html',
  styleUrls: ['./podnosenje-obavestenja.component.scss']
})
export class PodnosenjeObavestenjaComponent implements OnInit, AfterViewInit {
  zahtevId: string;

  constructor(
    private obavestenjaService: ObavestenjaService,
    private zahtevService: ZahtevService,
    private _Activatedroute: ActivatedRoute,
  ) { 
    this.zahtevId = this._Activatedroute.snapshot.paramMap.get('id') || "1";

  }

  ngAfterViewInit(): void {
    //prikaz xonomy editora
    console.log(this.zahtevId);
    let element = document.getElementById("editor");
    let xmlStr = this.obavestenjaService.getXmlString(this.zahtevId);
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
        console.log("dodato")
      },
      error => {
        console.log(error);
      }
    );

  }

}
