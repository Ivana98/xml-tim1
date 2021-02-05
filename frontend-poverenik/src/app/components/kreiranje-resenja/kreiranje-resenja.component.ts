import { Component, OnInit } from '@angular/core';
import { ResenjaService } from 'src/app/services/resenja/resenja.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-kreiranje-resenja',
  templateUrl: './kreiranje-resenja.component.html',
  styleUrls: ['./kreiranje-resenja.component.scss']
})
export class KreiranjeResenjaComponent implements OnInit {

  idZalbe = "";

  datum = "";
  sadrzajObrazlozenja = "";
  ime = "";
  prezime = "";
  cena = "";

  constructor(
    private service: ResenjaService,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.idZalbe = params.get('id');
    });
  }

  cancel(): void {

  }

  send(): void {
    let dummyResenje = `<?xml version="1.0" encoding="UTF-8"?>
<Resenje_obrazac xmlns="http://www.ftn.uns.ac.rs/resenje"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.ftn.uns.ac.rs/resenje ../xsd_documents/resenje.xsd"
naslov="Решење када је жалба основана – налаже се:"
broj="071-01-1114/2020-03"
xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/"
id="" idZalbe="">
    <Datum property="pred:datumResenja" datatype="xs:date">${this.datum}</Datum>
    <Uvod>
        Повереник за информације од јавног значаја и заштиту података о личности, у поступку по алби коју је изјавио AA, због непоступања Учитељског факултета у Призрену са привременим седиштем у Лепосавићу, ул. Немањина бб, по његовом захтеву од 16.04.2020. године за приступ информацијама од јавног значаја, на основу члана 35. став 1. тачка 5. Закона о слободном приступу информацијама од јавног значаја („Сл. гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), а у вези са чланом 4. тачка 22. Закона о заштити података о личности („Сл. гласник РС“, број 87/18), као и члана 23. и члана 24. став 4. Закона о слободном приступу информацијама од јавног значаја и члана 173. став 2. Закона о општем управном поступку („Сл. гласник РС“, бр. 18/2016 и 95/2018-аутентично тумачење), доноси
    </Uvod>
    <Sadrzaj>
        <Resenje>
            Р Е Ш Е Њ Е
            <Pasus>
                I Налаже се Учитељском факултету у Призрену са привременим седиштем у Лепосавићу, да без одлагања, а најкасније у року од пет дана од дана пријема овог решења, обавести АА, да ли поседује тражене информације односно документ у коме су исте садржане, и то: Уговор о раду који је као последњи потписан између тог Факултета и ББ, те да му, уколико такав документ поседује достави копију истог електронском поштом на адресу … или поштом, с тим што ће пре достављања заштитити и учинити недоступним податке о личности којима би се повредило право на приватност лица на које се информације односе, као што су: адреса становања, лични матични број грађана, име оца, радни стаж, просечна оцена студирања и сл. уколико су такви подаци садржани у траженом документу.
            </Pasus>
            <Pasus>
                II О извршењу решења Учитељски факултет у Призрену са привременим седиштем у Лепосавићу, ће обавестити Повереника у року од седам дана од пријема овог решења.
            </Pasus>
        </Resenje>
        <Obrazlozenje>
            О б р а з л о ж е њ е
            <Sadrzaj_obrazlozenja>
            ${this.sadrzajObrazlozenja} Такса на тужбу износи <Cena>${this.cena}</Cena> динара.
            </Sadrzaj_obrazlozenja>
        </Obrazlozenje>
    </Sadrzaj>
    <Poverenik about="http://www.ftn.uns.ac.rs/rdf/resenje/Poverenik">
        <Ime property="pred:ime" datatype="xs:string">${this.ime}</Ime>
        <Prezime property="pred:prezime" datatype="xs:string">${this.prezime}</Prezime>
    </Poverenik>
</Resenje_obrazac>
    `;
    this.service.addResenje(dummyResenje).subscribe(
      response => {
        this.openSnackBar("resenje je uspesno kreirano.");
        this.router.navigate(['/homepage/zalbe']);
      },
      error => {
        this.openSnackBar("resenje je nije uspesno kreirano.")
      }
    )

  }

  
  openSnackBar(message: string): void{
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}
