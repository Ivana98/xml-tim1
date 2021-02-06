import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { parse } from 'js2xmlparser';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';
import { MatSnackBar } from '@angular/material/snack-bar';
declare const Xonomy: any;

@Component({
  selector: 'app-podnosenje-zahteva',
  templateUrl: './podnosenje-zahteva.component.html',
  styleUrls: ['./podnosenje-zahteva.component.scss']
})
export class PodnosenjeZahtevaComponent implements OnInit, AfterViewInit {

  constructor(
    private router: Router,
    private zahtevService: ZahtevService,
    private snackBar: MatSnackBar,
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
          this.openSnackBar("Uspesno ste kreirali zahtev");
          this.router.navigate(['/homepage/zahtevi']);
        },
        error =>{
          this.openSnackBar("Niste uspesno ste kreirali zahtev");
          this.router.navigate(['/homepage/zahtevi']);
        }
      );

  }

  openSnackBar(message: string): void{
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}
