package tim1.sluzbenik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.repository.ResenjeRepository;

@Service
public class ResenjeService extends AbstractService {

    @Autowired
    public ResenjeService(ResenjeRepository repository) {
        super(repository, "/db/sluzbenik/resenje/", "/resenje/");
    }

}
