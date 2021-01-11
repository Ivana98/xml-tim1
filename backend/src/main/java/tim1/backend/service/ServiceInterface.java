package tim1.backend.service;

import org.xmldb.api.modules.XMLResource;

public interface ServiceInterface {

    void saveXML(String documentId, String content) throws Exception;

    XMLResource readXML(String documentId) throws Exception;
    
    void saveRDF(String xmlName, String rdfName, String uri)  throws Exception;

    String readFileAsXML(String uri)  throws Exception;
    
    String readFileAsJSON(String uri)  throws Exception;
}
