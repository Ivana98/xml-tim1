package tim1.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tim1.backend.model.zahtev.MarshallingZahtev;
import tim1.backend.model.zahtev.UnmarshallingZahtev;
import tim1.backend.model.zahtev.Validation;

@SpringBootApplication
public class XmlBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);

		UnmarshallingZahtev.testXmlToObject();
		MarshallingZahtev.testObjectToXml();
		Validation.test();
	}

}
