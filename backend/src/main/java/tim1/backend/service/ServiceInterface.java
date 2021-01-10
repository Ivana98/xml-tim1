package tim1.backend.service;

import org.xmldb.api.modules.XMLResource;

public interface ServiceInterface {
    
    void saveRDF(String name, String uri);

    void readRDF(String uri);

    void saveXML(String name);

    XMLResource readXML(String name);
}
