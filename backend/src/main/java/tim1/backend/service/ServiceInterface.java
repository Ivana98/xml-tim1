package tim1.backend.service;

import org.xmldb.api.modules.XMLResource;

public interface ServiceInterface {

    void saveXML(String documentId, String content) throws Exception;

    XMLResource readXML(String documentId) throws Exception;
    
    void saveRDF(String name, String uri)  throws Exception;

    void readRDF(String uri)  throws Exception;
}
