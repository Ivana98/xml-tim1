package tim1.backend.model.zalbacutanje;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class MarshalZalbaNaCutanje {
	
	public static void test() throws DatatypeConfigurationException {
		try {
			System.out.println("[INFO] Zalba na cutanje: JAXB marshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance("tim1.backend.model.zalbacutanje");
			
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(new File("./../documents/xml_documents/zalbacutanjecir.xml"));
			
			Date date = new Date();

	        XMLGregorianCalendar xmlDate = null;
	        GregorianCalendar gc = new GregorianCalendar();
	        gc.setTime(date);

	        try {
	            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	        } catch (NullPointerException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        //JAXBElement<XMLGregorianCalendar> jaxbDate = new JAXBElement(new QName("Datum_podnosenja_zahteva"), XMLGregorianCalendar.class, xmlDate);
			//zalba.getSadrzaj().getContent().set(5, jaxbDate);
	        
			//XMLGregorianCalendar noviDatum = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(2020, 9, 17));
			//JAXBElement<XMLGregorianCalendar> nd = new JAXBElement<XMLGregorianCalendar>("Datum_podnosenja_zahteva", noviDatum, XMLGregorianCalendar);
			//alba.getSadrzaj().getContent().set(5, (Serializable) noviDatum);
	        
	        zalba.getAdresaZaPostu().setBroj(23);
			
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(zalba, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	

}
