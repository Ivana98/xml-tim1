
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package tim1.email.soap.Email;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-04T10:20:03.843+01:00
 * Generated source version: 3.2.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "EmailService",
                      portName = "EmailServiceSoapBinding",
                      targetNamespace = "http://www.ftn.uns.ac.rs/email",
                      wsdlLocation = "classpath:wsdl/Email.wsdl",
                      endpointInterface = "tim1.email.soap.Email.EmailServicePortType")
@Service            
public class EmailServiceSoapBindingImpl implements EmailServicePortType {

    private static final Logger LOG = Logger.getLogger(EmailServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see rs.ac.uns.ftn.email.EmailServicePortType#sendEmail(java.lang.String to, java.lang.String from, java.lang.String subject, java.lang.String content)*
     */
    public java.lang.String sendEmail(java.lang.String to, java.lang.String from, java.lang.String subject, java.lang.String content) { 
        LOG.info("Executing operation sendEmail");
        System.out.println(to);
        System.out.println(from);
        System.out.println(subject);
        System.out.println(content);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}