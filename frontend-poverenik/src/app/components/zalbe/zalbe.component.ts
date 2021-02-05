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
  displayedColumns: string[] = ['id', 'naziv', 'korisnik', 'izvoz'];
  dataSource: MatTableDataSource<Zalba>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = "";

  zalbe: Zalba[] = []

  constructor(
    private authService: AuthService,
    private zalbeService: ZalbaService
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.getAll()
  }

  getAll() {
    this.getAllCutanje();
    // this.getAllOdbijanje(); //TODO: ovo baca gresku neku. pogledati sam marijom
  }

  getAllCutanje() {
    this.zalbeService.getAllCutanje()
      .subscribe(
        data => {
          let lista = data["jaxbLista"]["ns3:Zalba_na_cutanje"];
          console.log(lista)

          lista.forEach(element => {
            console.log(element["ns3:Podnosilac_zalbe"]["$"]["email"])
            this.zalbe.push(new Zalba(element["$"]["id"], "Zalba na cutanje", element["ns3:Podnosilac_zalbe"]["$"]["email"]))
          });

          this.dataSource = new MatTableDataSource<Zalba>(this.zalbe);
        }
      );
  }

  getAllOdbijanje() {
    this.zalbeService.getAllOdbijanje()
      .subscribe(
        data => {
          console.log("zalbe odbijanje")
          console.log(data);
        }
      );
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
