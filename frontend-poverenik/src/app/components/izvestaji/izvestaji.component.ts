import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Izvestaj } from 'src/app/model/izvestaj';

@Component({
  selector: 'app-izvestaji',
  templateUrl: './izvestaji.component.html',
  styleUrls: ['./izvestaji.component.scss'],
})
export class IzvestajiComponent implements OnInit {
  displayedColumns: string[] = ['id', 'naziv', 'izvoz'];
  dataSource: MatTableDataSource<Izvestaj>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;
  

  izvestaji: Izvestaj[] = [
    {
      id: 1,
      naziv: 'Izvestaj 1',
    },
    {
      id: 2,
      naziv: 'Izvestaj 2',
    },
  ]

  constructor() { 
    this.dataSource = new MatTableDataSource<Izvestaj>(this.izvestaji);
  }

  ngOnInit(): void {
  }

  requestPage(): void {
    let event = new PageEvent();
    event.pageIndex = this.pageIndex;
    event.pageSize = this.pageSize;
    
    this.dataSource = new MatTableDataSource<Izvestaj>(this.izvestaji);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.izvestaji.length;
    //this.paginator.length = result.body.count;

  }

  getPage(event: PageEvent) {
    this.dataSource = new MatTableDataSource<Izvestaj>(this.izvestaji);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.izvestaji.length;
    return event;
  }

}
