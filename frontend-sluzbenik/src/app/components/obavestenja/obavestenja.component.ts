import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Obavestenje } from 'src/app/model/obavestenje';

@Component({
  selector: 'app-obavestenja',
  templateUrl: './obavestenja.component.html',
  styleUrls: ['./obavestenja.component.scss']
})
export class ObavestenjaComponent implements OnInit {
  displayedColumns: string[] = ['id', 'naziv', 'izvoz'];
  dataSource: MatTableDataSource<Obavestenje>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  obavestenja: Obavestenje[] = [
    {
      id: 1,
      naziv: 'Obavestenje 1',
    },
    {
      id: 2,
      naziv: 'Obavestenje 2',
    },
  ]

  constructor(private router: Router) {
    this.dataSource = new MatTableDataSource<Obavestenje>(this.obavestenja);

  }

  ngOnInit(): void {
  }

  requestPage(): void {
    let event = new PageEvent();
    event.pageIndex = this.pageIndex;
    event.pageSize = this.pageSize;
    
    this.dataSource = new MatTableDataSource<Obavestenje>(this.obavestenja);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.obavestenja.length;
    //this.paginator.length = result.body.count;

  }

  getPage(event: PageEvent) {
    this.dataSource = new MatTableDataSource<Obavestenje>(this.obavestenja);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.obavestenja.length;
    return event;
  }

}
