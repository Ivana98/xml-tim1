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

  /*
  public void save(XMLResource res, String id) throws Exception {
		Marshaller marshaller = marshallerFactory.createMarshaller(contextPath, schemaPath);

		Collection col = null;
		XMLResource res = null;
		OutputStream os = new ByteArrayOutputStream();

		try {
			res = dbManager.saveFileToDB(id);
			marshaller.marshal(obavestenje, os);

			res.setContent(os);

			col.storeResource(res);
		} catch (Exception e) {
			throw e;
		} finally {
			databaseConnector.closeConnections(res, col);
		}
	}*/

  
}
