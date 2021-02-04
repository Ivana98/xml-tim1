export class Zahtev {
    id?: number;
    naziv: string;
    sediste: string;
    datum: string;
    upravaCuti?: boolean;
    odbijen?: boolean;

    constructor(id?: number, naziv?: string, sediste?: string, datum?: string, upravaCuti?: boolean, odbijen?: boolean) {
        this.naziv = naziv ? naziv : '';
        this.id = id ? id : -1;
        this.sediste = sediste;
        this.datum = datum;
        this.upravaCuti = upravaCuti;
        this.odbijen = odbijen;
    }

}