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

  getAll() {
    this.zahtevService.getAll()
      .subscribe(
        data => {
          console.log(data)
          this.zahtevi = [];  // clear list
          data["jaxbLista"]["ns4:zahtev"].forEach(element => {
            //TODO: uprava cuti - treba proveriti datum koliko je star
            //TODO: odbijen - treba proveriti da li je odbijen
            this.zahtevi.push(new Zahtev(element["$"]["id"], element["ns4:info_organa"]["ns4:naziv"]["_"], element["ns4:info_organa"]["ns4:sediste"], element["ns4:datum"]["_"], true, true))
          });

          this.dataSource = new MatTableDataSource<Zahtev>(this.zahtevi);
        }
      )
  }

  requestPage(): void {
    let event = new PageEvent();
    event.pageIndex = this.pageIndex;
    event.pageSize = this.pageSize;

    this.dataSource = new MatTableDataSource<Zahtev>(this.zahtevi);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.zahtevi.length;
    //this.paginator.length = result.body.count;
  }

  getPage(event: PageEvent) {
    this.dataSource = new MatTableDataSource<Zahtev>(this.zahtevi);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.zahtevi.length;
    return event;
  }

}
