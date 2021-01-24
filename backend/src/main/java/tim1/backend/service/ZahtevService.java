package tim1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.repository.ZahtevRepository;

@Service
public class ZahtevService extends AbstractService {

    @Autowired
    public ZahtevService(ZahtevRepository repository) {
        super(repository, "/db/poverenik/zahtev/", "/zahtev/");
    }


}
