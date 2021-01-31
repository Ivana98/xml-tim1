package tim1.sluzbenik.model.liste;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import tim1.sluzbenik.model.korisnici.Korisnik;
import tim1.sluzbenik.model.resenje.Resenje;
import tim1.sluzbenik.model.zalbacutanje.ZalbaNaCutanje;
import tim1.sluzbenik.model.zalbaodluka.ZalbaNaOdluku;

//When doing so you have to specify which classes could possibly be in the list using @XmlSeeAlso
@XmlRootElement
@XmlSeeAlso({ZalbaNaCutanje.class, ZalbaNaOdluku.class, Resenje.class, Korisnik.class})
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