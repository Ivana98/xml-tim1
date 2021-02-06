import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Resenje } from 'src/app/model/resenje';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ResenjaService } from 'src/app/services/resenja/resenja.service';

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

  resenja: Resenje[] = []

  constructor(
    private authService: AuthService,
    private resenjaService: ResenjaService
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.getAll();
  }

  async getAll() {
    //TODO: staviti da vidi samo sa svojim mejlom kad marija doda mejl u semu
    
    let lista = await this.resenjaService.getAll().toPromise();
    lista = lista["jaxbLista"]["ns6:Resenje_obrazac"];
    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    lista.forEach(element =>{
      this.resenja.push(new Resenje(element["$"]["id"], element["$"]["broj"]))
    })

    this.dataSource = new MatTableDataSource<Resenje>(this.resenja);
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
