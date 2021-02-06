import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { parse } from 'js2xmlparser';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';

declare const Xonomy: any;

@Component({
  selector: 'app-podnosenje-zahteva',
  templateUrl: './podnosenje-zahteva.component.html',
  styleUrls: ['./podnosenje-zahteva.component.scss']
})
export class PodnosenjeZahtevaComponent implements OnInit, AfterViewInit {

  constructor(
    private router: Router,
    private zahtevService: ZahtevService
  ) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    //prikaz xonomy editora
    let element = document.getElementById("editor");
    let xmlStr = this.zahtevService.xmlString;
    let specification = this.zahtevService.obavestenjeSpecifikacija;
    Xonomy.render(xmlStr, element, specification);
  }

  send(): void {
    let text: string = Xonomy.harvest();
    // console.log(text);  // ispis xml-a koji se salje

    this.zahtevService.addNew(text)
      .subscribe(
        response => {
          console.log('poslat zahtev');
        }
      );

  }

}
