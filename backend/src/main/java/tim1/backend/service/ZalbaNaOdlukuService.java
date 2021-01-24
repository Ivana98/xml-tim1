package tim1.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zalbaodluka.ZalbaNaOdluku;
import tim1.backend.repository.ZalbaNaOdlukuRepository;

@Service
public class ZalbaNaOdlukuService extends AbstractService {
    
    @Autowired
    public ZalbaNaOdlukuService(ZalbaNaOdlukuRepository repository) {
        super(repository, "/db/poverenik/zalbanaodluku/", "/zalbanaodluku/");
    }

    public JaxbLista<ZalbaNaOdluku> findAllFromCollection() throws Exception{

        List<ZalbaNaOdluku> listaZalbi = this.findAllFromCollection(ZalbaNaOdluku.class);
        JaxbLista<ZalbaNaOdluku> listaObj = new JaxbLista<ZalbaNaOdluku>(listaZalbi);
        return listaObj;
    }

}
