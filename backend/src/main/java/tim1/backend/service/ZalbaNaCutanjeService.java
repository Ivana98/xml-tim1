package tim1.backend.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.liste.ZalbaNaCutanjeLista;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.repository.ZalbaNaCutanjeRepository;

@Service
public class ZalbaNaCutanjeService extends AbstractService {

    
    @Autowired
    public ZalbaNaCutanjeService(ZalbaNaCutanjeRepository repository) {
        super(repository, "/db/poverenik/zalbanacutanje/", "/zalbanacutanje/");
    }

    public ZalbaNaCutanjeLista findAllFromCollection() throws Exception{
        
        List<ZalbaNaCutanje> listaZalbi = this.findAllFromCollection( ZalbaNaCutanje.class);
        ZalbaNaCutanjeLista listaObj = new ZalbaNaCutanjeLista(listaZalbi);
        return listaObj;
    }

    
}
