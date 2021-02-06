package tim1.sluzbenik.soap.client;
import javax.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;

@org.springframework.stereotype.Service
public class EmailClient {
  
  public void odobriZahtev(String to, String subject, String content, String pdfPath, String htmlPath ) throws Exception {
    URL wsdlLocation = new URL("http://localhost:8092/ws/sendEmail?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/email", "EmailService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/email", "EmailServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    EmailServicePortType ePortType = service.getPort(portName, EmailServicePortType.class);

    String response = ePortType.sendEmail(to, subject, content, pdfPath, htmlPath);
    System.out.println(response);
  }

  public void odbijZahtev(String emailTo, String subject, String content ) throws Exception {
    URL wsdlLocation = new URL("http://localhost:8092/ws/sendEmail?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/email", "EmailService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/email", "EmailServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    EmailServicePortType ePortType = service.getPort(portName, EmailServicePortType.class);

    String response = ePortType.sendEmail(emailTo, subject, content, "", "");
    System.out.println(response);
  }

  public void odgovoriPovereniku(String emailTo, String subject, String content, String pdfPath, String htmlPath  ) throws Exception {
    URL wsdlLocation = new URL("http://localhost:8092/ws/sendEmail?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/email", "EmailService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/email", "EmailServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    EmailServicePortType ePortType = service.getPort(portName, EmailServicePortType.class);

    String response = ePortType.sendEmail(emailTo, subject, content, pdfPath, htmlPath);
    System.out.println(response);
  }
  // public static void main(String[] args) throws Exception {
  //   EmailClient client = new EmailClient();
  //   // client.odbijZahtev("konstrukcijaitestiranje@gmail.com","Vas zahtev se odbija" , " Vas zahtev se odbija jer ne zelimo da vam isporucimo dokumenta");
  //   client.odobriZahtev("konstrukcijaitestiranje@gmail.com","Vas zahtev se odobrava" , "Odobreno", "asdf.pdf", "asdf.html");
  // }
}
