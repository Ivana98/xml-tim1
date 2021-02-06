package tim1.sluzbenik.service;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.resenje.ResenjeObrazac;
import tim1.sluzbenik.model.zahtev.Zahtev;
import tim1.sluzbenik.model.zalbacutanje.ZalbaNaCutanje;
import tim1.sluzbenik.model.zalbaodluka.ZalbaNaOdluku;
import tim1.sluzbenik.repository.IzvestajRepository;
import tim1.sluzbenik.soap.client.ResenjeClient;
import tim1.sluzbenik.soap.client.ZalbeClient;

@Service
public class IzvestajService extends AbstractService {

  @Autowired
  ZahtevService zahtevService;

  @Autowired
  private ZalbeClient zalbeClient;

  @Autowired
  private ResenjeClient resenjeClient;

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
    generisiBrojZahteva();
    generisiBrojZalbi();
    generisiBrojResenja();
  }

  private void generisiBrojZahteva() throws Exception {
    // ZAHTEVI
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

    // TODO: SETOVATI BROJEVE ZAHTEVA NA SAM OBJEKAT IZVESTAJ
  }

  private void generisiBrojZalbi() throws Exception {
    int ukupanBrojZalbi = 0;
    int brojZalbiNaCutanje = 0;
    int brojZalbiNaOdluku = 0;

    // ZALBE NA CUTANJE
    String listaString = zalbeClient.getAllZalbaNaCutanje();
    JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(listaString);
    JaxbLista<ZalbaNaCutanje> jaxbListaZalbiNaCutanje = (JaxbLista<ZalbaNaCutanje>) unmarshaller.unmarshal(reader);
    ukupanBrojZalbi += jaxbListaZalbiNaCutanje.getLista().size();
    brojZalbiNaCutanje += jaxbListaZalbiNaCutanje.getLista().size();

    // ZALBE NA ODLUKU
    listaString = zalbeClient.getAllZalbaNaOdluku();
    context = JAXBContext.newInstance(JaxbLista.class);
    unmarshaller = context.createUnmarshaller();
    reader = new StringReader(listaString);
    JaxbLista<ZalbaNaOdluku> jaxbListaZalbiNaOdluku = (JaxbLista<ZalbaNaOdluku>) unmarshaller.unmarshal(reader);
    ukupanBrojZalbi += jaxbListaZalbiNaOdluku.getLista().size();
    brojZalbiNaOdluku += jaxbListaZalbiNaOdluku.getLista().size();

    // TODO: SETOVATI BROJEVE ZALBI NA SAM OBJEKAT IZVESTAJ
  }

  private void generisiBrojResenja() throws Exception {
    int ukupanBrojResenja = 0;
    String listaString = resenjeClient.getAllResenje();
    JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(listaString);
    JaxbLista<ResenjeObrazac> jaxbListaResenja = (JaxbLista<ResenjeObrazac>) unmarshaller.unmarshal(reader);
    ukupanBrojResenja = jaxbListaResenja.getLista().size();

    // TODO: SETOVATI BROJEVE RESENJA NA SAM OBJEKAT IZVESTAJ
  }
}
