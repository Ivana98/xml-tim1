package tim1.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.zahtev.MarshallingZahtev;
import tim1.backend.model.zahtev.UnmarshallingZahtev;
import tim1.backend.model.zahtev.Validation;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.annotation.PostConstruct;
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

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);
		try {
			initDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initDB()
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		ConnectionProperties conn = AuthenticationUtilities.loadProperties();
		Class<?> cl = Class.forName(conn.driver);
		Database database = (Database) cl.newInstance();
		database.setProperty("create-database", "true");
		DatabaseManager.registerDatabase(database);

		
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
