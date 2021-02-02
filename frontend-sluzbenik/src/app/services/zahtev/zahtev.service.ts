import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

declare const Xonomy: any;

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

  public xmlString =
  `<zahtev xmlns="http://www.ftn.uns.ac.rs/zahtev"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.ftn.uns.ac.rs/zahtev ../xsd_documents/zahtev.xsd"
  xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/"
  about="http://www.ftn.uns.ac.rs/rdf/zahtev/Zahtev"
  property="pred:status" datatype="xs:string" content="na cekanju">
  <info_organa about="http://www.ftn.uns.ac.rs/rdf/zahtev/Organ">
      <naziv property="pred:naziv" datatype="xs:string"> </naziv>
      <sediste property="pred:sediste" datatype="xs:string"> </sediste>
  </info_organa>
  <naslov> </naslov>
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
  <trazilac about="http://www.ftn.uns.ac.rs/rdf/zahtev/Trazilac">
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
