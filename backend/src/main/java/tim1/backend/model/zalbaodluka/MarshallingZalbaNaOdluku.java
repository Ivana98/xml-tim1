package tim1.backend.model.zalbaodluka;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;

import tim1.backend.model.zalbaodluka.Adresa.Grad;
import tim1.backend.model.zalbaodluka.Adresa.Ulica;

import static tim1.backend.utils.PathConstants.*;

public class MarshallingZalbaNaOdluku {
    
    public static void test() throws DatatypeConfigurationException {
		try {
			System.out.println("[INFO] Zalba na odluku: JAXB marshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ZalbaNaOdluku zalba = (ZalbaNaOdluku) unmarshaller.unmarshal(new File("./documents/xml_documents/zalbanaodlukucir.xml"));
			

			
			zalba.getPodaciOPovereniku().setNamena("Neka nova namena");
			zalba.getPodaciOPovereniku().getAdresa().getGrad().setValue("Novi Sad");
			zalba.getPodaciOPovereniku().getAdresa().setBroj("29");

			ObjectFactory factory = new ObjectFactory();
			Adresa adresa = factory.createAdresa();
			adresa.setBroj("12");

			Grad grad = new Grad();
			grad.setValue("Beograd");
			adresa.setGrad(grad);
			//adresa.getGrad().setValue("Beograd");
			Ulica ulica = new Ulica();
			ulica.setValue("Beogradski kej");
			adresa.setUlica(ulica);
			
			JAXBElement<TFizickoLice> z = (JAXBElement<TFizickoLice>) zalba.getZalba().getContent().get(1);
			z.getValue().setAdresa(adresa);
			z.getValue().getIme().setValue("Marko");
			z.getValue().getPrezime().setValue("Petrovic");
			z.getValue().getSediste().setValue("Novi Beograd");

			VremeIMesto vremeIMesto = (VremeIMesto) zalba.getZalba().getContent().get(13);
			vremeIMesto.getGrad().setValue("Novi Sad");

			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(zalba, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
