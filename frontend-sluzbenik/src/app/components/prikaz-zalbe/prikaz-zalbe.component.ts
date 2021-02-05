import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  ) { 
    this.zalbaId = this._Activatedroute.snapshot.paramMap.get('id') || "1";
    this.zalba = new Zalba(this.zalbaId);
  }

  ngOnInit(): void {
    this.role = this.authService.getRole();
    // this.zalbaService.getZalba(this.zalbaId).subscribe(result => {
    //   console.log(result);
    //   this.zalba.status = result["ns2:zahtev"]["$"]["content"];
    //   console.log(this.zahtev.status);
    //   this.status = this.zahtev.status;
    //   if(this.status == "na cekanju"){
    //     this.naCekanju = true;
    //   }
    //   else if(this.status == "nema odgovora"){
    //     this.nemaOdgovora = true;
    //   }

    // })
  }

  odgovori(odg: string){
    console.log(odg);
    this.zalbaService.odgovor(this.zalbaId, odg).subscribe(
      result => {
        console.log("ok");
      },
      error => {
        console.log(error);
      }
    )
  }

}
