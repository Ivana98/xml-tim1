package tim1.sluzbenik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tim1.sluzbenik.model.zahtev.MarshallingZahtev;
import tim1.sluzbenik.model.zahtev.UnmarshallingZahtev;

@SpringBootApplication
public class SluzbenikApplication {

	public static void main(String[] args) {
		SpringApplication.run(SluzbenikApplication.class, args);

		// UnmarshallingZahtev.testXmlToObject();
		// MarshallingZahtev.testObjectToXml();
	}

}
