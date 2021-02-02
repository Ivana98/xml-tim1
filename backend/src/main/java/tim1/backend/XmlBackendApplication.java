package tim1.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class XmlBackendApplication {

	// run tomcat on port: 8080
	// run spring boot as usual (on port 8090)

	public static void main(String[] args) throws Exception {
		// pristupiti endpoitima na: http://localhost:8090/api/ws
		SpringApplication.run(XmlBackendApplication.class, args);
	}

}
