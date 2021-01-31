import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prikaz-zahteva',
  templateUrl: './prikaz-zahteva.component.html',
  styleUrls: ['./prikaz-zahteva.component.scss']
})
export class PrikazZahtevaComponent implements OnInit {

  role = 'SLUZBENIK';

  constructor() { }

  ngOnInit(): void {
  }

  accept(): void {

  }

  refuse(): void {

  }


}
