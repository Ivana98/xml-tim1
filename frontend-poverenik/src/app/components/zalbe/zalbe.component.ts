import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Zalba } from 'src/app/model/zalba';

@Component({
  selector: 'app-zalbe',
  templateUrl: './zalbe.component.html',
  styleUrls: ['./zalbe.component.scss']
})
export class ZalbeComponent implements OnInit {
  displayedColumns: string[] = ['id', 'naziv', 'izvoz'];
  dataSource: MatTableDataSource<Zalba>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = "GRADJANIN";

  zalbe: Zalba[] = [
    {
      id: 1,
      naziv: 'Zalba 1',
    },
    {
      id: 2,
      naziv: 'Zalba 2',
    },
  ]

  constructor() { 
    this.dataSource = new MatTableDataSource<Zalba>(this.zalbe);
  }

  ngOnInit(): void {
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