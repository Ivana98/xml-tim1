package tim1.sluzbenik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zalbacutanje.ZalbaNaCutanje;
import tim1.sluzbenik.repository.ZalbaNaCutanjeRepository;

@Service
public class ZalbaNaCutanjeService extends AbstractService {

    @Autowired
    public ZalbaNaCutanjeService(ZalbaNaCutanjeRepository repository) {
        super(repository, "/db/sluzbenik/zalbanacutanje/", "/zalbanacutanje/");
    }
    
    public JaxbLista<ZalbaNaCutanje> findAllFromCollection() throws Exception{
        
        List<ZalbaNaCutanje> listaZalbi = this.findAllFromCollection( ZalbaNaCutanje.class);
        JaxbLista<ZalbaNaCutanje> listaObj = new JaxbLista<ZalbaNaCutanje>(listaZalbi);
        return listaObj;
    }
}
