import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Console } from 'console';
import { Zalba } from 'src/app/model/zalba';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZalbaService } from 'src/app/services/zalba/zalba.service';

@Component({
  selector: 'app-zalbe',
  templateUrl: './zalbe.component.html',
  styleUrls: ['./zalbe.component.scss']
})
export class ZalbeComponent implements OnInit {
  displayedColumns: string[] = ['id', 'naziv', 'izvoz', 'resenje'];
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

    //TODO: ovo baca gresku neku. pogledati sam marijom
    await this.getAllOdbijanje();

    this.dataSource = new MatTableDataSource<Zalba>(this.zalbe);


  }

  async getAllCutanje() {
    let lista = await this.zalbeService.getAllCutanje().toPromise();
    lista = lista["jaxbLista"]["ns3:Zalba_na_cutanje"];
    console.log(lista);
    this.dodajZalbeNaCutanje(lista);
  }

  async getAllOdbijanje() {
    let lista = await this.zalbeService.getAllOdbijanje().toPromise();
    lista = lista["jaxbLista"]["ns4:zalba_na_odluku"];
    // console.log(lista);
    this.dodajZalbeNaOdluku(lista);
  }

  dodajZalbeNaCutanje(lista: any[]) {
    // gradjanin moze da vidi samo svoje zalbe
    // dok poverenik moze da vidi sve zalbe
    if (this.role == "KORISNIK") {
      lista = lista.filter(zalba => zalba["ns3:Podnosilac_zalbe"]["$"]["email"] == this.email);
    }

    lista.forEach(element => {
      this.zalbe.push(new Zalba(element["$"]["id"], "Zalba na cutanje", element["ns3:Podnosilac_zalbe"]["$"]["email"]))
    });
  }

  dodajZalbeNaOdluku(lista: any[]) {
    // gradjanin moze da vidi samo svoje zalbe
    // dok poverenik moze da vidi sve zalbe
    if (this.role == "KORISNIK") {
      lista = lista.filter(zalba => zalba["ns4:zalba"]["ns4:podnosilac"]["$"]["email"] == this.email);
    }

    lista.forEach(element => {
      let id = element["$"]["id"];
      let korisnik = element["ns4:zalba"]["ns4:podnosilac"]["ns4:ime"]["_"] + ' ' + element["ns4:zalba"]["ns4:podnosilac"]["ns4:prezime"]["_"];
      this.zalbe.push(new Zalba(id, "Zalba na odluku", korisnik))
    });

  }



  requestPage(): void {
    let event = new PageEvent();
    event.pageIndex = this.pageIndex;
    event.pageSize = this.pageSize;

    this.dataSource = new MatTableDataSource<Zalba>(this.zalbe);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.zalbe.length;
    //this.paginator.length = result.body.count;

  }

  getPage(event: PageEvent) {
    this.dataSource = new MatTableDataSource<Zalba>(this.zalbe);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.zalbe.length;
    return event;
  }

}
