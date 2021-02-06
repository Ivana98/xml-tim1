import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

declare const require;
const xml2js = require("xml2js");

@Injectable({
  providedIn: 'root'
})
export class IzvestajiService {

  apiUrl = 'http://localhost:8091/api';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
    })
  };
  
  constructor(
    private http: HttpClient,
  ) { }

  podnesiIzvestaj(): Observable<any>{
    return this.http.get(this.apiUrl + '/izvestaji/podnesi-izvestaj/');
  }

  getAll() {
    
  }

  
  async parseXmlToJson(xml) {
    return await xml2js
      .parseStringPromise(xml, { explicitArray: false })
      .then(response => {
        return response;
      });
  }
}
