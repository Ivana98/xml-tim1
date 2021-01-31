package tim1.backend.model.resenje;

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

import tim1.backend.model.resenje.Poverenik.Ime;
import tim1.backend.model.resenje.Poverenik.Prezime;

import static tim1.backend.utils.PathConstants.*;

public class MarshalingResenje {

    public static void test() throws Exception {

        try {
            System.out.println("\n[INFO] Resenje JAXB Marshalling.\n");

            JAXBContext context = JAXBContext.newInstance(ResenjeObrazac.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            ResenjeObrazac resenjeObrazac = (ResenjeObrazac) unmarshaller.unmarshal(new File("./documents/xml_documents/resenje.xml"));

            resenjeObrazac.getDatum().setValue(getDatum());
            resenjeObrazac.setPoverenik(getPoverenik());

            JAXBElement<Double> jaxbCena = new JAXBElement(new QName("cena"), Double.class, 666.00);

            resenjeObrazac.getSadrzaj().getObrazlozenje().getContent().set(1, jaxbCena);  //  postavi novu cenu

            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(resenjeObrazac, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static Poverenik getPoverenik() {

        Poverenik p = new Poverenik();

        Ime ime = new Ime();
        ime.setValue("Dusan");
        p.setIme(ime);

        Prezime prezime = new Prezime();
        prezime.setValue("Dusanic");
        p.setPrezime(prezime);

        return p;
    }
    
    private static XMLGregorianCalendar getDatum() {

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

        // JAXBElement<XMLGregorianCalendar> jaxbDate = new JAXBElement(new QName("date"), XMLGregorianCalendar.class, xmlDate);

        return xmlDate;
    }
}
