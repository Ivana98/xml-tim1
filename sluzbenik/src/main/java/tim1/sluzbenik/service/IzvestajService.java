package tim1.sluzbenik.service;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.sluzbenik.model.izvestaj.Izvestaj;
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

  private int ukupanBrojZahteva = 0, brojOdbijenihZahteva = 0, brojOdobrenihZahteva = 0;
  private int ukupanBrojZalbi = 0, brojZalbiNaCutanje = 0, brojZalbiNaOdluku = 0;
  private int ukupanBrojResenja = 0;

  @Autowired
  public IzvestajService(IzvestajRepository repository) {
    super(repository, "db/sluzbenik/izvestaj/", "/izvestaj/");
  }


  public void podnesiIzvestaj() throws Exception {
    // generisi podatke    
    generisiPodatke();
    
    // setuj sve podatke na izvestaj
    Izvestaj izvestaj = new Izvestaj();
    izvestaj.setSviZahtevi(ukupanBrojZahteva);
    izvestaj.setOdbijeniZahtevi(brojOdbijenihZahteva);
    izvestaj.setOdobreniZahtevi(brojOdobrenihZahteva);
    izvestaj.setSveZalbe(ukupanBrojZalbi);
    izvestaj.setZalbeNaCutanje(brojZalbiNaCutanje);
    izvestaj.setZalbeNaOdluku(brojZalbiNaOdluku);
    izvestaj.setResenja(ukupanBrojResenja);

    // sacuvaj u bazu izvestaj
    saveXML(izvestaj);

    //TODO: OTKOMENTARISATI
    // posalji mejl povereniku da je napravljen novi izvestaj.
    // String subject = "Godisnji izvestaj";
    // String content = "Novi godisnji izvestaj pogledajte na: http://localhost:4200/homepage/izvestaji/";
    // emailClient.odgovoriPovereniku("konstrukcijaitestiranje@gmail.com", subject, content);

  }

  
  public void saveXML(Izvestaj izvestaj) throws Exception {

    JAXBContext context = JAXBContext.newInstance(Izvestaj.class);
    Marshaller jaxbMarshaller = context.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    jaxbMarshaller.marshal(izvestaj, stream);

    String content = new String(stream.toByteArray());
    String documentId = UUID.randomUUID().toString();;

    super.saveXML(documentId, content);
  }


  private void generisiPodatke() throws Exception {
    generisiBrojZahteva();
    generisiBrojZalbi();
    generisiBrojResenja();
  }

  private void generisiBrojZahteva() throws Exception {
    // ZAHTEVI
    // content je status zahteva. moze biti: na cekanju, odbijen, odobren
    List<Zahtev> listaZahteva = zahtevService.findAllFromCollection().getLista();
    for (Zahtev zahtev : listaZahteva) {

      String status = zahtev.getContent();

      if ("odbijen".equals(status))
        brojOdbijenihZahteva++;

      if ("odobren".equals(status))
        brojOdobrenihZahteva++;

      // u svakom slucaju uvecaj ukupan broj zahteva
      ukupanBrojZahteva++;
    }

  }

  private void generisiBrojZalbi() throws Exception {

    // ZALBE NA CUTANJE
    JaxbLista<ZalbaNaCutanje> jaxbListaZalbiNaCutanje = zalbeClient.getAllZalbaNaCutanje();
    ukupanBrojZalbi += jaxbListaZalbiNaCutanje.getLista().size();
    brojZalbiNaCutanje += jaxbListaZalbiNaCutanje.getLista().size();

    // ZALBE NA ODLUKU
    JaxbLista<ZalbaNaOdluku> jaxbListaZalbiNaOdluku = zalbeClient.getAllZalbaNaOdluku();
    ukupanBrojZalbi += jaxbListaZalbiNaOdluku.getLista().size();
    brojZalbiNaOdluku += jaxbListaZalbiNaOdluku.getLista().size();

  }

  private void generisiBrojResenja() throws Exception {
    ukupanBrojResenja = 0;
    JaxbLista<ResenjeObrazac> jaxbListaResenja= resenjeClient.getAllResenje();
    ukupanBrojResenja = jaxbListaResenja.getLista().size();

  }


public JaxbLista<Izvestaj> findAllFromCollection() throws Exception {
  List<Izvestaj> listaIzvestaja = this.findAllFromCollection(Izvestaj.class);
  JaxbLista<Izvestaj> listaObj = new JaxbLista<Izvestaj>(listaIzvestaja);
	return listaObj;
}
}
