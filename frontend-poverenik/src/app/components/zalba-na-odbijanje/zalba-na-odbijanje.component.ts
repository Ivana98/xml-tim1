import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ZalbaService } from 'src/app/services/zalba/zalba.service';

@Component({
  selector: 'app-zalba-na-odbijanje',
  templateUrl: './zalba-na-odbijanje.component.html',
  styleUrls: ['./zalba-na-odbijanje.component.scss']
})
export class ZalbaNaOdbijanjeComponent implements OnInit {

  zahtevId = "";
  grad = "";
  ulica = "";
  broj = "";
  sediste = "";
  ime = "";
  prezime = "";
  kontakt = "";
  nazivOrgana = "";
  brojZahteva = "";
  godina = "";
  datumPodnosenjaZahteva = "";
  deoOdluke = "";
  mestoPodnosenjaZalbe = "";
  datumPodnosenjaZalbe = "";

  email = "";

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private zalbaService: ZalbaService,
    private authService: AuthService,
    private snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.zahtevId = params.get('id');
    });
    
    this.email = this.authService.getEmail();
  }

  send() {
    let zalba = `<?xml version="1.0" encoding="UTF-8"?>
    <zalba_na_odluku
        xmlns="http://www.ftn.uns.ac.rs/zalba-na-odluku"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.ftn.uns.ac.rs/zalba-na-odluku ../xsd_documents/zalbanaodlukucir.xsd"
        xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/"
        id="" idZahteva="${this.zahtevId}" status="na cekanju">
        <naslov> ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ </naslov>
        
        <podaci_o_povereniku>
            <namena> 
                Поверенику за информације од јавног значаја и заштиту података о личности 
            </namena>
            <adresa about="http://www.ftn.uns.ac.rs/rdf/zalbaodluka/AdresaPoverenika">
                <grad property="pred:grad" datatype="xs:string"> ${this.grad} </grad>
                <ulica property="pred:ulica" datatype="xs:string"> ${this.ulica} </ulica>
                <broj>${this.broj}</broj>
            </adresa>
        </podaci_o_povereniku>
        
        <zalba>
            Ж А Л Б А  
            <zalilac xsi:type="TFizickoLice" about="http://www.ftn.uns.ac.rs/rdf/zalbaodluka/Zalilac">
                <adresa about="http://www.ftn.uns.ac.rs/rdf/zalbaodluka/AdresaZalioca">
                    <grad property="pred:grad" datatype="xs:string">${this.grad}</grad>
                    <ulica property="pred:grad" datatype="xs:string">${this.ulica}</ulica>
                    <broj>${this.broj}</broj>
                </adresa>
                <sediste property="pred:sediste" datatype="xs:string">${this.sediste}</sediste>
                <ime property="pred:ime" datatype="xs:string">${this.ime}</ime>
                <prezime property="pred:prezime" datatype="xs:string">${this.prezime}</prezime>
            </zalilac>
            против решења-закључка 
            
            <naziv_organa></naziv_organa>
            Број <broj_zahteva>${this.brojZahteva}</broj_zahteva> од <godina>${this.godina}</godina> године.
            
            <sadrzaj>
                Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми 
                са елементима одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-
                упутио/ла дана <datum>${this.datumPodnosenjaZahteva}</datum> године и тако ми ускраћено-онемогућено остваривање уставног и
                законског права на слободан приступ информацијама од јавног значаја. Oдлуку побијам у
                целости, односно у делу којим <deo_odluke>${this.deoOdluke} </deo_odluke> јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи
                одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.
                Жалбу подносим благовремено, у законском року утврђеном у <zakon>члану 22. ст. 1. Закона о слободном приступу информацијама од јавног значаја.</zakon>   
            </sadrzaj>
            
            <podnosilac about="http://www.ftn.uns.ac.rs/rdf/zalbaodluka/Podnosilac" email="${this.email}">
                <ime property="pred:imePodnosioca" datatype="xs:string">${this.ime}</ime>
                <prezime property="pred:prezimePodnosioca" datatype="xs:string">${this.prezime}</prezime>
                <adresa>
                    <grad property="pred:gradPodnosioca" datatype="xs:string">${this.grad}</grad>
                    <ulica>${this.ulica}</ulica>
                    <broj>${this.broj}</broj>
                </adresa>
                <kontakt_podaci>${this.kontakt}</kontakt_podaci>
            </podnosilac>
            
            <vreme_i_mesto about="http://www.ftn.uns.ac.rs/rdf/zalbaodluka/Podnosenje">
                <grad property="pred:mesto" datatype="xs:string">${this.mestoPodnosenjaZalbe}</grad>
                <datum property="pred:datum" datatype="xs:date">${this.datumPodnosenjaZalbe}</datum>
            </vreme_i_mesto>
            
        </zalba>
        
        <napomene>
            Напомена: 
            <napomena id="1">
                У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив
                органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у
                жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити.
                Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити. 
            </napomena>
            <napomena id="2">
                Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању органу
                као и копију одлуке органа која се оспорава жалбом.
            </napomena>
        </napomene>
        
    </zalba_na_odluku>
    `
    this.zalbaService.addNewOdbijanje(zalba)
    .subscribe(
      data => {
        this.openSnackBar("Uspesno kreirana zalba na odbijanje.");
          this.router.navigate(['/homepage/zalbe']);
      }
    )
  }

  openSnackBar(message: string): void{
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }


}
