import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

declare const require;
const xml2js = require("xml2js");

@Injectable({
  providedIn: 'root'
})
export class ResenjaService {

  apiUrl = 'http://localhost:8091/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
    })
  };

  constructor(
    private http: HttpClient
  ) { }

  getAll(): Observable<Array<any>> {  //: Observable<Array<any>>
    return this.http
    .get(this.apiUrl + '/resenja/xml', { responseType: "text" })
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
    return this.http.get(this.apiUrl + '/resenja/generateHTML/' + id, {responseType: 'arraybuffer'});
  }

  getPdf(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/resenja/generatePDF/' + id, {responseType: 'arraybuffer'});
  }
}
