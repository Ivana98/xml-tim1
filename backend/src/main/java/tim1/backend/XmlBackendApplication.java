package tim1.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tim1.backend.model.zalbacutanje.MarshalZalbaNaCutanje;
import tim1.backend.model.zalbacutanje.UnmarshalZalbaNaCutanje;

@SpringBootApplication
public class XmlBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);

		MarshalZalbaNaCutanje.test();
		UnmarshalZalbaNaCutanje.test();
	}

}
