package tim1.backend.model.obavestenje;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import tim1.backend.model.obavestenje.Obavestenje.Sadrzaj;
import tim1.backend.model.obavestenje.Select.Primer;

public class MarshalingObavestenjecir {

    public static void test() throws Exception {

        try {
            System.out.println("\n[INFO] Obavestenje JAXB Marshalling.\n");

            JAXBContext context = JAXBContext.newInstance(Obavestenje.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Obavestenje obavestenje = (Obavestenje) unmarshaller
                    .unmarshal(new File("documents/xml_documents/obavestenjecir.xml"));

            obavestenje.setOsnovniPodaci(getOsnovniPodatak());
            obavestenje.getSadrzaj().getParagraf().getContent().set(0, "Prva recenica promenjena..");
            // obavestenje.setSadrzaj(getSadrzaj());

            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(obavestenje, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static Obavestenje.OsnovniPodaci getOsnovniPodatak() {

        Obavestenje.OsnovniPodaci op = new Obavestenje.OsnovniPodaci();

        op.setOrgan(getOrgan());
        op.setBrojPredmeta(2);

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

        op.setDatum(xmlDate);
        op.setPodnosiocZahteva(getPodnosiocZahteva());

        return op;
    }

    private static PodnosiocZahteva getPodnosiocZahteva() {
        PodnosiocZahteva pz = new PodnosiocZahteva();

        pz.setIme("Nikola");
        pz.setPrezime("Rokvic");
        pz.setNaziv("Neki naziv");
        pz.setAdresa("Adresa 34");

        return pz;
    }

    private static Organ getOrgan() {
        Organ organ = new Organ();

        organ.setNaziv("Neki naziv");
        organ.setSediste("Beograd");

        return organ;
    }

    private static Obavestenje.Sadrzaj getSadrzaj() {

        Sadrzaj s = new Sadrzaj();

        s.setNaslov("N A S L O V 2");
        s.setPodnaslov("Neki dugaaacakkkkk podnaslov...\n....red ispod.......");
        s.setParagraf(getParagraf());
        s.setDostavljeno(getDostavljeno());

        return s;
    }

    private static Select getDostavljeno() {

        Select s = new Select();
        
        Primer p1 = new Primer();
        p1.setID(1);
        p1.setValue("Vrednost 1");

        Primer p2 = new Primer();
        p2.setID(1);
        p2.setValue("Vrednost 1");

        s.getPrimer().add(p1);
        s.getPrimer().add(p2);

        s.setSelected(1);

        return s;
    }

    private static Paragraf getParagraf() {

        Paragraf p = new Paragraf();
        p.getContent().add("tekst1");

        // region Year
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

        // endregion

        JAXBElement<XMLGregorianCalendar> jaxbDate = new JAXBElement(new QName("year"), XMLGregorianCalendar.class, xmlDate);

        p.getContent().add(jaxbDate);

        p.getContent().add("teks2");
        p.getContent().add("Opis informacije");
        p.getContent().add("tekst3");
        p.getContent().add(jaxbDate);  // datum uvida
        p.getContent().add("tekst3");
        p.getContent().add(jaxbDate);  // vreme uvida
        p.getContent().add("tekst4");
        p.getContent().add(jaxbDate);  // pocetak cas
        p.getContent().add("tekst5");
        p.getContent().add(jaxbDate);  // kraj cas
        p.getContent().add("tekst6");
        p.getContent().add("Nis");
        p.getContent().add("tekst7");
        p.getContent().add("Ulica");
        p.getContent().add("tekst8");
        // JAXBElement<Integer> jaxbInt = new JAXBElement(new QName("broj"), Integer.class, 3);

        p.getContent().add("3");
        p.getContent().add("tekst9");
        p.getContent().add("22a");
        p.getContent().add("tekst10 velikiiiiiiii\niiiiiiiiiiiii");
        p.getContent().add(500);
        p.getContent().add("tekst11");

        return p;
    }

}
