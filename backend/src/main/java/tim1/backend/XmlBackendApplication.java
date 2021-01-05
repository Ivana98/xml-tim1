package tim1.backend;

import org.exist.xmldb.EXistResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.zahtev.MarshallingZahtev;
import tim1.backend.model.zahtev.UnmarshallingZahtev;
import tim1.backend.model.zahtev.Validation;

import java.io.File;
import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;

import tim1.backend.model.zalbacutanje.MarshalZalbaNaCutanje;
import tim1.backend.model.zalbacutanje.UnmarshalZalbaNaCutanje;
import tim1.backend.model.zalbaodluka.MarshallingZalbaNaOdluku;
import tim1.backend.model.zalbaodluka.UnmarshallingZalbaNaOdluku;
import tim1.backend.utils.AuthenticationUtilities;
import tim1.backend.utils.AuthenticationUtilities.ConnectionProperties;
import tim1.backend.model.obavestenje.MarshalingObavestenjecir;
import tim1.backend.model.obavestenje.UnmarshalingObavestenjecir;

import tim1.backend.model.resenje.MarshalingResenje;
import tim1.backend.model.resenje.UnmarshallingResenje;

@SpringBootApplication
public class XmlBackendApplication {
	private static ConnectionProperties conn;

	//run tomcat on port: 8080
	//run spring boot as usual
	//TODO: prebaciti metode u klasu DBManager
	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);
		try {
			saveFileToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveFileToDB()
			throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

		conn = AuthenticationUtilities.loadProperties();

		String collectionId = "/db/sample/library";
		String documentId = "obavestnjePrimer.xml";
		String filePath = "documents/xml_documents/obavestenjecir.xml";

		// initialize database driver
		System.out.println("[INFO] Loading driver class: " + conn.driver);
		Class<?> cl = Class.forName(conn.driver);

		// encapsulation of the database driver functionality
		Database database = (Database) cl.newInstance();
		database.setProperty("create-database", "true");

		// entry point for the API which enables you to get the Collection reference
		DatabaseManager.registerDatabase(database);

		// a collection of Resources stored within an XML database
		Collection col = null;
		XMLResource res = null;

		try {

			System.out.println("[INFO] Retrieving the collection: " + collectionId);
			col = getOrCreateCollection(collectionId);

			/*
			 * create new XMLResource with a given id an id is assigned to the new resource
			 * if left empty (null)
			 */
			System.out.println("[INFO] Inserting the document: " + documentId);
			res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

			File f = new File(filePath);

			if (!f.canRead()) {
				System.out.println("[ERROR] Cannot read the file: " + filePath);
				return;
			}

			res.setContent(f);
			System.out.println("[INFO] Storing the document: " + res.getId());

			col.storeResource(res);
			System.out.println("[INFO] Done.");

			//print u konzolu dokumenta koji je sacuvan u bazu
			System.out.println(res.getContent());

		} finally {

			// don't forget to cleanup
			if (res != null) {
				try {
					((EXistResource) res).freeResources();
				} catch (XMLDBException xe) {
					xe.printStackTrace();
				}
			}

			if (col != null) {
				try {
					col.close();
				} catch (XMLDBException xe) {
					xe.printStackTrace();
				}
			}
		}
	}

	private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
		return getOrCreateCollection(collectionUri, 0);
	}

	private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {

		Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);

		// create the collection if it does not exist
		if (col == null) {

			if (collectionUri.startsWith("/")) {
				collectionUri = collectionUri.substring(1);
			}

			String pathSegments[] = collectionUri.split("/");

			if (pathSegments.length > 0) {
				StringBuilder path = new StringBuilder();

				for (int i = 0; i <= pathSegmentOffset; i++) {
					path.append("/" + pathSegments[i]);
				}

				Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

				if (startCol == null) {

					// child collection does not exist

					String parentPath = path.substring(0, path.lastIndexOf("/"));
					Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

					CollectionManagementService mgt = (CollectionManagementService) parentCol
							.getService("CollectionManagementService", "1.0");

					System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
					col = mgt.createCollection(pathSegments[pathSegmentOffset]);

					col.close();
					parentCol.close();

				} else {
					startCol.close();
				}
			}
			return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
		} else {
			return col;
		}
	}

	static void printZahtevi() throws DatatypeConfigurationException {
		System.out.println(System.getProperty("user.dir"));
		// zahtev
		UnmarshallingZahtev.testXmlToObject();
		MarshallingZahtev.testObjectToXml();
		Validation.test();
		// zalba na cutanje
		MarshalZalbaNaCutanje.test();
		System.out.println("\n\n");
		UnmarshalZalbaNaCutanje.test();

		try {
			UnmarshalingObavestenjecir.test();
			MarshalingObavestenjecir.test();
			tim1.backend.model.obavestenje.Validation.test();

			MarshalingResenje.test();
			UnmarshallingResenje.test();
		} catch (Exception e) {
			e.printStackTrace();
		}

		UnmarshallingZalbaNaOdluku.test();
		MarshallingZalbaNaOdluku.test();
	}

}
