package tim1.backend.model.zalbaodluka;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;


public class MarshalingZalbaNaOdluku {
    
    public static void test() throws DatatypeConfigurationException {
		try {
			System.out.println("[INFO] Zalba na odluku: JAXB marshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ZalbaNaOdluku zalba = (ZalbaNaOdluku) unmarshaller.unmarshal(new File("documents/xml_documents/zalbanaodlukucir.xml"));
			

			
			zalba.getPodaciOPovereniku().setNamena("Neka nova namena");
			zalba.getPodaciOPovereniku().getAdresa().setGrad("Novi Sad");
			zalba.getPodaciOPovereniku().getAdresa().setBroj("29");

			ObjectFactory factory = new ObjectFactory();
			Adresa adresa = factory.createAdresa();
			adresa.setBroj("12");
			adresa.setGrad("Beograd");
			adresa.setUlica("Beogradski kej");
			
			Zalilac z = (Zalilac) zalba.getZalba().getContent().get(3);
			z.setAdresa(adresa);
			z.setIme("Marko");
			z.setPrezime("Petrovic");
			z.setSediste("Novi Beograd");

			VremeIMesto vremeIMesto = (VremeIMesto) zalba.getZalba().getContent().get(15);
			vremeIMesto.setGrad("Novi Sad");

			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(zalba, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
