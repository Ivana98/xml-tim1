package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ResenjeRepository;

@Service
public class ResenjeService extends AbstractService {

    @Autowired
    public ResenjeService(ResenjeRepository repository) {
        super(repository, "/db/poverenik/resenje/", "/resenje/");
    }
}
