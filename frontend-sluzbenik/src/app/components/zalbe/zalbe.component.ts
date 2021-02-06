import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Zalba } from 'src/app/model/zalba';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZalbeService } from 'src/app/services/zalbe/zalbe.service';

@Component({
  selector: 'app-zalbe',
  templateUrl: './zalbe.component.html',
  styleUrls: ['./zalbe.component.css']
})
export class ZalbeComponent implements OnInit {

  displayedColumns: string[] = ['id', 'naziv', 'izvoz', 'email'];
  dataSource: MatTableDataSource<Zalba>;

  role = "";
  email = "";

  zalbe: Zalba[] = []

  constructor(
    private authService: AuthService,
    private zalbeService: ZalbeService
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.email = this.authService.getEmail();
    this.getAll()
  }

  async getAll() {
    this.zalbe = []; //praznimo listu svaki put kada je ponovo punimo

    await this.getAllCutanje();

    await this.getAllOdbijanje();

    this.dataSource = new MatTableDataSource<Zalba>(this.zalbe);
  }

  async getAllCutanje() {
    let lista = await this.zalbeService.getAllCutanje().toPromise();
    lista = lista["jaxbLista"]["ns3:Zalba_na_cutanje"];
    console.log(lista)
    this.dodajZalbeNaCutanje(lista);
  }

  async getAllOdbijanje() {
    let lista = await this.zalbeService.getAllOdbijanje().toPromise();
    lista = lista["jaxbLista"]["ns4:zalba_na_odluku"];
    console.log(lista)
    this.dodajZalbeNaOdluku(lista);
  }

  dodajZalbeNaCutanje(lista: any) {
    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    lista.forEach(element => {
      if (element["$"]["status"] == "na cekanju") {
        this.zalbe.push(new Zalba(element["$"]["id"], "Zalba na cutanje", element["ns3:Podnosilac_zalbe"]["$"]["email"]));
      }
    });
  }

  dodajZalbeNaOdluku(lista: any) {
    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    lista.forEach(element => {
      if (element["$"]["status"] == "na cekanju") {
        let id = element["$"]["id"];
        let korisnik = element["ns4:zalba"]["ns4:podnosilac"]["$"]["email"];
        this.zalbe.push(new Zalba(id, "Zalba na odluku", korisnik));
      }
    });

  }

  getHtml(id: string, name: string) {
    if (name === "zalba_na_odluku") {
      this.zalbeService.getHtmlOdluka(id).subscribe(
        data => {
          let file = new Blob([data], { type: 'text/html' });
          var fileURL = URL.createObjectURL(file);

          let a = document.createElement('a');
          document.body.appendChild(a);
          a.setAttribute('style', 'display: none');
          a.href = fileURL;
          a.download = `zalba_${id}.html`;
          a.click();
          window.URL.revokeObjectURL(fileURL);
          a.remove();
        }
      );
    }
    else {
      this.zalbeService.getHtmlCutanje(id).subscribe(
        data => {
          let file = new Blob([data], { type: 'text/html' });
          var fileURL = URL.createObjectURL(file);

          let a = document.createElement('a');
          document.body.appendChild(a);
          a.setAttribute('style', 'display: none');
          a.href = fileURL;
          a.download = `zalba_${id}.html`;
          a.click();
          window.URL.revokeObjectURL(fileURL);
          a.remove();
        }
      );
    }
  }

  getPdf(id: string, name: string) {
    if (name === "zalba_na_odluku") {
      this.zalbeService.getPdfOdluka(id).subscribe(
        data => {
          let file = new Blob([data], { type: 'application/pdf' });
          var fileURL = URL.createObjectURL(file);

          let a = document.createElement('a');
          document.body.appendChild(a);
          a.setAttribute('style', 'display: none');
          a.href = fileURL;
          a.download = `zalba_${id}.pdf`;
          a.click();
          window.URL.revokeObjectURL(fileURL);
          a.remove();
        }
      );
    }
    else {
      this.zalbeService.getPdfCutanje(id).subscribe(
        data => {
          let file = new Blob([data], { type: 'application/pdf' });
          var fileURL = URL.createObjectURL(file);

          let a = document.createElement('a');
          document.body.appendChild(a);
          a.setAttribute('style', 'display: none');
          a.href = fileURL;
          a.download = `zalba_${id}.pdf`;
          a.click();
          window.URL.revokeObjectURL(fileURL);
          a.remove();
        }
      );
    }

  }

}
