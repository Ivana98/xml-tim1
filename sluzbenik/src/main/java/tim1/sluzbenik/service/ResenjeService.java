package tim1.sluzbenik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.resenje.Resenje;
import tim1.sluzbenik.repository.ResenjeRepository;

@Service
public class ResenjeService extends AbstractService {

    @Autowired
    public ResenjeService(ResenjeRepository repository) {
        super(repository, "/db/sluzbenik/resenje/", "/resenje/");
    }
    
    public JaxbLista<Resenje> findAllFromCollection() throws Exception{
        
        List<Resenje> listaZalbi = this.findAllFromCollection( Resenje.class);
        JaxbLista<Resenje> listaObj = new JaxbLista<Resenje>(listaZalbi);
        return listaObj;
    }

}
