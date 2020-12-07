package tim1.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tim1.backend.model.resenje.MarshalingResenje;
import tim1.backend.model.resenje.UnmarshallingResenje;

@SpringBootApplication
public class XmlBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);

		try {
			MarshalingResenje.test();
			UnmarshallingResenje.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
