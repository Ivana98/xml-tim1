package tim1.backend.soap.client;
import javax.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;

@org.springframework.stereotype.Service
public class EmailClient {
  
  public void posaljiResenje(String to, String subject, String content, String pdfPath, String htmlPath ) throws Exception {
    URL wsdlLocation = new URL("http://localhost:8092/ws/sendEmail?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/email", "EmailService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/email", "EmailServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    EmailServicePortType ePortType = service.getPort(portName, EmailServicePortType.class);

    String response = ePortType.sendEmail(to, subject, content, pdfPath, htmlPath);
    System.out.println(response);
  }

  public void obavestiSluzbenikaONovojZalbi(String emailTo, String subject, String content ) throws Exception {
    URL wsdlLocation = new URL("http://localhost:8092/ws/sendEmail?wsdl");
    QName serviceName = new QName("http://www.ftn.uns.ac.rs/email", "EmailService");
    QName portName = new QName("http://www.ftn.uns.ac.rs/email", "EmailServiceSoapBinding");

    Service service = Service.create(wsdlLocation, serviceName);

    EmailServicePortType ePortType = service.getPort(portName, EmailServicePortType.class);

    String response = ePortType.sendEmail(emailTo, subject, content, "", "");
    System.out.println(response);
  }


  // public static void main(String[] args) throws Exception {
  //   EmailClient client = new EmailClient();
  //   // client.odbijZahtev("konstrukcijaitestiranje@gmail.com","Vas zahtev se odbija" , " Vas zahtev se odbija jer ne zelimo da vam isporucimo dokumenta");
  //   //obavesti sluzbenika
  //   client.posaljiResenje("konstrukcijaitestiranje@gmail.com","Resenje" , "U prilogu se nalazi resenje za zahtev broj: 123", "asdf.pdf", "asdf.html");
  //   //obavesti gradjanina
  //   client.posaljiResenje("konstrukcijaitestiranje@gmail.com","Resenje" , "U prilogu se nalazi resenje za zahtev broj: 123", "asdf.pdf", "asdf.html");
  // }
}
