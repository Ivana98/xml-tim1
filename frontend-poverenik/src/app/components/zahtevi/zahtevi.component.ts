import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Resenje } from 'src/app/model/resenje';
import { Zahtev } from 'src/app/model/zahtev';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';

@Component({
  selector: 'app-zahtevi',
  templateUrl: './zahtevi.component.html',
  styleUrls: ['./zahtevi.component.scss']
})
export class ZahteviComponent implements OnInit {

  displayedColumns: string[] = ['id', 'naziv', 'izvoz', 'zalbe'];
  dataSource: MatTableDataSource<Zahtev>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = "";

  zahtevi: Zahtev[] = [];

  constructor(
    private authService: AuthService,
    private zahtevService: ZahtevService
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
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

    lista.forEach(element => {
      let dozvole = this.getDozvoleZaZalbu(element["$"]["content"]);
      this.zahtevi.push(new Zahtev(element["$"]["id"], element["ns4:info_organa"]["ns4:naziv"]["_"], element["ns4:info_organa"]["ns4:sediste"], element["ns4:datum"]["_"], dozvole[0], dozvole[1]))
    })

    this.dataSource = new MatTableDataSource<Zahtev>(this.zahtevi);
  }

  getDozvoleZaZalbu(content) {
    console.log(content);
    switch (content) {
      case "na cekanju":
        return [false, false];
      case "nema odgovora":
        return [true, false];
      case "odbijen":
        return [false, true];
      case "odobren":
        return [false, false];
      default:
        console.log("GRESKA !!! Promeni resenja u bazi.");
        return [false, false];
    }
  }

}
