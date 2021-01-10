package tim1.backend.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.utils.DBManager;

@Repository
public class ObavestenjeRepository implements RepositoryInterface {

  @Autowired
  private DBManager dbManager;

  public XMLResource getById(String id) throws Exception {

		XMLResource res = null;
		try {
			res = dbManager.readFileFromDB(id);
		} catch (Exception e) {
			throw e;
    }
    return res;

  }

  public void save(String id) throws Exception {

	  try {
		dbManager.saveFileToDB(id);
	  }
	  catch (Exception e) {
		throw e;
	  }
  }

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
