package tim1.sluzbenik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zahtev.Zahtev;
import tim1.sluzbenik.repository.IzvestajRepository;

@Service
public class IzvestajService extends AbstractService {

  @Autowired
  ZahtevService zahtevService;

  @Autowired
  public IzvestajService(IzvestajRepository repository) {
    super(repository, "db/sluzbenik/izvestaj/", "/izvestaj/");
  }

  public void podnesiIzvestaj() throws Exception {
    generisiPodatke();
    // generisi podatke
    // sacuvaj u bazu
    // posalji mejl povereniku da je napravljen novi izvestaj

  }

  private void generisiPodatke() throws Exception {
    int ukupanBrojZahteva = 0, brojZahtevaNaCekanju = 0, brojOdbijenihZahteva = 0, brojOdobrenihZahteva = 0;
    // content je status zahteva. moze biti: na cekanju, odbijen, odobren
    List<Zahtev> listaZahteva = zahtevService.findAllFromCollection().getLista();
    for (Zahtev zahtev : listaZahteva) {

      String status = zahtev.getContent();

      if ("na cekanju".equals(status))
        brojZahtevaNaCekanju++;

      if ("odbijen".equals(status))
        brojOdbijenihZahteva++;

      if ("odobren".equals(status))
        brojOdobrenihZahteva++;

      // u svakom slucaju uvecaj ukupan broj zahteva
      ukupanBrojZahteva++;
    }

    // System.out.println(ukupanBrojZahteva + " " + brojZahtevaNaCekanju + " " + brojOdbijenihZahteva + " " + brojOdobrenihZahteva);
    

  }

}
