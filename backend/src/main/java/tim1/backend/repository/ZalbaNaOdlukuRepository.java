package tim1.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.utils.DBManager;

public class ZalbaNaOdlukuRepository implements RepositoryInterface {
  @Autowired
  private DBManager dbManager;


  @Override
  public XMLResource readXML(String id) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveXML(String id) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void readRDF(String uri) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void saveRDF(String name, String uri) throws Exception {
    // TODO Auto-generated method stub

  }
}
