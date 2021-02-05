import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

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
}
