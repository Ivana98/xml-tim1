package tim1.backend.repository;

import org.xmldb.api.modules.XMLResource;

public interface RepositoryInterface {
    
    public XMLResource readXML(String id) throws Exception;

    public void saveXML(String id) throws Exception;

    public void readRDF(String uri)  throws Exception;

    public void saveRDF(String name, String uri)  throws Exception;

}
