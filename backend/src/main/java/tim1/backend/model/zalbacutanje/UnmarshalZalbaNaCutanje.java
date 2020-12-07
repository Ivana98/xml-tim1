package tim1.backend.model.zalbacutanje;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class UnmarshalZalbaNaCutanje {

	public static void test() {
		try {
			
			System.out.println("[INFO] Zalba na cutanje: JAXB unmarshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance("tim1.backend.model.zalbacutanje");
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(new File("./../documents/xml_documents/zalbacutanjecir.xml"));

			printZalba(zalba);
			
		} catch (JAXBException e) {
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
		for(Serializable element : sadrzaj.getContent()) {
			if(element.getClass().equals(String.class)) {
				System.out.print(element);
			}
			else {
				try {
					JAXBElement<String> el = (JAXBElement<String>) element;
					System.out.print(el.getValue());
				} catch (Exception e) {
					try {
						JAXBElement<Select> el = (JAXBElement<Select>) element;
						System.out.print(el.getValue().getSelectedOption().getValue());
					} catch (Exception e2) {
						try {
							JAXBElement<Date> el = (JAXBElement<Date>) element;
							System.out.print(el.getValue());
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
		
		System.out.println("У " + vremeIMesto.getMesto() + ", дана " + vremeIMesto.getDatum() + " године.");
	}
	
}
