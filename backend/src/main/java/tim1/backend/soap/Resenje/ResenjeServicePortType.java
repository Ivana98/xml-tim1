package tim1.backend.soap.Resenje;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-04T17:37:52.952+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.ftn.uns.ac.rs/resenje", name = "ResenjeServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ResenjeServicePortType {

    @WebMethod
    @WebResult(name = "resenje_response", targetNamespace = "", partName = "resenje_response")
    public java.lang.String getResenjeById(
        @WebParam(partName = "id", name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @WebResult(name = "response", targetNamespace = "", partName = "response")
    public java.lang.String getAll();
}
