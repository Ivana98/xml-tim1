package tim1.backend.model.resenje;

import java.io.File;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import tim1.backend.model.resenje.Obrazlozenje.SadrzajObrazlozenja;

public class UnmarshallingResenje {
	
	public static void test() throws Exception {
		
		try {
			System.out.println("[INFO] Resenje: JAXB unmarshalling.\n");
			
	        JAXBContext context = JAXBContext.newInstance(ResenjeObrazac.class);
	
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	
	        ResenjeObrazac resenjeObrazac = (ResenjeObrazac) unmarshaller.unmarshal(new File("documents/xml_documents/resenje.xml"));
	
	        printResenjeObrazac(resenjeObrazac);

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	}

	
    public static void printResenjeObrazac(ResenjeObrazac resenje) {
    	
    	System.out.println(resenje.getNaslov());
    	System.out.println("Бр. " + resenje.getBroj());
    	
		XMLGregorianCalendar datum = resenje.getDatum();
		String datumString = datum.getDay() + "." + datum.getMonth() + "." + datum.getYear() + ".";
    	System.out.println("Датум: " + datumString + " године");
    	System.out.println(resenje.getUvod());
    	printSadrzaj(resenje.getSadrzaj());
    	printPoverenik(resenje.getPoverenik());
    	
    }
    
    public static void printSadrzaj(ResenjeObrazac.Sadrzaj sadrzaj) {
    	printResenje(sadrzaj.getResenje());
    	printObrazlozenje(sadrzaj.getObrazlozenje());
    }
    
    public static void printResenje(Resenje resenje) {

    	for(Serializable element : resenje.getContent()) {
			if(element.getClass().equals(String.class)) {
				System.out.print(element);
			}
			else {
				JAXBElement<String> pasus = (JAXBElement<String>) element;
	    		System.out.print(pasus.getValue());
			}
    	}
    }

	public static void printObrazlozenje(Obrazlozenje obrazlozenje) {
		//System.out.println(obrazlozenje.getContent());
		
		for(Serializable element : obrazlozenje.getContent()) {
			if(element.getClass().equals(String.class)) {
				System.out.print(element);
			}
			else {		
	    		JAXBElement<SadrzajObrazlozenja> sadrzajObrazlozenja = (JAXBElement<SadrzajObrazlozenja>) element;
	    		//System.out.print(sadrzajObrazlozenja.getValue().getContent());
	    		for(Serializable sadrzaj : sadrzajObrazlozenja.getValue().getContent()) {
	    			if(sadrzaj.getClass().equals(String.class)) {
	    				System.out.print(sadrzaj);
	    			}
	    			else {
	    				JAXBElement<Double> cena = (JAXBElement<Double>) sadrzaj;
	    				System.out.print(cena.getValue());
	    			}
	    		}
			}
    	}
	}
	
	public static void printPoverenik(Poverenik poverenik) {
		System.out.println("\n" + "ПОВЕРЕНИК");
		System.out.println(poverenik.getIme() + " " + poverenik.prezime);
	}
}


