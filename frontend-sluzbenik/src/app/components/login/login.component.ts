import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    private router: Router
    ) {
    this.loginForm = formBuilder.group({
      usernameField: ["", [Validators.required, Validators.email]],
      passField: ["", Validators.required]
    });
  }

  ngOnInit(): void {
  }

  login(): void {
    this.router.navigate(['/homepage']);
  }

}
