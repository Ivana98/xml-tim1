import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Izvestaj } from 'src/app/model/izvestaj';
import { AuthService } from 'src/app/services/auth/auth.service';
import { IzvestajiService } from 'src/app/services/izvestaji/izvestaji.service';
import { MatSnackBar } from '@angular/material/snack-bar';

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

  role = '';
  email = "";

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

  constructor(
    private izvestajService: IzvestajiService,
    private authService: AuthService,
    private snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.email = this.authService.getEmail();
  }

  podnesiNoviIzvestaj(){
    console.log("hello");
    this.izvestajService.podnesiIzvestaj().subscribe(
      response => {
        console.log(response);
        this.openSnackBar("Izvestaj je uspesno kreiran. Poverenik je obavesten o novom izvestaju");
      },
      error => {
        this.openSnackBar("Doslo je do greske prilikom podnosenja izvestaja. Probajte ponovo.");
      } 
    )
  }

  openSnackBar(message: string): void{
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}
