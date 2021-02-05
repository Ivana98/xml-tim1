import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';

declare const require;
const xml2js = require("xml2js");

@Injectable({
  providedIn: 'root'
})
export class ResenjaService {
  
  apiUrl = 'http://localhost:8090/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
    })
  };
  
  constructor(private http: HttpClient) { }

  addResenje(resenjeXml: string): Observable<any>{
    return this.http.post<string>(this.apiUrl + "/resenja/xml", resenjeXml, this.httpOptions);
  }

  getHtml(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/resenja/generateHTML/' + id, {responseType: 'arraybuffer'});
  }

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
}
