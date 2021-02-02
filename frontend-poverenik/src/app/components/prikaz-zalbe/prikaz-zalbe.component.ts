import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-prikaz-zalbe',
  templateUrl: './prikaz-zalbe.component.html',
  styleUrls: ['./prikaz-zalbe.component.scss']
})
export class PrikazZalbeComponent implements OnInit {

  role = '';

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.role = this.authService.getRole();
  }

  cancel(): void {

  }

  create(): void {

  }

  send(): void {

  }

}
