package tim1.backend.model.zalbacutanje;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;


import org.xml.sax.SAXException;


public class UnmarshalZalbaNaCutanje {

	public static void test() {
		try {
			
			System.out.println("[INFO] Zalba na cutanje: JAXB unmarshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance("tim1.backend.model.zalbacutanje");
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File("./../documents/xsd_documents/zalbacutanjecir.xsd"));
			
			unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new MyValidationEventHandler());
			
			ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(new File("./../documents/xml_documents/zalbacutanjecir.xml"));

			zalba.getVremeIMesto().setMesto("Новом Саду");
			
			printZalba(zalba);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	private static void printZalba(ZalbaNaCutanje zalba) {
		
		System.out.println(zalba.getNaslov() + "\n");
		System.out.println(zalba.getNamena());
		printAdresa(zalba.getAdresaZaPostu());
		printSadrzaj(zalba.getSadrzaj());
		printPodnosilacZalbe(zalba.getPodnosilacZalbe());
		printVremeIMesto(zalba.getVremeIMesto());
	}
	
	private static void printAdresa(ZalbaNaCutanje.AdresaZaPostu adresa) {
		System.out.println("Адреса за пошту: " + adresa.getMesto() + ", " + adresa.getUlica() + " бр. " + adresa.getBroj());
	}
	
	private static void printSadrzaj(ZalbaNaCutanje.Sadrzaj sadrzaj) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		JAXBElement<XMLGregorianCalendar> el3 = null;
		for(Serializable element : sadrzaj.getContent()) {
			if(element.getClass().equals(String.class)) {
				System.out.print(element);
			}
			else {
				try {
					JAXBElement<String> el1 = (JAXBElement<String>) element;
					System.out.print(el1.getValue());
				} catch (Exception e) {
					try {
						JAXBElement<Select> el2 = (JAXBElement<Select>) element;
						System.out.print(el2.getValue().getSelectedOption().getValue());
					} catch (Exception e2) {
						try {
							el3 = (JAXBElement<XMLGregorianCalendar>) element;
							XMLGregorianCalendar datum = el3.getValue();
							String datumString = datum.getDay() + "." + datum.getMonth() + "." + datum.getYear() + ".";
							System.out.print(datumString);
						} catch (Exception e3) {
							e.printStackTrace();
						}
					}
				}
				
			}

		}
		System.out.println();
	}
	
	private static void printPodnosilacZalbe(PodnosilacZalbe podnosilac) {
		System.out.println("Подносилац жалбе: ");
		System.out.println("Име и презиме: " + podnosilac.getIme() + " " + podnosilac.getPrezime());
		System.out.println("Адреса: " + podnosilac.getAdresa());
		System.out.println("Контакт подаци: " + podnosilac.getKontaktPodaci());
		System.out.println();
	}
	
	private static void printVremeIMesto(ZalbaNaCutanje.VremeIMesto vremeIMesto) {
		XMLGregorianCalendar datum = vremeIMesto.getDatum();
		String datumString = datum.getDay() + "." + datum.getMonth() + "." + datum.getYear() + ".";
		System.out.println("У " + vremeIMesto.getMesto() + ", дана " + datumString + " године.");
	}
	
}
