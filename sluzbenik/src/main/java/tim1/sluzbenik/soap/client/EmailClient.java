package tim1.sluzbenik.soap.client;
import javax.xml.ws.Service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import javax.xml.namespace.QName;

@org.springframework.stereotype.Service
public class EmailClient {
  
  public String odbijZahtev(String to, String from, String subject, String content ) throws Exception {
    //TODO: NAPRAVITI KONEKCIJU SA MEJLOM.
    URL wsdlLocation = new URL("http://localhost:8092/ws/sendEmail?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/email", "EmailService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/email", "EmailServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    EmailServicePortType ePortType = service.getPort(portName, EmailServicePortType.class);

    String response = ePortType.sendEmail("pera", "zika", "subject", "content");
    System.out.println(response);
    return null;
  }
  public static void main(String[] args) throws Exception {
    EmailClient client = new EmailClient();
    client.odbijZahtev(null,null,null,null);
  }
}
