package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.repository.ZalbaNaOdlukuRepository;

@Service
public class ZalbaNaOdlukuService extends AbstractService {
    
    @Autowired
    public ZalbaNaOdlukuService(ZalbaNaOdlukuRepository repository) {
        super(repository, "/db/poverenik/zalbanaodluku/", "/zalbanaodluku/");
    }

}
