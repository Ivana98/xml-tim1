
export class Zalba {
    id?: string;
    naziv: string;
    tip: string;

    constructor(id?: string, naziv?: string, tip?: string){
        this.naziv = naziv ? naziv : '';
        this.id = id ? id : "";
        this.tip = status ? status : "na cekanju";
    }

}