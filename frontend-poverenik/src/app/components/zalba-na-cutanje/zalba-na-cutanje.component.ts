import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZalbaService } from 'src/app/services/zalba/zalba.service';

@Component({
  selector: 'app-zalba-na-cutanje',
  templateUrl: './zalba-na-cutanje.component.html',
  styleUrls: ['./zalba-na-cutanje.component.scss']
})
export class ZalbaNaCutanjeComponent implements OnInit {

  zahtevId = "";
  nazivOrgana = "";
  datumPodnosenjaZahteva = "";
  podaciOZahtevu = "";
  ime = "";
  prezime = "";
  adresa = "";
  kontakt = "";
  mestoPodnosenja = "";
  datumPodnosenja = "";

  email = "";


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private zalbaService: ZalbaService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.zahtevId = params.get('id');
    });

    this.email = this.authService.getEmail();
  }

  send() {
    //TODO: ovde ubaciti realne vrednosti - promenljive, nisu sve napravljene
    let zalba = `<?xml version="1.0" encoding="UTF-8"?>
<Zalba_na_cutanje 
    naslov="ЖАЛБА КАДА ОРГАН ВЛАСТИ НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)"
    xmlns="http://www.ftn.uns.ac.rs/zalba-na-cutanje"
    xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:pred="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/predicate/"
    xsi:schemaLocation="http://www.ftn.uns.ac.rs/zalba-na-cutanje ../xsd_documents/zalbacutanjecir.xsd"
    id="" idZahteva="${this.zahtevId}">
    <Namena>Повереникy за информације од јавног значаја и заштиту података о личности</Namena>
    <Adresa_za_postu
        about="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/Adresa">
        <Mesto property="pred:mesto" datatype="xs:string">Београд</Mesto>
        <Ulica property="pred:ulica" datatype="xs:string">Булевар краља Александрa</Ulica>
        <Broj>15</Broj>
    </Adresa_za_postu>
    <Sadrzaj
        about="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/Zalba">
        У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:
        Ж А Л Б У
        против
        <Naziv_organa>${this.nazivOrgana}</Naziv_organa>
        због тога што орган власти: 
        <Razlozi_zalbe property="pred:razlog_zalbe" datatype="xs:string" selected="1">
            <Option id="1">није поступио</Option>
            <Option id="2">није поступио у целости </Option>
            <Option id="3">није поступио у законском року</Option>
        </Razlozi_zalbe>
        по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана
        <Datum_podnosenja_zahteva property="pred:datum_podnosenja_zahteva" datatype="xs:date">${this.datumPodnosenjaZahteva}</Datum_podnosenja_zahteva>
        године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја омогући увид- копија документа који садржи информације  о /у вези са :
        <Podaci_o_zahtevu>(подаци о захтеву и информацијама)</Podaci_o_zahtevu>
        <Pasus>На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.</Pasus>
        <Pasus>Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.</Pasus>
        <Napomena>Код жалбе  због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.</Napomena>
    </Sadrzaj>
    <Podnosilac_zalbe
        about="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/Podnosilac" email="${this.email}">
        <Ime property="pred:ime" datatype="xs:string">${this.ime}</Ime>
        <Prezime property="pred:prezime" datatype="xs:string">${this.prezime}</Prezime>
        <Adresa property="pred:adresa" datatype="xs:string">${this.adresa}</Adresa>
        <Kontakt_podaci property="pred:kontakt" datatype="xs:string">${this.kontakt}</Kontakt_podaci>
    </Podnosilac_zalbe>
    <Vreme_i_mesto>
        <Mesto>${this.mestoPodnosenja}</Mesto>
        <Datum>${this.datumPodnosenja}</Datum>
    </Vreme_i_mesto>
</Zalba_na_cutanje>`

    this.zalbaService.addNewCutanje(zalba)
      .subscribe(
        data => {
          console.log("Trebalo bi da upise")
        },
        error => console.log(error)
        
      )
      
  }

}
