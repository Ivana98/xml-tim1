package tim1.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
			DBManager.saveFileToDB("obavestenjecir.xml");
			DBManager.readFileFromDB("obavestenjecir.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
