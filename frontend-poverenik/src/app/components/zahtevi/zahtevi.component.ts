import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
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

  resenja: Zahtev[] = [
    {
      id: 1,
      naziv: 'Zahtev 1',
      sediste: "sediste 1",
      datum: "02.02.2021",
      upravaCuti: false,
      odbijen: true
    },
    {
      id: 2,
      naziv: 'Zahtev 2',
      sediste: "sediste 2",
      datum: "12.01.2021",
      upravaCuti: true,
      odbijen: false
    },
    {
      id: 3,
      naziv: 'Zahtev 3',
      sediste: "sediste 3",
      datum: "01.002.2021",
      upravaCuti: false,
      odbijen: false
    },
  ]

  constructor(
    private authService: AuthService,
    private zahtevService: ZahtevService
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.dataSource = new MatTableDataSource<Zahtev>(this.resenja);
  }

  getAll() {
    this.zahtevService.getAll()
    .subscribe(
      data => {
        console.log(data);
      }
    )
  }

  requestPage(): void {
    let event = new PageEvent();
    event.pageIndex = this.pageIndex;
    event.pageSize = this.pageSize;

    this.dataSource = new MatTableDataSource<Zahtev>(this.resenja);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.resenja.length;
    //this.paginator.length = result.body.count;
  }

  getPage(event: PageEvent) {
    this.dataSource = new MatTableDataSource<Zahtev>(this.resenja);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.resenja.length;
    return event;
  }

}
