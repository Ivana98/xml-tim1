package tim1.backend;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.obavestenje.Obavestenje;
import tim1.backend.repository.ObavestenjeRepository;
import tim1.backend.utils.DBManager;
import tim1.backend.utils.AuthenticationUtilities.ConnectionProperties;

@SpringBootApplication
public class XmlBackendApplication {

	// run tomcat on port: 8080
	// run spring boot as usual
	// TODO: prebaciti metode u klasu DBManager


	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);

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
