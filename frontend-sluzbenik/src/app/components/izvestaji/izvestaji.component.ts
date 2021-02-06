import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Izvestaj } from 'src/app/model/izvestaj';
import { AuthService } from 'src/app/services/auth/auth.service';
import { IzvestajiService } from 'src/app/services/izvestaji/izvestaji.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-izvestaji',
  templateUrl: './izvestaji.component.html',
  styleUrls: ['./izvestaji.component.scss'],
})
export class IzvestajiComponent implements OnInit {
  displayedColumns: string[] = ['odbijeniZahtevi', 'odobreniZahtevi', 'resenja', 'sveZalbe', 'sviZahtevi', 'zalbeNaCutanje', 'zalbeNaOdluku'];
  dataSource: MatTableDataSource<Izvestaj>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = '';
  email = "";

  izvestaji: Izvestaj[] = [];

  constructor(
    private izvestajService: IzvestajiService,
    private authService: AuthService,
    private snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.email = this.authService.getEmail();
    this.getAll();
  }

  async getAll() {
    this.izvestaji = []
    let lista = await this.izvestajService.getAll().toPromise();
    lista = lista["jaxbLista"]["Izvestaj"];
    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    lista.forEach(element =>{
      this.izvestaji.push(
        new Izvestaj(
          element['$']['odbijeniZahtevi'], 
          element['$']['odobreniZahtevi'], 
          element['$']['resenja'], 
          element['$']['sveZalbe'], 
          element['$']['sviZahtevi'], 
          element['$']['zalbeNaCutanje'], 
          element['$']['zalbeNaOdluku'] 
        )
      );
    });

    this.dataSource = new MatTableDataSource<Izvestaj>(this.izvestaji);
  }

  podnesiNoviIzvestaj() {
    console.log("hello");
    this.izvestajService.podnesiIzvestaj().subscribe(
      response => {
        console.log(response);
        this.openSnackBar("Izvestaj je uspesno kreiran. Poverenik je obavesten o novom izvestaju");
        this.getAll();
      },
      error => {
        this.openSnackBar("Doslo je do greske prilikom podnosenja izvestaja. Probajte ponovo.");
      }
    )
  }

  openSnackBar(message: string): void {
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}
