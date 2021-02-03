import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Resenje } from 'src/app/model/resenje';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-resenja',
  templateUrl: './resenja.component.html',
  styleUrls: ['./resenja.component.scss']
})
export class ResenjaComponent implements OnInit {
  displayedColumns: string[] = ['id', 'naziv', 'izvoz'];
  dataSource: MatTableDataSource<Resenje>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  role = "";

  resenja: Resenje[] = [
    {
      id: 1,
      naziv: 'Resenje 1',
    },
    {
      id: 2,
      naziv: 'Resenje 2',
    },
  ]


  constructor(
    private authService: AuthService
  ) {
    this.dataSource = new MatTableDataSource<Resenje>(this.resenja);
  }

  ngOnInit(): void {
    this.role = this.authService.getRole();
  }

  requestPage(): void {
    let event = new PageEvent();
    event.pageIndex = this.pageIndex;
    event.pageSize = this.pageSize;

    this.dataSource = new MatTableDataSource<Resenje>(this.resenja);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.resenja.length;
    //this.paginator.length = result.body.count;

  }

  getPage(event: PageEvent) {
    this.dataSource = new MatTableDataSource<Resenje>(this.resenja);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.length = this.resenja.length;
    return event;
  }

}
