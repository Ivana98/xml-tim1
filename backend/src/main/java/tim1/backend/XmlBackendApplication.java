package tim1.backend;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.zahtev.UnmarshallingZahtev;
import tim1.backend.model.zahtev.Validation;
import tim1.backend.repository.ObavestenjeRepository;
import tim1.backend.utils.DBManager;
import tim1.backend.utils.FusekiManager;
import tim1.backend.utils.MetadataExtractor;

import static tim1.backend.utils.PathConstants.*;

@SpringBootApplication
public class XmlBackendApplication {

	// run tomcat on port: 8080
	// run spring boot as usual

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);

		try {
			xmlDatabase();
			// UnmarshallingZahtev.testXmlToObject();
			// Validation.test();
			FusekiManager.writeFuseki(ZALBA_CUTANJE_RDF, ZALBA_CUTANJE_PATH_URI);
			//FusekiManager.writeFuseki();
			FusekiManager.readFile(ZALBA_CUTANJE_PATH_URI);
			//FusekiManager.readFile();
			//xmlDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void xmlDatabase() {
		try {
			// String documentName = "resenje.xml";
			// DBManager.saveFileToDB(documentName);
			// DBManager.readFileFromDB(documentName);

			// documentName = "zalbanaodlukucir.xml";
			// DBManager.saveFileToDB(documentName);
			// DBManager.readFileFromDB(documentName);

			// documentName = "obavestenjecir.xml";
			// ObavestenjeRepository repo = new ObavestenjeRepository();
			// System.out.println("\nSAVE");
			// repo.save(documentName);
			// System.out.println("\nGET BY ID");
			// XMLResource res = repo.getById(documentName);
			// System.out.println(res);

			InputStream in = new FileInputStream(new File(ZALBA_ODLUKA_XML));
			OutputStream out = new FileOutputStream(new File(ZALBA_ODLUKA_RDF));
			MetadataExtractor extractor = new MetadataExtractor();
			extractor.extractMetadata(in, out);
			System.out.println("KRAJ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
