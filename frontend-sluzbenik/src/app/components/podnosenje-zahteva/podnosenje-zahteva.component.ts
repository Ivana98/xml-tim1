import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { parse } from 'js2xmlparser';
import { ZahtevService } from 'src/app/services/zahtev/zahtev.service';

@Component({
  selector: 'app-podnosenje-zahteva',
  templateUrl: './podnosenje-zahteva.component.html',
  styleUrls: ['./podnosenje-zahteva.component.scss']
})
export class PodnosenjeZahtevaComponent implements OnInit {

  constructor(
    private router: Router,
    private zahtevService: ZahtevService
  ) { }

  ngOnInit(): void {
  }

  send(): void {
    console.log("*** Slanje zahteva ***");

    let zahtev = {
      "@": {
        "xmlns": "http://www.ftn.uns.ac.rs/zahtev",
        "xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "xsi:schemaLocation": "http://www.ftn.uns.ac.rs/zahtev ../xsd_documents/zahtev.xsd",
        "xmlns:pred": "http://www.ftn.uns.ac.rs/rdf/examples/predicate/"
      },
      info_organa: {
        naziv: "naziv 1",
        sediste: "sediste 1"
      },
      naslov: "naslov 1",
      svrha_zahteva: "neka svrha 1",
      opis_zahteva: {
        tekst_zahteva: "neki tekst 1",
        tipovi_zahteva: {
          "tip_zahteva": [
            {
              "@": {
                selektovan: "true",
                rb: "1",
                tekst: "zelim uvid u dokument 1"
              }
            },
            {
              "@": {
                selektovan: "false",
                rb: "2",
                tekst: "zelim uvid u dokument 2",

              },
              nacini_slanja: {
                nacin_slanja: {
                  "@": {
                    rb: "1",
                    selektovan: "false",
                    tekst: "elektronski"
                  }
                }
              }
            }
          ]
        },
        dodatne_informacije: {
          "#": "Ovaj zahtev se odnosi na sledece info: ",
          opis_dodatne_informacije: "opis dodatne info..."
        }
      },
      mesto: "Novi Sad",
      datum: {
        "@": {
          "property": "pred:datum",
          "datatype": "xs:date"
        },
        "#": "2021-01-06+01:00"
      },
      trazilac: {
        ime_i_prezime: "Veljko Plecas",
        adresa: "Sombor, somborska",
        kontakt: "065 3388 987",
        potpis: "brza strela brzo leti preko 7 brda i ubija bika od 2 tone"
      },
      footer: "footer tekst"
    };

    let zahtevXML = parse("zahtev", zahtev, { declaration: { encoding: 'UTF-8' } })

    console.log(zahtevXML);

    this.zahtevService.addNew(zahtevXML)
    .subscribe(
      response => {
        // sa beka se ne vraca nista za sada
      }
    )

  }

}
