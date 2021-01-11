package tim1.backend.repository;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.utils.DBManager;
import tim1.backend.utils.FusekiManager;
import tim1.backend.utils.MetadataExtractor;

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

    public void readRDF(String uri) throws Exception {
        fusekiManager.readFile(uri);
    }

    public void saveRDF(String content, String rdfName, String uri)  throws Exception {
        InputStream in = new ByteArrayInputStream(content.getBytes());
		OutputStream out = new FileOutputStream(new File(rdfName));
		MetadataExtractor extractor = new MetadataExtractor();
		extractor.extractMetadata(in, out);
        fusekiManager.writeFuseki(rdfName, uri);
    }

}
