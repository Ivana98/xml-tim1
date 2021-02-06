package tim1.sluzbenik.soap.client;

import java.io.StringReader;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.resenje.ResenjeObrazac;

@org.springframework.stereotype.Service
public class ResenjeClient {

  public JaxbLista<ResenjeObrazac>  getAllResenje() throws Exception {
    URL wsdlLocation = new URL("http://localhost:8090/api/ws/resenje?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/resenje", "ResenjeService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/resenje", "ResenjeServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ResenjeServicePortType rPortType = service.getPort(portName, ResenjeServicePortType.class);
    String listaResenje = rPortType.getAll();

    // string u jaxb
    JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(listaResenje);
    JaxbLista<ResenjeObrazac> jaxbListaResenja = (JaxbLista<ResenjeObrazac>) unmarshaller.unmarshal(reader);
    return jaxbListaResenja;
  }

  public String getOne(String id) throws Exception {
    URL wsdlLocation = new URL("http://localhost:8090/api/ws/resenje?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/resenje", "ResenjeService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/resenje", "ResenjeServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    ResenjeServicePortType rPortType = service.getPort(portName, ResenjeServicePortType.class);
    String resenje = rPortType.getResenjeById(id);
    return resenje;
  }

  // public static void main(String[] args) throws Exception {
  // ResenjeClient client = new ResenjeClient();
  // System.out.println(client.getOne("00d6abb1-1207-453a-9ac6-4c3e4029293d"));
  // System.out.println(client.getAllResenje());
  // }
}
