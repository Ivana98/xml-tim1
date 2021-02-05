package tim1.sluzbenik.soap.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-03T17:47:06.643+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.ftn.uns.ac.rs/zalba-na-cutanje", name = "ZalbaNaCutanjeServicePortType")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ZalbaNaCutanjeServicePortType {

    @WebMethod(action = "http://www.zalbanaodluku.com/ws/getAll")
    @WebResult(name = "response", targetNamespace = "", partName = "response")
    public java.lang.String getAll();

    @WebMethod(action = "http://www.zalbanaodluku.com/ws/getZalbaNaCutanjeById")
    @WebResult(name = "zalba_cutanje", targetNamespace = "", partName = "zalba_cutanje")
    public java.lang.String getZalbaNaCutanjeById(
        @WebParam(partName = "id", name = "id", targetNamespace = "")
        java.lang.String id
    );
}
