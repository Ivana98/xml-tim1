import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

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

  getAll() :Observable<Array<any>>{
    return this.http
    .get(this.apiUrl + '/izvestaji/xml', {responseType: 'text'})
    .pipe(
      switchMap(async xml => await this.parseXmlToJson(xml))
    );
  }

  
  async parseXmlToJson(xml)  {
    return await xml2js
      .parseStringPromise(xml, { explicitArray: false })
      .then(response => {
        return response;
      });
  }
}
