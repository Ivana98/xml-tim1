import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { AuthService } from '../auth/auth.service';

declare const Xonomy: any;
declare const require;
const xml2js = require("xml2js");

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {
  email: string = 'konstrukcijaitestiranje@gmail.com';

  apiUrl = 'http://localhost:8091/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
    })
  };

  
  httpOptions2 = {
    headers: new HttpHeaders({
      'Accept': 'text/xml',
      'Content-Type': 'text/xml',
      //'Response-Type': 'application/xml'
    })
  };

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) { }

  getHtml(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/zahtevi/generateHTML/' + id, {responseType: 'arraybuffer'});
  }

  getPdf(id: string): Observable<any> {
    return this.http.get(this.apiUrl + '/zahtevi/generatePDF/' + id, {responseType: 'arraybuffer'});
  }

  addNew(zahtev): any {
    return this.http.post<any>(this.apiUrl + '/zahtevi/xml', zahtev, this.httpOptions);
  }

  odbijZahtev(idZahteva: string): Observable<any> {
    return this.http.get<any>('http://localhost:8091/api/zahtevi/odbijanje/' + idZahteva, this.httpOptions);
  }

  odobriZahtev(obavestenje: string): Observable<any> {

    let str = 'http://localhost:8091/api/zahtevi/odobravanje';
    console.log(str);
    return this.http.post<any>('http://localhost:8091/api/zahtevi/odobravanje', obavestenje, this.httpOptions);
  }

  getAll(): Observable<Array<any>> {  //: Observable<Array<any>>
    return this.http
    .get(this.apiUrl + '/zahtevi/xml', { responseType: "text" })
    .pipe(
      switchMap(async xml => await this.parseXmlToJson(xml))
    );
  }

  getZahtev(id: string): Observable<any> {
    return this.http.get('http://localhost:8091/api/zahtevi/xml/' + id, { responseType: 'text' }).pipe(
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
  
  
  public xmlString =
  `<zahtev xmlns="http://www.ftn.uns.ac.rs/zahtev"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.ftn.uns.ac.rs/zahtev ../xsd_documents/zahtev.xsd"
  xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/"
  about="http://www.ftn.uns.ac.rs/rdf/zahtev/Zahtev"
  id=""
  property="pred:status" datatype="xs:string" content="na cekanju">
  <info_organa about="http://www.ftn.uns.ac.rs/rdf/zahtev/Organ">
      <naziv property="pred:naziv" datatype="xs:string"> </naziv>
      <sediste property="pred:sediste" datatype="xs:string"> </sediste>
  </info_organa>
  <naslov> Zahtev </naslov>
  <svrha_zahteva> </svrha_zahteva>
  <opis_zahteva>
      <tekst_zahteva> </tekst_zahteva>
      <tipovi_zahteva>
          <tip_zahteva selektovan="false" rb="1" tekst="obavestenje da li poseduje trazenu informaciju"/>
          <tip_zahteva selektovan="false" rb="2" tekst="uvid u dokument koji sadrzi trazenu informaciju"/>
          <tip_zahteva selektovan="false" rb="3" tekst="kopiju dokumenta koji sadrzi trazenu informaciju"/>
          <tip_zahteva selektovan="false" rb="4" tekst="dostavljanje kopije dokumenta koji sadrzi trazenu informaciju">
              <nacini_slanja>
                  <nacin_slanja rb="1" selektovan="false" tekst="postom"/>
                  <nacin_slanja rb="2" selektovan="false" tekst="elektronskom postom"/>
                  <nacin_slanja rb="3" selektovan="false" tekst="faksom"/>
                  <nacin_slanja rb="4" selektovan="false" tekst="na drugi nacin">
                  </nacin_slanja>
              </nacini_slanja>
          </tip_zahteva>
      </tipovi_zahteva>
      <dodatne_informacije>
        <opis_dodatne_informacije> </opis_dodatne_informacije>
      </dodatne_informacije>
  </opis_zahteva>
  <mesto property="pred:mesto" datatype="xs:string"> </mesto>
  <datum property="pred:datum" datatype="xs:date"> </datum>
  <trazilac about="http://www.ftn.uns.ac.rs/rdf/zahtev/Trazilac" email="${this.authService.getEmail()}">
      <ime_i_prezime property="pred:ime-prezime" datatype="xs:string"> </ime_i_prezime>
      <adresa property="pred:mesto" datatype="xs:string"> </adresa>
      <kontakt> </kontakt>
  </trazilac>
  <footer> </footer>
</zahtev>
  `;

  public obavestenjeSpecifikacija = {
    elements: {
      zahtev: {

      },
      info_organa: {

      },
      naslov: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      svrha_zahteva: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      opis_zahteva: {

      },
      mesto: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      datum: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      trazilac: {

      },
      footer: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      naziv: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      sediste: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      tekst_zahteva: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      tipovi_zahteva: {

      },
      tip_zahteva: {
        attributes: {
          selektovan: {
            asker: Xonomy.askString
          }
        }
      },
      nacini_slanja: {

      },
      nacin_slanja: {
        hasText: true,
        asker: Xonomy.askString,
        attributes: {
          selektovan: {
            asker: Xonomy.askString
          }
        }
      },
      dodatne_informacije: {

      },
      opis_dodatne_informacije: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      ime_i_prezime: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      adresa: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      kontakt: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      }
    }
  }

}
