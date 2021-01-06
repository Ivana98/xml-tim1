package tim1.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ObavestenjeRepository;
import tim1.backend.utils.DBManager;

@SpringBootApplication
public class XmlBackendApplication {

	// run tomcat on port: 8080
	// run spring boot as usual


	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);
		xmlDatabase();

	}

	public static void xmlDatabase(){
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
