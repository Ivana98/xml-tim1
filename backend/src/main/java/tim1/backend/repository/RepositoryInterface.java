package tim1.backend.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.utils.DBManager;
import tim1.backend.utils.FusekiManager;

@Repository
public abstract class RepositoryInterface {

    @Autowired
    private DBManager dbManager;
  
    @Autowired
    private FusekiManager fusekiManager;
    
    public XMLResource readXML(String documentId, String collectionId) throws Exception {
        return dbManager.readFileFromDB(documentId, collectionId);
    }

    public void saveXML(String documentId, String collectionId, String content) throws Exception {
        dbManager.saveFileToDB(documentId, collectionId, content);
    }

    public String readFileAsXML(String uri) throws Exception {
       return fusekiManager.readFileAsXML(uri);
    }
    public String readFileAsJSON(String uri) throws Exception {
        return fusekiManager.readFileAsJSON(uri);
    }

    public void saveRDF(String name, String uri)  throws Exception {
        fusekiManager.writeFuseki(name, uri);
    }

}
