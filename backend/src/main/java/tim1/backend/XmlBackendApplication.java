package tim1.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tim1.backend.model.zahtev.MarshallingZahtev;
import tim1.backend.model.zahtev.UnmarshallingZahtev;
import tim1.backend.model.zahtev.Validation;

import javax.xml.datatype.DatatypeConfigurationException;

import tim1.backend.model.zalbacutanje.MarshalZalbaNaCutanje;
import tim1.backend.model.zalbacutanje.UnmarshalZalbaNaCutanje;

@SpringBootApplication
public class XmlBackendApplication {

	public static void main(String[] args) throws DatatypeConfigurationException {
		SpringApplication.run(XmlBackendApplication.class, args);

		System.out.println(System.getProperty("user.dir"));
		//zahtev
		UnmarshallingZahtev.testXmlToObject();
		MarshallingZahtev.testObjectToXml();
		Validation.test();
		//zalba na cutanje
		MarshalZalbaNaCutanje.test();
		System.out.println("\n\n");
		UnmarshalZalbaNaCutanje.test();


	}

}
