import { Injectable } from '@angular/core';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class ObavestenjaService {

  constructor() { }

  public obavestenjeSpecifikacija = {
    elements: {
      Obavestenje: {
        menu: [
          {
            caption: 'Dodaj <Osnovni_podaci>',
            action: Xonomy.newElementChild,
            actionParameter: '<Osnovni_podaci></Osnovni_podaci>',
            hideIf: function(jsElement){
              return jsElement.hasChildElement('Osnovni_podaci')
            }
          }
        ],
        attributes: {}
      },
      Osnovni_podaci: {

      },
      Sadrzaj: {

      }


    }
  }

}
