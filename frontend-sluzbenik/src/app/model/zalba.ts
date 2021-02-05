
export class Zalba {
    id?: string;
    naziv: string;
    korisnik?: string;
    tip?: string;

    constructor(id?: string, naziv?: string, korisnik?: string, tip?: string){
        this.naziv = naziv ? naziv : '';
        this.id = id ? id : "";
        this.korisnik = korisnik;
        this.tip = status ? status : "na cekanju";
    }

}