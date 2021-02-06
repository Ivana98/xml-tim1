import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Zalba } from 'src/app/model/zalba';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZalbaService } from 'src/app/services/zalba/zalba.service';

@Component({
  selector: 'app-zalbe',
  templateUrl: './zalbe.component.html',
  styleUrls: ['./zalbe.component.scss']
})
export class ZalbeComponent implements OnInit {
  displayedColumns: string[] = ['id', 'naziv', 'izvoz', 'email', 'status', 'resenje'];
  dataSource: MatTableDataSource<Zalba>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = "";
  email = "";

  zalbe: Zalba[] = []

  constructor(
    private authService: AuthService,
    private zalbeService: ZalbaService
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
    // console.log(lista)
    lista = lista["jaxbLista"]["ns3:Zalba_na_cutanje"];
    this.dodajZalbeNaCutanje(lista);
  }

  async getAllOdbijanje() {
    let lista = await this.zalbeService.getAllOdbijanje().toPromise();
    lista = lista["jaxbLista"]["ns4:zalba_na_odluku"];
    // console.log(lista);
    this.dodajZalbeNaOdluku(lista);
  }

  dodajZalbeNaCutanje(lista: any) {
    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    // gradjanin moze da vidi samo svoje zalbe
    // dok poverenik moze da vidi sve zalbe
    if (this.role == "GRADJANIN") {
      lista = lista.filter(zalba => zalba["ns3:Podnosilac_zalbe"]["$"]["email"] == this.email);
    }

    lista.forEach(element => {
      this.zalbe.push(new Zalba(element["$"]["id"], "Zalba na cutanje", element["ns3:Podnosilac_zalbe"]["$"]["email"], element["$"]["status"]))
    });
  }

  dodajZalbeNaOdluku(lista: any) {
    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    // gradjanin moze da vidi samo svoje zalbe
    // dok poverenik moze da vidi sve zalbe
    if (this.role == "GRADJANIN") {
      lista = lista.filter(zalba => zalba["ns4:zalba"]["ns4:podnosilac"]["$"]["email"] == this.email);
    }

    lista.forEach(element => {
      let id = element["$"]["id"];
      let korisnik = element["ns4:zalba"]["ns4:podnosilac"]["$"]["email"];
      this.zalbe.push(new Zalba(id, "Zalba na odluku", korisnik,  element["$"]["status"]));
    });

  }

  getHtml(id: string, name: string){
    if(name === "zalba_na_odluku"){
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

}
