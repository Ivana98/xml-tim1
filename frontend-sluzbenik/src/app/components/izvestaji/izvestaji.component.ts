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

}
