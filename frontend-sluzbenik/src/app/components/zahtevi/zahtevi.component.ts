import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Zahtev } from 'src/app/model/zahtev';

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

  zahtevi: Zahtev[] = [
    {
      id: 1,
      naziv: 'Zahtev 1',
    },
    {
      id: 2,
      naziv: 'Zahtev 2',
    },
    // {
    //   id: 3,
    //   naziv: 'Zahtev 1',
    // },
    // {
    //   id: 4,
    //   naziv: 'Zahtev 2',
    // },
    // {
    //   id: 5,
    //   naziv: 'Zahtev 1',
    // },
    // {
    //   id: 6,
    //   naziv: 'Zahtev 2',
    // }
  ];

  constructor(private router: Router) { 
    this.dataSource = new MatTableDataSource<Zahtev>(this.zahtevi);
    
  }

  ngOnInit(): void {
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
