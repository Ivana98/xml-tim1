import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JWT } from 'src/app/model/JWT';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiUrl = 'http://localhost:8091/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
    })
  };

  constructor(
    private http: HttpClient
  ) { }

  login(korisnik): Observable<JWT> {
    return this.http.post<JWT>(this.apiUrl + '/auth/login', korisnik, this.httpOptions);
  }

  register(korisnik): Observable<JWT> {
    return this.http.post<JWT>(this.apiUrl + '/korisnici', korisnik, this.httpOptions);
  }

  logOut(): void {
    localStorage.removeItem('user');
  }

  getRole(): string {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).role : 'INVALID';
  }

  getEmail(): string {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).username : 'INVALID';
  }

  getId(): number {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).id : 'INVALID';
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('user') !== null;
  }

}
