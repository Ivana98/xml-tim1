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
    
    public XMLResource readXML(String id, String collectionId) throws Exception {
        return dbManager.readFileFromDB(id, collectionId);
    }

    public void saveXML(String id, String content, String collectionId) throws Exception {
        dbManager.saveFileToDB(id, collectionId, content);
    }

    public void readRDF(String uri) throws Exception {
        fusekiManager.readFile(uri);
    }

    public void saveRDF(String name, String uri)  throws Exception {
        fusekiManager.writeFuseki(name, uri);
    }

}
