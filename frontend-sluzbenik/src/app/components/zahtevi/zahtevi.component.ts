import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Zahtev } from 'src/app/model/zahtev';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-zahtevi',
  templateUrl: './zahtevi.component.html',
  styleUrls: ['./zahtevi.component.scss']
})
export class ZahteviComponent implements OnInit {
  displayedColumns: string[] = ['id', 'naziv', 'status', 'izvoz'];
  dataSource: MatTableDataSource<Zahtev>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = '';
  email = "";

  zahtevi: Zahtev[] = [];

  constructor(
    private router: Router,
    private zahtevService: ZahtevService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    console.log("On init");
    this.role = this.authService.getRole();
    this.email = this.authService.getEmail();
    // console.log(this.email);
    this.getAll();
  }

  async getAll() {

    let lista = await this.zahtevService.getAll().toPromise();
    lista = lista["jaxbLista"]["ns4:zahtev"];

    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    // gradjanin moze da vidi samo svoje zalbe
    // dok poverenik moze da vidi sve zalbe
    if (this.role == "GRADJANIN") {
      lista = lista.filter(zalba => zalba["ns4:trazilac"]["$"]["email"] == this.email);
    }


    lista.forEach(element => {
      // console.log(element["ns4:trazilac"]["$"]["email"]);
      this.zahtevi.push(new Zahtev(element["$"]["id"], element["ns4:naslov"], element["$"]["content"]));
    })

    this.dataSource = new MatTableDataSource<Zahtev>(this.zahtevi);
  }

  getHtml(id: string){
    this.zahtevService.getHtml(id).subscribe(
      data => {
        let file = new Blob([data], { type: 'text/html' });
        var fileURL = URL.createObjectURL(file);

        let a = document.createElement('a');
        document.body.appendChild(a);
        a.setAttribute('style', 'display: none');
        a.href = fileURL;
        a.download = `zahtev_${id}.html`;
        a.click();
        window.URL.revokeObjectURL(fileURL);
        a.remove();
      }
    );
  }

  getPdf(id: string) {
    this.zahtevService.getPdf(id).subscribe(
      data => {
        let file = new Blob([data], { type: 'application/pdf' });
        var fileURL = URL.createObjectURL(file);

        let a = document.createElement('a');
        document.body.appendChild(a);
        a.setAttribute('style', 'display: none');
        a.href = fileURL;
        a.download = `zahtev_${id}.pdf`;
        a.click();
        window.URL.revokeObjectURL(fileURL);
        a.remove();
      }
    );
  }

}
