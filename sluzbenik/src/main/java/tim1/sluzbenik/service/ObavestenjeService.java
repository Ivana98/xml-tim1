package tim1.sluzbenik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.obavestenje.Obavestenje;
import tim1.sluzbenik.repository.ObavestenjeRepository;

@Service
public class ObavestenjeService extends AbstractService {

    @Autowired
    public ObavestenjeService(ObavestenjeRepository repository) {
        super(repository, "/db/poverenik/obavestenje/", "/obavestenje/");
    }

    public JaxbLista<Obavestenje> findAllFromCollection() throws Exception{
        
        List<Obavestenje> listaZalbi = this.findAllFromCollection( Obavestenje.class);
        JaxbLista<Obavestenje> listaObj = new JaxbLista<Obavestenje>(listaZalbi);
        return listaObj;
    }
}
