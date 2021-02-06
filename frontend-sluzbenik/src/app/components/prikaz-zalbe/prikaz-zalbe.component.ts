import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Zalba } from 'src/app/model/zalba';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZalbeService } from 'src/app/services/zalbe/zalbe.service';

@Component({
  selector: 'app-prikaz-zalbe',
  templateUrl: './prikaz-zalbe.component.html',
  styleUrls: ['./prikaz-zalbe.component.scss']
})
export class PrikazZalbeComponent implements OnInit {
  zalbaId: string;
  role = '';
  zalba: Zalba;
  status: string = "";
  odgovoreno: boolean = false;

  constructor(
    private authService: AuthService,
    private _Activatedroute: ActivatedRoute,
    private zalbaService: ZalbeService,
    private router: Router,
    private snackBar: MatSnackBar,
  ) { 
    this.zalbaId = this._Activatedroute.snapshot.paramMap.get('id') || "1";
    this.zalba = new Zalba(this.zalbaId);
  }

  ngOnInit(): void {
    this.role = this.authService.getRole();
  }

  odgovori(odg: string){
    console.log(odg);
    this.zalbaService.odgovor(this.zalbaId, odg).subscribe(
      result => {
          this.openSnackBar("Uspesno kreirana zalba na odbijanje.");
        this.router.navigate(['/homepage/zalbe']);
      },
      error => {
        console.log(error);
      }
    )
  }

  openSnackBar(message: string): void {
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}
