package tim1.sluzbenik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.repository.ZalbaNaOdlukuRepository;

@Service
public class ZalbaNaOdlukuService extends AbstractService {
    
    @Autowired
    public ZalbaNaOdlukuService(ZalbaNaOdlukuRepository repository) {
        super(repository, "/db/sluzbenik/zalbanaodluku/", "/zalbanaodluku/");
    }

}
