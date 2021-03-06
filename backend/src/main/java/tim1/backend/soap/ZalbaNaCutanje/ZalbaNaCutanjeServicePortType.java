package tim1.backend.soap.ZalbaNaCutanje;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-05T23:02:20.869+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "ZalbaNaCutanjeServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ZalbaNaCutanjeServicePortType {

    @WebMethod(action = "http://www.zalbanacutanje.com/ws/oznaciZalbuKaoProcitanu")
    @WebResult(name = "zalba_cutanje", targetNamespace = "", partName = "zalba_cutanje")
    public java.lang.String oznaciZalbuKaoProcitanu(
        @WebParam(partName = "id", name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod(action = "http://www.zalbanacutanje.com/ws/getAll")
    @WebResult(name = "response", targetNamespace = "", partName = "response")
    public java.lang.String getAll();

    @WebMethod(action = "http://www.zalbanacutanje.com/ws/getZalbaNaCutanjeById")
    @WebResult(name = "zalba_cutanje", targetNamespace = "", partName = "zalba_cutanje")
    public java.lang.String getZalbaNaCutanjeById(
        @WebParam(partName = "id", name = "id", targetNamespace = "")
        java.lang.String id
    );
}
