package tim1.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zahtev.Zahtev;
import tim1.backend.repository.ZahtevRepository;

@Service
public class ZahtevService extends AbstractService {

    @Autowired
    public ZahtevService(ZahtevRepository repository) {
        super(repository, "/db/poverenik/zahtev/", "/zahtev/");
    }

    public JaxbLista<Zahtev> findAllFromCollection() throws Exception{
        
        List<Zahtev> listaZahteva = this.findAllFromCollection( Zahtev.class);
        JaxbLista<Zahtev> listaObj = new JaxbLista<Zahtev>(listaZahteva);
        return listaObj;
    }

}
