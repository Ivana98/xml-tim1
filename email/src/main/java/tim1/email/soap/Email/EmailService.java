package tim1.email.soap.Email;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-04T10:20:03.893+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "EmailService", 
                  wsdlLocation = "classpath:wsdl/Email.wsdl",
                  targetNamespace = "http://www.ftn.uns.ac.rs/email") 
public class EmailService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.ftn.uns.ac.rs/email", "EmailService");
    public final static QName EmailServiceSoapBinding = new QName("http://www.ftn.uns.ac.rs/email", "EmailServiceSoapBinding");
    static {
        URL url = EmailService.class.getClassLoader().getResource("wsdl/Email.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(EmailService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/Email.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public EmailService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmailService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmailService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public EmailService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EmailService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EmailService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns EmailServicePortType
     */
    @WebEndpoint(name = "EmailServiceSoapBinding")
    public EmailServicePortType getEmailServiceSoapBinding() {
        return super.getPort(EmailServiceSoapBinding, EmailServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmailServicePortType
     */
    @WebEndpoint(name = "EmailServiceSoapBinding")
    public EmailServicePortType getEmailServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(EmailServiceSoapBinding, EmailServicePortType.class, features);
    }

}
