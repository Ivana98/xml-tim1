package tim1.backend.model.liste;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;


@XmlRootElement
@XmlSeeAlso({ZalbaNaCutanje.class})
public class ZalbaNaCutanjeLista {
  private List<ZalbaNaCutanje> lista = new ArrayList<>();


  public ZalbaNaCutanjeLista() {
  }

  public ZalbaNaCutanjeLista(List<ZalbaNaCutanje> lista) {
    this.lista = lista;
  }

  @XmlAnyElement
  public List<ZalbaNaCutanje> getLista() {
    return this.lista;
  }
}