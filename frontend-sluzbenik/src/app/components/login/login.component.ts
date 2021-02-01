import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { parse } from 'js2xmlparser';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

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


    let korisnik = {
      "@": {
        "xmlns": "http://www.ftn.uns.ac.rs/korisnik",
        "xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "xsi:schemaLocation": "http://www.ftn.uns.ac.rs/korisnik ../xsd_documents/korisnik.xsd",
        "xmlns:pred": "http://www.ftn.uns.ac.rs/rdf/examples/predicate/"
      },
      korisnicko_ime: this.loginForm.value.usernameField,
      sifra: this.loginForm.value.passField
    };
    let korisnikXML = parse("korisnik", korisnik, { declaration: { encoding: 'UTF-8' } })
    console.log(korisnikXML);

    this.authService.login(korisnikXML)
      .subscribe(
        data => {
          const payload = JSON.parse(window.atob(data.accessToken.split('.')[1]));
          localStorage.setItem('user', JSON.stringify({
            username: payload.sub,
            token: data.accessToken,
            role: payload.uloga
          }));

          console.log(payload)

          this.router.navigate(['/homepage']);
        }
      );
  }

}
