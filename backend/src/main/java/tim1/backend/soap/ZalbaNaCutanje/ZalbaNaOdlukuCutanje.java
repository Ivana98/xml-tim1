package tim1.backend.soap.ZalbaNaCutanje;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-05T23:02:20.877+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "ZalbaNaOdlukuCutanje", 
                  wsdlLocation = "classpath:wsdl/ZalbaNaCutanje.wsdl",
                  targetNamespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje") 
public class ZalbaNaOdlukuCutanje extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "ZalbaNaOdlukuCutanje");
    public final static QName ZalbaNaCutanjeServiceSoapBinding = new QName("http://www.ftn.uns.ac.rs/zalba-na-cutanje", "ZalbaNaCutanjeServiceSoapBinding");
    static {
        URL url = ZalbaNaOdlukuCutanje.class.getClassLoader().getResource("wsdl/ZalbaNaCutanje.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(ZalbaNaOdlukuCutanje.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/ZalbaNaCutanje.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public ZalbaNaOdlukuCutanje(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ZalbaNaOdlukuCutanje(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ZalbaNaOdlukuCutanje() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ZalbaNaOdlukuCutanje(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ZalbaNaOdlukuCutanje(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ZalbaNaOdlukuCutanje(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ZalbaNaCutanjeServicePortType
     */
    @WebEndpoint(name = "ZalbaNaCutanjeServiceSoapBinding")
    public ZalbaNaCutanjeServicePortType getZalbaNaCutanjeServiceSoapBinding() {
        return super.getPort(ZalbaNaCutanjeServiceSoapBinding, ZalbaNaCutanjeServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ZalbaNaCutanjeServicePortType
     */
    @WebEndpoint(name = "ZalbaNaCutanjeServiceSoapBinding")
    public ZalbaNaCutanjeServicePortType getZalbaNaCutanjeServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(ZalbaNaCutanjeServiceSoapBinding, ZalbaNaCutanjeServicePortType.class, features);
    }

}
