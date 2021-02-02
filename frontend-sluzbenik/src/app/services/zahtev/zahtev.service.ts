import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {

  apiUrl = 'http://localhost:8091/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
    })
  };

  constructor(
    private http: HttpClient
  ) { }

  addNew(zahtev): any {
    return this.http.post<any>(this.apiUrl + '/zahtevi/xml', zahtev, this.httpOptions);
  }

  getAll(): Observable<any> {
    // let queryParams = {};

  // queryParams = {
  // 	headers: this.headers,
  // 	observe: 'response'
    // };

    return this.http.get(this.apiUrl + 'zahtevi/xml', this.httpOptions);
  }

}
