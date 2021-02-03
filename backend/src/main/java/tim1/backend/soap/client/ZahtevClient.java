package tim1.backend.soap.client;

import javax.xml.ws.Service;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zahtev.Zahtev;

import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

// @Service
public class ZahtevClient {

  public void getOne() throws MalformedURLException, JAXBException {
    URL wsdlLocation = new URL("http://localhost:8091/api/ws/zahtev?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ZahtevServicePortType zServicePortType = service.getPort(portName, ZahtevServicePortType.class);

    String response = zServicePortType.getZahtevById("e9dda76a-48ad-4e74-9ff0-9d052f4ee4a0");
    JAXBContext context = JAXBContext.newInstance(Zahtev.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(response);
    Zahtev z = (Zahtev) unmarshaller.unmarshal(reader);
    System.out.println(response);
  } 
  public void findAll() throws MalformedURLException, JAXBException {
    URL wsdlLocation = new URL("http://localhost:8091/api/ws/zahtev?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ZahtevServicePortType zServicePortType = service.getPort(portName, ZahtevServicePortType.class);

    String response = zServicePortType.getAll();
    JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(response);
    JaxbLista<Zahtev> lista = (JaxbLista<Zahtev>) unmarshaller.unmarshal(reader);
    for (Zahtev  z : lista.getLista()) {
      System.out.println(z.getNaslov());
    }
  } 

  public static void main(String[] args) throws MalformedURLException, JAXBException {
    ZahtevClient client = new ZahtevClient();
    // client.getOne();
    client.findAll();
  }
}
