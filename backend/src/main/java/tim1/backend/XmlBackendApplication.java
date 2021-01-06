package tim1.backend;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ObavestenjeRepository;
import tim1.backend.utils.DBManager;
import tim1.backend.utils.FusekiManager;
import tim1.backend.utils.MetadataExtractor;

@SpringBootApplication
public class XmlBackendApplication {

	// run tomcat on port: 8080
	// run spring boot as usual

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);

		try {
			FusekiManager.writeFuseki();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void xmlDatabase() {
		try {
			String documentName = "resenje.xml";
			DBManager.saveFileToDB(documentName);
			DBManager.readFileFromDB(documentName);

			documentName = "zalbanaodlukucir.xml";
			DBManager.saveFileToDB(documentName);
			DBManager.readFileFromDB(documentName);

			documentName = "obavestenjecir.xml";
			ObavestenjeRepository repo = new ObavestenjeRepository();
			System.out.println("\nSAVE");
			repo.save(documentName);
			System.out.println("\nGET BY ID");
			XMLResource res = repo.getById(documentName);
			System.out.println(res);

			InputStream in = new FileInputStream(new File("./../documents/xml_documents/zahtev.xml")); 
			OutputStream out = new FileOutputStream(new File("./../documents/gen/zahtev.rdf"));
			MetadataExtractor extractor = new MetadataExtractor();
			extractor.extractMetadata(in, out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
