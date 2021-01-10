package tim1.backend.repository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.utils.DBManager;
import tim1.backend.utils.FusekiManager;

@Repository
public class ResenjeRepository implements RepositoryInterface {
  @Autowired
  private DBManager dbManager;

  @Autowired
  private FusekiManager fusekiManager;

  @Override
  public XMLResource readXML(String id) throws Exception {
    XMLResource res = null;
    try {
      res = dbManager.readFileFromDB(id);
    } catch (Exception e) {
      throw e;
    }
    return res;
  }

  @Override
  public void saveXML(String id) throws Exception {
    try {
      dbManager.saveFileToDB(id);
    } catch (Exception e) {
      throw e;
    }

  }

  @Override
  public void readRDF(String uri) {
    try {
      fusekiManager.readFile(uri);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void saveRDF(String name, String uri) {
    try {
      fusekiManager.writeFuseki(name, uri);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
