
export class Obavestenje {
    id?: number;
    naslov: string;

    constructor(id?: number, naslov?: string){
        this.naslov = naslov ? naslov : '';
        this.id = id ? id : -1;
    }

}