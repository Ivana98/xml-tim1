package tim1.backend.soap.endpoints;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tim1.backend.soap.ZalbaNaCutanje.ZalbaNaCutanjeServiceSoapBindingImpl;
import tim1.backend.soap.ZalbaNaOdluku.ZalbaNaOdlukuServiceSoapBindingImpl;
import tim1.backend.soap.hello.HelloDocumentImpl;




@Configuration
public class EndpointConfig {

	@Autowired
	private Bus bus;
	@Bean
	public Endpoint helloEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new HelloDocumentImpl());
		endpoint.publish("/hello");
		return endpoint;
	}

	@Bean
	public Endpoint zalbaNaCutanje(){
		EndpointImpl endpoint = new EndpointImpl(bus, new ZalbaNaCutanjeServiceSoapBindingImpl());
		endpoint.publish("/zalba-na-cutanje");
		return endpoint;
	}
	@Bean
	public Endpoint zalbaNaOdluku(){
		EndpointImpl endpoint = new EndpointImpl(bus, new ZalbaNaOdlukuServiceSoapBindingImpl());
		endpoint.publish("/zalba-na-odluku");
		return endpoint;
	}
}
