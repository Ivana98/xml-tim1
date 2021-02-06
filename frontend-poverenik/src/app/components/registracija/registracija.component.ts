import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { parse } from 'js2xmlparser';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.scss']
})
export class RegistracijaComponent implements OnInit {

  registerForm: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService,
    private snackBar: MatSnackBar,
  ) {
    this.registerForm = formBuilder.group({
      usernameField: ["", [Validators.required, Validators.email]],
      passField: ["", Validators.required],
      imeField: ["", Validators.required],
      prezimeField: ["", Validators.required],
    });
  }

  ngOnInit(): void {
  }

  register(): void {
    let korisnik = {
      "@": {
        "xmlns": "http://www.ftn.uns.ac.rs/korisnik",
        "xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "xsi:schemaLocation": "http://www.ftn.uns.ac.rs/korisnik ../xsd_documents/korisnik.xsd",
        "xmlns:pred": "http://www.ftn.uns.ac.rs/rdf/examples/predicate/"
      },
      korisnicko_ime: this.registerForm.value.usernameField,
      sifra: this.registerForm.value.passField,
      ime: this.registerForm.value.imeField,
      prezime: this.registerForm.value.prezimeField,
      uloga: "gradjanin"
    };

    let korisnikXML = parse("korisnik", korisnik, { declaration: { encoding: 'UTF-8' } })

    console.log(korisnikXML)

    this.authService.register(korisnikXML)
      .subscribe(
        data => {
          const payload = JSON.parse(window.atob(data.accessToken.split('.')[1]));
          localStorage.setItem('user', JSON.stringify({
            username: payload.sub,
            token: data.accessToken,
            role: payload.role
          }));
          this.openSnackBar("Uspesno ste se registrovali.");
          this.router.navigate(['/homepage']);
        },
        error => {
          try {
            this.openSnackBar("Postoji korisnik sa korisnickim imenom: " + this.registerForm.value.usernameField);
          } catch (error) {
            this.openSnackBar("GRESKA !!!");
          }
        }
      );
  }

  openSnackBar(message: string): void {
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}
