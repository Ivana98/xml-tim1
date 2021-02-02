package tim1.sluzbenik.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zahtev.Zahtev;
import tim1.sluzbenik.repository.ZahtevRepository;

@Service
public class ZahtevService extends AbstractService {

    @Autowired
    public ZahtevService(ZahtevRepository repository) {
        super(repository, "/db/sluzbenik/zahtev/", "/zahtev/");
    }

    public JaxbLista<Zahtev> findAllFromCollection() throws Exception {

        List<Zahtev> listaZahteva;
        JaxbLista<Zahtev> listaObj;

        try {
            listaZahteva = this.findAllFromCollection(Zahtev.class);
            listaObj = new JaxbLista<>(listaZahteva);
            return listaObj;
        } catch (Exception e) {
            listaZahteva = new ArrayList<>();
            listaObj = new JaxbLista<>(listaZahteva);
            return listaObj;
        }
        // List<Zahtev> listaZahteva = this.findAllFromCollection( Zahtev.class);
        // JaxbLista<Zahtev> listaObj = new JaxbLista<Zahtev>(listaZahteva);
        // return listaObj;
    }

}
