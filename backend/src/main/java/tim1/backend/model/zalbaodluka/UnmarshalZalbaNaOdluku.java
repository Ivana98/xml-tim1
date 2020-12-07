package tim1.backend.model.zalbaodluka;

import java.io.File;
import java.io.Serializable;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import tim1.backend.model.zalbacutanje.MyValidationEventHandler;
import tim1.backend.model.zalbaodluka.Napomene.Napomena;

public class UnmarshalZalbaNaOdluku {
	
	public static void test() {
		try {
			
			System.out.println("[INFO] Zalba na odluku: JAXB unmarshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance("tim1.backend.model.zalbaodluka");
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File("./../documents/xsd_documents/zalbanaodlukucir.xsd"));
			
			unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new MyValidationEventHandler());
			
			ZalbaNaOdluku zalba = (ZalbaNaOdluku) unmarshaller.unmarshal(new File("./../documents/xml_documents/zalbanaodlukucir.xml"));

			
			
			printZalbaNaOdluku(zalba);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	
	private static void printZalbaNaOdluku(ZalbaNaOdluku zalba) {
		System.out.println(zalba.getNaslov());
		System.out.println(zalba.getPodaciOPovereniku().getNamena());
		Adresa adresa = zalba.getPodaciOPovereniku().getAdresa();
		System.out.println(adresa.getGrad() + ", " + adresa.getUlica() + " " + adresa.getBroj());
		printZalba(zalba.getZalba());
		printNapomene(zalba.getNapomene());
	}
	
	private static void printZalba(Zalba zalba) {
		JAXBElement<String> podnaslov = (JAXBElement<String>) zalba.getContent().get(1);
		System.out.println(podnaslov.getValue());
		
		Zalilac zalilac = (Zalilac) zalba.getContent().get(3);
		System.out.println(zalilac.getIme() + " " + zalilac.getPrezime() + " " + zalilac.getNaziv());
		System.out.println(zalilac.getAdresa().getGrad() + zalilac.getAdresa().getUlica() + " " + zalilac.getAdresa().getBroj());
		System.out.print(zalilac.getSediste());
		
		System.out.println(zalba.getContent().get(4));
		
		JAXBElement<String> nazivOrgana = (JAXBElement<String>) zalba.getContent().get(5);
		System.out.print(nazivOrgana.getValue());
		
		System.out.print(zalba.getContent().get(6));	
		JAXBElement<Integer> broj = (JAXBElement<Integer>) zalba.getContent().get(7);
		System.out.print(broj.getValue());
		System.out.print(zalba.getContent().get(8));
		JAXBElement<XMLGregorianCalendar> datum = (JAXBElement<XMLGregorianCalendar>) zalba.getContent().get(9);
		System.out.print(datum.getValue().getYear()+".");
		System.out.println(zalba.getContent().get(10));
		
		Sadrzaj sadrzaj = (Sadrzaj) zalba.getContent().get(11);
		printSadrzaj(sadrzaj);
		
		Podnosilac podnosilac = (Podnosilac) zalba.getContent().get(13);
		printPodnosilac(podnosilac);
		
		VremeIMesto vremeIMesto = (VremeIMesto) zalba.getContent().get(15);
		printVremeIMesto(vremeIMesto);
		
	}
	
	private static void printSadrzaj(Sadrzaj sadrzaj) {
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
						JAXBElement<XMLGregorianCalendar> el3 = (JAXBElement<XMLGregorianCalendar>) element;
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
	
	private static void printPodnosilac(Podnosilac podnosilac) {
		System.out.println(podnosilac.getIme() + " " + podnosilac.getPrezime());
		System.out.println(podnosilac.getAdresa().getGrad() + ", " + podnosilac.getAdresa().getUlica() + " " + podnosilac.getAdresa().getBroj());
		System.out.println(podnosilac.getKontaktPodaci());
	}
	
	private static void printVremeIMesto(VremeIMesto vremeIMesto) {
		XMLGregorianCalendar datum = vremeIMesto.getDatum();
		String datumString = datum.getDay() + "." + datum.getMonth() + "." + datum.getYear() + ".";
		System.out.println("У " + vremeIMesto.getGrad() + ", дана " + datumString + " године.");
	}
	
	private static void printNapomene(Napomene nampoene) {
		for(Serializable element : nampoene.getContent()) {
			if(element.getClass().equals(String.class)) {
				System.out.print(element);
			}
			else {
				try {
					JAXBElement<Napomena> el1 = (JAXBElement<Napomena>) element;
					System.out.print(el1.getValue().getValue());
				} catch (Exception e) {
				
				}
			}
		}
		
	}
}

