import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  error: string;

  constructor(
    public formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {
    this.loginForm = formBuilder.group({
      usernameField: ["", [Validators.required, Validators.email]],
      passField: ["", Validators.required]
    });
  }

  ngOnInit(): void {
  }

  login(): void {
    console.log(this.loginForm.value.usernameField)
    console.log(this.loginForm.value.passField)

    this.router.navigate(['/homepage']);

    this.error = '';

    this.authService.login(this.loginForm.value.usernameField, this.loginForm.value.passField)
      .subscribe(
        data => {
          const payload = JSON.parse(window.atob(data.accessToken.split('.')[1]));
          localStorage.setItem('user', JSON.stringify({
            username: this.loginForm.value.email,
            token: data.accessToken,
            id: payload.id,
            role: payload.role
          }));
          
          this.router.navigate(['/homepage']);
        },
        error => {
          this.error = error.error ? error.error.message : 'Your account is not verified';
        });
  }

}
