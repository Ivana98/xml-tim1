package tim1.backend.model.liste;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import tim1.backend.model.korisnici.Korisnik;
import tim1.backend.model.obavestenje.Obavestenje;
import tim1.backend.model.resenje.Resenje;
import tim1.backend.model.zahtev.Zahtev;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.model.zalbaodluka.ZalbaNaOdluku;

//When doing so you have to specify which classes could possibly be in the list using @XmlSeeAlso
@XmlRootElement
@XmlSeeAlso({ZalbaNaCutanje.class, ZalbaNaOdluku.class, Zahtev.class, Resenje.class, Obavestenje.class, Korisnik.class})
public class JaxbLista<T> {
  private List<T> lista = new ArrayList<>();


  public JaxbLista() {
  }

  public JaxbLista(List<T> lista) {
    this.lista = lista;
  }

  @XmlAnyElement
  public List<T> getLista() {
    return this.lista;
  }
}