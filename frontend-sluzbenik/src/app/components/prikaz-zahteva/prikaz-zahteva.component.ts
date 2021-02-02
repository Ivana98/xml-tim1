import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-prikaz-zahteva',
  templateUrl: './prikaz-zahteva.component.html',
  styleUrls: ['./prikaz-zahteva.component.scss']
})
export class PrikazZahtevaComponent implements OnInit {

  role = '';

  constructor(
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
  }

  accept(): void {

  }

  refuse(): void {

  }


}
