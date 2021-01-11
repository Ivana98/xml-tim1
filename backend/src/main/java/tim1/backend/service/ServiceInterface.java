package tim1.backend.service;

import org.xmldb.api.modules.XMLResource;

public interface ServiceInterface {

    void saveXML(String id, String content) throws Exception;

    XMLResource readXML(String name) throws Exception;
    
    void saveRDF(String name, String uri);

    void readRDF(String uri);
}
