import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';

declare const require;
const xml2js = require("xml2js");

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {

  apiUrl = 'http://localhost:8090/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
      // Authorization: 'bearer-token'
    })
  };

  constructor(
    private http: HttpClient
  ) { }

  getAll(): Observable<Array<any>> {  //: Observable<Array<any>>
    return this.http
    .get(this.apiUrl + '/zahtevi/xml', { responseType: "text" })
    .pipe(
      switchMap(async xml => await this.parseXmlToJson(xml))
    );
  }

  async parseXmlToJson(xml) {
    return await xml2js
      .parseStringPromise(xml, { explicitArray: false })
      .then(response => {
        return response;
      });
  }

  getHtml(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/zahtevi/generateHTML/' + id, {responseType: 'arraybuffer'});
  }

  getPdf(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/zahtevi/generatePDF/' + id, {responseType: 'arraybuffer'});
  }
}
