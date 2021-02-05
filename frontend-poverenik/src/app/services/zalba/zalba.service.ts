import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';

declare const require;
const xml2js = require("xml2js");

@Injectable({
  providedIn: 'root'
})
export class ZalbaService {

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

  addNewOdbijanje(zalba) {
    return this.http.post<any>(this.apiUrl + '/zalbe-na-odluku/xml', zalba, this.httpOptions);
  }

  addNewCutanje(zalba): Observable<any> {
    return this.http.post<any>(this.apiUrl + '/zalbe-na-cutenje/xml', zalba, this.httpOptions);
  }

  getAllOdbijanje(): Observable<Array<any>> {  //: Observable<Array<any>>
    return this.http
    .get(this.apiUrl + '/zalbe-na-odluku/xml', { responseType: "text" })
    .pipe(
      switchMap(async xml => await this.parseXmlToJson(xml))
    );
  }

  getAllCutanje(): Observable<Array<any>> {  //: Observable<Array<any>>
    return this.http
    .get(this.apiUrl + '/zalbe-na-cutenje/xml', { responseType: "text" })
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

  getHtmlCutanje(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/zalbe-na-cutenje/generateHTML/' + id, {responseType: 'arraybuffer'});
  }

  getHtmlOdluka(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/zalbe-na-odluku/generateHTML/' + id, {responseType: 'arraybuffer'});
  }

}
