
export class Zahtev {
    id?: number;
    naziv: string;

    constructor(id?: number, naziv?: string){
        this.naziv = naziv ? naziv : '';
        this.id = id ? id : -1;
    }

}