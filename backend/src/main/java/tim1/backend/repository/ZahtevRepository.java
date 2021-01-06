package tim1.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.utils.DBManager;

public class ZahtevRepository implements RepositoryInterface {
  @Autowired
  private DBManager dbManager;

  @Override
  public XMLResource getById(String id) throws Exception {
    XMLResource res = null;
		try {
			res = dbManager.readFileFromDB(id);
		} catch (Exception e) {
			throw e;
    }
    return res;
  }

  @Override
  public void save(String id) throws Exception {
    try {
      dbManager.saveFileToDB(id);
    }
    catch (Exception e) {
      throw e;
    }

  }

  
}
