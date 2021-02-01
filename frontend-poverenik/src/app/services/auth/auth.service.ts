import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JWT } from 'src/app/model/JWT';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiUrl: 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) { }

  login(email: string, password: string): Observable<JWT> {
    // return this.http.post<JWT>(this.apiUrl + '/auth/login', { username: email, password });
    return null;
  }

  logOut(): void {
    localStorage.removeItem('user');
  }

  getRole(): string {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).role : 'INVALID';
  }

  getId(): number {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).id : 'INVALID';
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('user') !== null;
  }
}
