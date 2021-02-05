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
  displayedColumns: string[] = ['id', 'naziv', 'korisnik', 'izvoz', 'resenje'];
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

  getAll() {
    this.zalbe = []; //praznimo listu svaki put kada je ponovo punimo
    this.getAllCutanje();

    //TODO: ovo baca gresku neku. pogledati sam marijom
    // this.getAllOdbijanje(); 
  }

  getAllCutanje() {
    this.zalbeService.getAllCutanje()
      .subscribe(
        data => {
          let lista = data["jaxbLista"]["ns3:Zalba_na_cutanje"];

          console.log(lista);

          this.popuniListu(lista);
        }
      );
  }

  getAllOdbijanje() {
    this.zalbeService.getAllOdbijanje()
      .subscribe(
        data => {
          let lista = data["jaxbLista"]["ns3:Zalba_na_cutanje"];

          console.log(lista);

          this.popuniListu(lista);
        }
      );
  }

  popuniListu(lista) {
    lista.forEach(element => {
      // gradjanin moze da vidi samo svoje zalbe
      // dok poverenik moze da vidi sve zalbe
      if (this.role == "GRADJANIN") {
        if (element["ns3:Podnosilac_zalbe"]["$"]["email"] == this.email) {
          this.zalbe.push(new Zalba(element["$"]["id"], "Zalba na cutanje", element["ns3:Podnosilac_zalbe"]["$"]["email"]))
        }
      } else {
        this.zalbe.push(new Zalba(element["$"]["id"], "Zalba na cutanje", element["ns3:Podnosilac_zalbe"]["$"]["email"]))
      }
    });

    this.dataSource = new MatTableDataSource<Zalba>(this.zalbe);
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
