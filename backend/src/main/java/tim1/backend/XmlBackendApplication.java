package tim1.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tim1.backend.model.obavestenje.MarshalingObavestenjecir;
import tim1.backend.model.obavestenje.UnmarshalingObavestenjecir;
import tim1.backend.model.obavestenje.Validation;

@SpringBootApplication
public class XmlBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);
		
		try {
			// UnmarshalingObavestenjecir.test();
			// MarshalingObavestenjecir.test();
			Validation.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
