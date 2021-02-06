export class Izvestaj {
    odbijeniZahtevi: string;
    odobreniZahtevi: string;
    resenja: string;
    sveZalbe: string;
    sviZahtevi: string;
    zalbeNaCutanje: string;
    zalbeNaOdluku: string;


    constructor(odbijeniZahtevi: string, odobreniZahtevi: string, resenja: string, sveZalbe: string, sviZahtevi: string, zalbeNaCutanje: string, zalbeNaOdluku: string){
        this.odbijeniZahtevi = odbijeniZahtevi;
        this.odobreniZahtevi = odobreniZahtevi;
        this.resenja = resenja;
        this.sveZalbe = sveZalbe;
        this.sviZahtevi = sviZahtevi;
        this.zalbeNaCutanje = zalbeNaCutanje;
        this.zalbeNaOdluku = zalbeNaOdluku;
    }

}