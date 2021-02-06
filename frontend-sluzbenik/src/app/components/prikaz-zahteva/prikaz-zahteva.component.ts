import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Zahtev } from 'src/app/model/zahtev';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-prikaz-zahteva',
  templateUrl: './prikaz-zahteva.component.html',
  styleUrls: ['./prikaz-zahteva.component.scss']
})
export class PrikazZahtevaComponent implements OnInit {
  zahtevId: string;
  role = '';
  zahtev: Zahtev;
  status: string = "";
  naCekanju: boolean = false;
  nemaOdgovora: boolean = false;

  constructor(
    private authService: AuthService,
    private zahtevService: ZahtevService,
    private _Activatedroute: ActivatedRoute,
    private snackBar: MatSnackBar,
    private router: Router,
  ) { 
    this.zahtevId = this._Activatedroute.snapshot.paramMap.get('id') || "1";
    this.zahtev = new Zahtev(this.zahtevId);
  }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.zahtevService.getZahtev(this.zahtevId).subscribe(result => {
      console.log(result);
      this.zahtev.status = result["ns2:zahtev"]["$"]["content"];
      console.log(this.zahtev.status);
      this.status = this.zahtev.status;
      if(this.status == "na cekanju"){
        this.naCekanju = true;
      }
      else if(this.status == "nema odgovora"){
        this.nemaOdgovora = true;
      }

    })
  }

  accept(): void {

  }

  refuse(): void {
    this.zahtevService.odbijZahtev(this.zahtevId).subscribe(
      response => {
      this.openSnackBar("Uspesno ste odbili Zahtev");
      this.router.navigate(['/homepage/zahtevi']);
    },
    error =>{
      this.openSnackBar("Niste uspesno odbili zahtev");
      this.router.navigate(['/homepage/zahtevi']);
    })
  }
  openSnackBar(message: string): void{
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}
