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
import tim1.sluzbenik.soap.client.EmailClient;
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
  EmailClient emailClient;

  @Autowired
  public IzvestajService(IzvestajRepository repository) {
    super(repository, "db/sluzbenik/izvestaj/", "/izvestaj/");
  }

  /**
   * generisi podatke,
     sacuvaj u bazu,
     posalji mejl povereniku da je napravljen novi izvestaj.
   * @throws Exception
   */
  public void podnesiIzvestaj() throws Exception {
    generisiPodatke();

    // sacuvaj u bazu izvestaj- TODO

    String subject = "Godisnji izvestaj";
    String content = "Novi godisnji izvestaj pogledajte na: http://localhost:4200/homepage/izvestaji/";
    emailClient.odgovoriPovereniku("konstrukcijaitestiranje@gmail.com", subject, content);

  }

  @Override
  public void saveXML(String documentId, String content) throws Exception {
    // TODO ZAPRAVO SACUVATI IZVESTAJ
    super.saveXML(documentId, content);
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
    JaxbLista<ZalbaNaCutanje> jaxbListaZalbiNaCutanje = zalbeClient.getAllZalbaNaCutanje();
    ukupanBrojZalbi += jaxbListaZalbiNaCutanje.getLista().size();
    brojZalbiNaCutanje += jaxbListaZalbiNaCutanje.getLista().size();

    // ZALBE NA ODLUKU
    JaxbLista<ZalbaNaOdluku> jaxbListaZalbiNaOdluku = zalbeClient.getAllZalbaNaOdluku();
    ukupanBrojZalbi += jaxbListaZalbiNaOdluku.getLista().size();
    brojZalbiNaOdluku += jaxbListaZalbiNaOdluku.getLista().size();

    // TODO: SETOVATI BROJEVE ZALBI NA SAM OBJEKAT IZVESTAJ
  }

  private void generisiBrojResenja() throws Exception {
    int ukupanBrojResenja = 0;
    JaxbLista<ResenjeObrazac> jaxbListaResenja= resenjeClient.getAllResenje();
    ukupanBrojResenja = jaxbListaResenja.getLista().size();

    // TODO: SETOVATI BROJEVE RESENJA NA SAM OBJEKAT IZVESTAJ
  }
}
