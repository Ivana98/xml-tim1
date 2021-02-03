import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-prikaz-resenja',
  templateUrl: './prikaz-resenja.component.html',
  styleUrls: ['./prikaz-resenja.component.scss']
})
export class PrikazResenjaComponent implements OnInit {

  zahtevId;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.zahtevId = +params.get('id');
    });
  }

}
