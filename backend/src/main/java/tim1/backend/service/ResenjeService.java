package tim1.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.resenje.Resenje;
import tim1.backend.repository.ResenjeRepository;

@Service
public class ResenjeService extends AbstractService {

    @Autowired
    public ResenjeService(ResenjeRepository repository) {
        super(repository, "/db/poverenik/resenje/", "/resenje/");
    }

    public JaxbLista<Resenje> findAllFromCollection() throws Exception{
        
        List<Resenje> listaZalbi = this.findAllFromCollection( Resenje.class);
        JaxbLista<Resenje> listaObj = new JaxbLista<Resenje>(listaZalbi);
        return listaObj;
    }

}
