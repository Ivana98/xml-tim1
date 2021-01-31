package tim1.sluzbenik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.repository.ZalbaNaCutanjeRepository;

@Service
public class ZalbaNaCutanjeService extends AbstractService {

    @Autowired
    public ZalbaNaCutanjeService(ZalbaNaCutanjeRepository repository) {
        super(repository, "/db/sluzbenik/zalbanacutanje/", "/zalbanacutanje/");
    }
    
}
