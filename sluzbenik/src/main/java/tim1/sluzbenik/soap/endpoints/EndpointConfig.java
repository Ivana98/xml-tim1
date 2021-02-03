package tim1.sluzbenik.soap.endpoints;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tim1.sluzbenik.soap.Zahtev.ZahtevServiceSoapBindingImpl;



@Configuration
public class EndpointConfig {

	@Autowired
	private Bus bus;

	@Autowired
	private ZahtevServiceSoapBindingImpl zahtevServiceSoapBindingImpl;


	@Bean
	public Endpoint zalbaNaCutanje(){
		EndpointImpl endpoint = new EndpointImpl(bus, zahtevServiceSoapBindingImpl);
		endpoint.publish("/zahtev");
		return endpoint;
	}

}
