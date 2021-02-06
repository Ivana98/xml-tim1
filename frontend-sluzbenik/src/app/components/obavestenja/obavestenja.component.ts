import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Obavestenje } from 'src/app/model/obavestenje';
import { ObavestenjaService } from 'src/app/services/obavestenja-service/obavestenja.service';

@Component({
  selector: 'app-obavestenja',
  templateUrl: './obavestenja.component.html',
  styleUrls: ['./obavestenja.component.scss']
})
export class ObavestenjaComponent implements OnInit {

  displayedColumns: string[] = ['id', 'naziv', 'izvoz'];
  dataSource: MatTableDataSource<Obavestenje>;
  // dataSource2: MatTableDataSource<any>;
  pageIndex: number = 0;
  pageSize: number = 5;
  length: number = 0;

  obavestenja: Obavestenje[] = []

  constructor(
    private router: Router,
    private obavestenjaService: ObavestenjaService
  ) { }

  ngOnInit(): void {
    this.getAll()
  }

  async getAll() {
    let lista = await this.obavestenjaService.getAll().toPromise();
    lista = lista["jaxbLista"]["ns5:Obavestenje"];
    // ako lista ne postoji nema potrebe da se iterira i filtrira lista
    if (lista === undefined) return;

    // nekad je lista samo objekat i tada treba ubaciti promenljivu lista u pravu listu 
    if (!(lista instanceof Array)) {
      lista = [lista];
    }

    lista.forEach( element =>{
      this.obavestenja.push(new Obavestenje(1, element["ns5:Sadrzaj"]["ns5:Naslov"]));
    })
    this.dataSource = new MatTableDataSource<Obavestenje>(this.obavestenja);
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

  getHtml(id: string) {
    this.obavestenjaService.getHtml(id).subscribe(
      data => {
        let file = new Blob([data], { type: 'text/html' });
        var fileURL = URL.createObjectURL(file);

        let a = document.createElement('a');
        document.body.appendChild(a);
        a.setAttribute('style', 'display: none');
        a.href = fileURL;
        a.download = `obavestenje_${id}.html`;
        a.click();
        window.URL.revokeObjectURL(fileURL);
        a.remove();
      }
    );
  }

}
