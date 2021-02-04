import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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
    return this.http.post<any>(this.apiUrl + '/zalbe-na-cutanje/xml', zalba, this.httpOptions);
  }
}
