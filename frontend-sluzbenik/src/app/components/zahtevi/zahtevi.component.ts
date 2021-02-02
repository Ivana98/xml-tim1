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
  displayedColumns: string[] = ['id', 'naziv', 'izvoz'];
  dataSource: MatTableDataSource<Zahtev>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = '';

  zahtevi: Zahtev[] = [
    {
      id: 1,
      naziv: 'Zahtev 1',
    },
    {
      id: 2,
      naziv: 'Zahtev 2',
    }
  ];

  constructor(
    private router: Router,
    private zahtevService: ZahtevService,
    private authService: AuthService
    ) { 
    this.dataSource = new MatTableDataSource<Zahtev>(this.zahtevi);
    
  }

  ngOnInit(): void {
    console.log("On init");
    this.role == this.authService.getRole();
    console.log("ROLE");
    console.log(this.role);
    //this.getAll();
  }

  getAll(){
    this.zahtevService.getAll().subscribe(result => {
      console.log(result);
      //this.dataSource = new MatTableDataSource<Zahtev>(result.body.zahtevi);
    })
    //this.role == this.authService.getRole();
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
