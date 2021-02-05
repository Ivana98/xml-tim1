export class Zalba {
    id?: number;
    naziv: string;
    korisnik?: string;

    constructor(id?: number, naziv?: string, korisnik?: string){
        this.naziv = naziv ? naziv : '';
        this.id = id ? id : -1;
        this.korisnik = korisnik;
    }

}