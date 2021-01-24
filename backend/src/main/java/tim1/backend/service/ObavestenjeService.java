package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.repository.ObavestenjeRepository;

@Service
public class ObavestenjeService extends AbstractService {

    @Autowired
    public ObavestenjeService(ObavestenjeRepository repository) {
        super(repository, "/db/poverenik/obavestenje/", "/obavestenje/");
    }
}
