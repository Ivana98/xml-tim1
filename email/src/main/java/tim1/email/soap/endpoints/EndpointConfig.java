package tim1.email.soap.endpoints;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tim1.email.soap.Email.EmailServiceSoapBindingImpl;





@Configuration
public class EndpointConfig {

	@Autowired
	private Bus bus;

	@Autowired
	private EmailServiceSoapBindingImpl emailServiceSoapBindingImpl;


	@Bean
	public Endpoint odbijEmail(){
		EndpointImpl endpoint = new EndpointImpl(bus, emailServiceSoapBindingImpl);
		endpoint.publish("/sendEmail");
		return endpoint;
	}

}
