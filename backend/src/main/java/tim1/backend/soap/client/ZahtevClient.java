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

@org.springframework.stereotype.Service
public class ZahtevClient {

  public String getOne() throws MalformedURLException, JAXBException {
    URL wsdlLocation = new URL("http://localhost:8091/api/ws/zahtev?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ZahtevServicePortType zServicePortType = service.getPort(portName, ZahtevServicePortType.class);

    String response = zServicePortType.getZahtevById("e9dda76a-48ad-4e74-9ff0-9d052f4ee4a0");
    return response;
  }

  public JaxbLista<Zahtev>  findAll() throws MalformedURLException, JAXBException {
    URL wsdlLocation = new URL("http://localhost:8091/api/ws/zahtev?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/zahtev", "ZahtevServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ZahtevServicePortType zServicePortType = service.getPort(portName, ZahtevServicePortType.class);

    String listaZahteva = zServicePortType.getAll();

    // string u jaxb
    JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(listaZahteva);
    JaxbLista<Zahtev> jaxbListaZahteva = (JaxbLista<Zahtev>) unmarshaller.unmarshal(reader);
    return jaxbListaZahteva;
  }

  // public static void main(String[] args) throws MalformedURLException,
  // JAXBException {
  // ZahtevClient client = new ZahtevClient();
  // // client.getOne();
  // client.findAll();
  // }
}
