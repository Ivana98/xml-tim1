
export class Zahtev {
    id?: string;
    naziv: string;
    status: string;

    constructor(id?: string, naziv?: string, status?: string){
        this.naziv = naziv ? naziv : '';
        this.id = id ? id : "";
        this.status = status ? status : "na cekanju";
    }

}