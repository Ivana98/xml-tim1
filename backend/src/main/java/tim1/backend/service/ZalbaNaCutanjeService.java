package tim1.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.repository.ZalbaNaCutanjeRepository;

@Service
public class ZalbaNaCutanjeService extends AbstractService {

    
    @Autowired
    public ZalbaNaCutanjeService(ZalbaNaCutanjeRepository repository) {
        super(repository, "/db/poverenik/zalbanacutanje/", "/zalbanacutanje/");
    }

    public JaxbLista<ZalbaNaCutanje> findAllFromCollection() throws Exception{
        
        List<ZalbaNaCutanje> listaZalbi = this.findAllFromCollection( ZalbaNaCutanje.class);
        JaxbLista<ZalbaNaCutanje> listaObj = new JaxbLista<ZalbaNaCutanje>(listaZalbi);
        return listaObj;
    }

    
}
