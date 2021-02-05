import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';

declare const Xonomy: any;

declare const require;
const xml2js = require("xml2js");

@Injectable({
  providedIn: 'root'
})
export class ObavestenjaService {

  constructor(
    private http: HttpClient,
  ) { }

  apiUrl = 'http://localhost:8091/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
    })
  };

  httpOptions2 = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
      'Response-Type': 'text'
    })
  };

  addNew(obavestenje): Observable<any> {
    return this.http.post<Observable<any>>(this.apiUrl + '/obavestenja/xml', obavestenje, this.httpOptions2);
  }

  getAll(): Observable<Array<any>> {  //: Observable<Array<any>>
    return this.http
    .get(this.apiUrl + '/obavestenja/xml', { responseType: "text" })
    .pipe(
      switchMap(async xml => await this.parseXmlToJson(xml))
    );
  }

  getHtml(id: string): Observable<any> {
    return this.http.get('http://localhost:8091/api/obavestenja/generateHTML/' + id, {responseType: 'arraybuffer'});
  }

  async parseXmlToJson(xml) {
    return await xml2js
      .parseStringPromise(xml, { explicitArray: false })
      .then(response => {
        return response;
      });
  }

  public searchArhivi = `<Dostavljeno xml:space='preserve'>Arhivi</Dostavljeno>`;
  public searchImenovanom = `<Dostavljeno xml:space='preserve'>Imenovanom</Dostavljeno>`;
  public replaceArhivi = `<Dostavljeno Selected="2"><Primer ID="1">1. Именованом </Primer><Primer ID="2">2. Архиви</Primer></Dostavljeno>`;
  public replaceImenovanom = `<Dostavljeno Selected="1"><Primer ID="1">1. Именованом </Primer><Primer ID="2">2. Архиви</Primer></Dostavljeno>`;

  public obavestenjeSpecifikacija = {
    elements: {
      Obavestenje: {

      },
      Osnovni_podaci: {

      },
      Sadrzaj: {

      },
      Organ: {

      },
      Broj_predmeta: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Datum: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Podnosioc_zahteva: {

      },
      Naslov: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Podnaslov: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Paragraf: {

      },
      Dostavljeno: {
        hasText: true,
        asker: Xonomy.askPicklist,
        askerParameter: [
          { value: "Imenovanom" },
          { value: "Arhivi" }
        ]
      },
      Naziv: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Sediste: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Ime: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Prezime: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Adresa: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Godina: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Opis_informacije: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Datum_uvida: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Vreme_uvida: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Pocetak_cas: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Kraj_cas: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Grad_organa: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Ulica_organa: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Broj_organa: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Broj_kancelarije: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      },
      Iznos_troskova: {
        hasText: true,
        asker: Xonomy.askString,
        oneliner: true
      }
    }
  }

  public getXmlString(idZahteva: string) : string{
    return  `<Obavestenje xmlns="http://www.ftn.uns.ac.rs/obavestenjecir" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.ftn.uns.ac.rs/obavestenjecir ../xsd_documents/obavestenjecir.xsd"
    xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/" id="" idZahteva="${idZahteva}">
        <Osnovni_podaci>
          <Organ about="http://www.ftn.uns.ac.rs/rdf/obavestenje/Organ">
            <Naziv property="pred:naziv" datatype="xs:string"> </Naziv>
            <Sediste property="pred:sediste" datatype="xs:string"> </Sediste>
          </Organ>
          <Broj_predmeta> </Broj_predmeta>
          <Datum property="pred:datum" datatype="xs:date"> </Datum>
          <Podnosioc_zahteva about="http://www.ftn.uns.ac.rs/rdf/obavestenje/Podnosioc">
              <Ime property="pred:ime" datatype="xs:string"> </Ime>
              <Prezime property="pred:prezime" datatype="xs:string"> </Prezime>
              <Naziv> </Naziv>
              <Adresa property="pred:adresa" datatype="xs:string"> </Adresa>
          </Podnosioc_zahteva>
        </Osnovni_podaci>
        <Sadrzaj>
          <Naslov>O B A V E S T E N J E</Naslov>
          <Podnaslov>о стављању на увид документа који садржи
              тражену информацију и о изради копије
          </Podnaslov>
          <Paragraf>
              На основу члана 16. ст. 1. Закона о слободном приступу информацијама од јавног
              значаја, поступајући по вашем захтеву за слободан приступ информацијама од
              <Godina> </Godina>
              год., којим сте тражили увид у документ/е са информацијама о / у вези са:
              <Opis_informacije>
              </Opis_informacije>
              обавештавамо вас да дана
              <Datum_uvida> </Datum_uvida>, u
              <Vreme_uvida> </Vreme_uvida> часова, односно у времену од
              <Pocetak_cas> </Pocetak_cas> do
              <Kraj_cas> </Kraj_cas> часова, у просторијама органа у
              <Grad_organa> </Grad_organa> ул.
              <Ulica_organa> </Ulica_organa> бр.
              <Broj_organa> </Broj_organa>, канцеларија бр.
              <Broj_kancelarije> </Broj_kancelarije> можете извршити увид у документ/е у коме је садржана
              тражена информација.
  
              Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом.
  
              Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то:
              копија стране А4 формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20
              динара, DVD 40 динара, аудио-касета – 150 динара, видео-касета 300 динара, претварање
              једне стране документа из физичког у електронски облик – 30 динара.
  
              Износ укупних трошкова израде копије документа по вашем захтеву износи
              <Iznos_troskova> </Iznos_troskova>
              динара и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30, с
              позивом на број 97 – ознака шифре општине/града где се налази орган власти (из
              Правилника о условима и начину вођења рачуна – „Сл. гласник РС“, 20/07... 40/10).
          </Paragraf>
          <Dostavljeno> </Dostavljeno>
        </Sadrzaj>
    </Obavestenje>`;
  }

}
