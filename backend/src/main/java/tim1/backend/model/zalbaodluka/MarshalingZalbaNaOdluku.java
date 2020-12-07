package tim1.backend.model.zalbaodluka;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class MarshalingZalbaNaOdluku {
    
    public static void test() throws DatatypeConfigurationException {
		try {
			System.out.println("[INFO] Zalba na odluku: JAXB marshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ZalbaNaOdluku zalba = (ZalbaNaOdluku) unmarshaller.unmarshal(new File("./../documents/xml_documents/zalbanaodlukucir.xml"));
			
			Date date = new Date();

	        // XMLGregorianCalendar xmlDate = null;
	        // GregorianCalendar gc = new GregorianCalendar();
	        // gc.setTime(date);

	        // try {
	        //     xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	        // } catch (NullPointerException e) {
	        //     e.printStackTrace();
	        // } catch (Exception e) {
	        //     e.printStackTrace();
	        // }
			
			zalba.getPodaciOPovereniku().setNamena("Neka nova namenaaaaa");
			// TODO: setovati jos atributa...

			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(zalba, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
