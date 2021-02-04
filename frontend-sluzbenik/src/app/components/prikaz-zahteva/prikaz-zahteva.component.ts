import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';

@Component({
  selector: 'app-prikaz-zahteva',
  templateUrl: './prikaz-zahteva.component.html',
  styleUrls: ['./prikaz-zahteva.component.scss']
})
export class PrikazZahtevaComponent implements OnInit {
  zahtevId: string;
  role = '';

  constructor(
    private authService: AuthService,
    private zahtevService: ZahtevService,
    private _Activatedroute: ActivatedRoute,
  ) { 
    this.zahtevId = this._Activatedroute.snapshot.paramMap.get('id') || "1";
  }

  ngOnInit(): void {
    this.role = this.authService.getRole();
  }

  accept(): void {

  }

  refuse(): void {
    this.zahtevService.odbijZahtev(this.zahtevId).subscribe(response => {
      console.log(response);
    },
    error => {
      console.log(error);
    })
    console.log("odbijen");
  }


}
