package tim1.sluzbenik.soap.client;

import javax.xml.ws.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.zalbacutanje.ZalbaNaCutanje;
import tim1.sluzbenik.model.zalbaodluka.ZalbaNaOdluku;

import java.io.StringReader;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

@org.springframework.stereotype.Service
public class ZalbeClient {

  public JaxbLista<ZalbaNaCutanje> getAllZalbaNaCutanje() throws Exception {
    URL wsdlLocation = new URL("http://localhost:8090/api/ws/zalba-na-cutanje?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "ZalbaNaOdlukuCutanje");
    QName portName = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "ZalbaNaCutanjeServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ZalbaNaCutanjeServicePortType zPortType = service.getPort(portName, ZalbaNaCutanjeServicePortType.class);
    String listaString = zPortType.getAll();

    // string u jaxb
    JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(listaString);
    JaxbLista<ZalbaNaCutanje> jaxbListaZalbiNaCutanje = (JaxbLista<ZalbaNaCutanje>) unmarshaller.unmarshal(reader);

    return jaxbListaZalbiNaCutanje;
  }

  public JaxbLista<ZalbaNaOdluku> getAllZalbaNaOdluku() throws Exception {
    URL wsdlLocation = new URL("http://localhost:8090/api/ws/zalba-na-odluku?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "ZalbaNaOdlukuService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/zalba-na-odluku", "ZalbaNaOdlukuServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ZalbaNaOdlukuServicePortType zPortType = service.getPort(portName, ZalbaNaOdlukuServicePortType.class);
    String listaString = zPortType.getAll();

    // string u jaxb
    JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(listaString);
    JaxbLista<ZalbaNaOdluku> jaxbListaZalbiNaCutanje = (JaxbLista<ZalbaNaOdluku>) unmarshaller.unmarshal(reader);
    return jaxbListaZalbiNaCutanje;
  }

  public String oznaciZalbuKaoProcitanu(String idZalbe) throws Exception{
    URL wsdlLocation = new URL("http://localhost:8090/api/ws/zalba-na-cutanje?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "ZalbaNaOdlukuCutanje");
    QName portName = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "ZalbaNaCutanjeServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ZalbaNaCutanjeServicePortType zPortType = service.getPort(portName, ZalbaNaCutanjeServicePortType.class);
    String status = zPortType.oznaciZalbuKaoProcitanu(idZalbe);

    return status;
  }

    public static void main(String[] args) throws Exception {
      ZalbeClient client = new ZalbeClient();
    System.out.println(client.oznaciZalbuKaoProcitanu("21e8208c-5fa6-426f-93b9-c6a19091b1c5"));
  }
}
