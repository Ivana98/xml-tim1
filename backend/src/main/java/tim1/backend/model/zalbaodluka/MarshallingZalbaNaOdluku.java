package tim1.backend.model.zalbaodluka;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;


public class MarshallingZalbaNaOdluku {
    
    public static void test() throws DatatypeConfigurationException {
		try {
			System.out.println("[INFO] Zalba na odluku: JAXB marshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ZalbaNaOdluku zalba = (ZalbaNaOdluku) unmarshaller.unmarshal(new File("./../documents/xml_documents/zalbanaodlukucir.xml"));
			

			
			zalba.getPodaciOPovereniku().setNamena("Neka nova namena");
			zalba.getPodaciOPovereniku().getAdresa().setGrad("Novi Sad");
			zalba.getPodaciOPovereniku().getAdresa().setBroj("29");

			ObjectFactory factory = new ObjectFactory();
			Adresa adresa = factory.createAdresa();
			adresa.setBroj("12");
			adresa.setGrad("Beograd");
			adresa.setUlica("Beogradski kej");
			
			JAXBElement<TFizickoLice> z = (JAXBElement<TFizickoLice>) zalba.getZalba().getContent().get(1);
			z.getValue().setAdresa(adresa);
			z.getValue().setIme("Marko");
			z.getValue().setPrezime("Petrovic");
			z.getValue().setSediste("Novi Beograd");

			VremeIMesto vremeIMesto = (VremeIMesto) zalba.getZalba().getContent().get(13);
			vremeIMesto.setGrad("Novi Sad");

			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(zalba, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
