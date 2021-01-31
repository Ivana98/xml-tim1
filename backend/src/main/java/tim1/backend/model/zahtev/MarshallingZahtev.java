package tim1.backend.model.zahtev;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import tim1.backend.model.zahtev.OpisZahteva.DodatneInformacije;
import tim1.backend.model.zahtev.OpisZahteva.TipoviZahteva;
import tim1.backend.model.zahtev.TipZahteva.NaciniSlanja;
import tim1.backend.model.zahtev.Trazilac.ImeIPrezime;
import tim1.backend.model.zahtev.Zahtev.Datum;
import tim1.backend.model.zahtev.Trazilac.Adresa;

import static tim1.backend.utils.PathConstants.*;

public class MarshallingZahtev {

    public static void testObjectToXml() {
        try {

            Zahtev zahtev = generateZahtev();

            File file = new File("./documents/xml_documents/zahtev.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Zahtev.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(zahtev, file);
            System.out.println("sacuvani xml dokument:");
            jaxbMarshaller.marshal(zahtev, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Zahtev generateZahtev() {

        ObjectFactory factory = new ObjectFactory();
        Zahtev zahtev = factory.createZahtev();
        zahtev.setNaslov("Zakon");
        zahtev.setSvrhaZahteva("Pristup informaciji od javnog znacaja");
        zahtev.setInfoOrgana(generateInfoOrgana(factory));
        zahtev.setOpisZahteva(generateOpisZahteva(factory));
        zahtev.setMesto("Novi Sad");

        Datum datum = new Datum();
        datum.setValue(generateDate());
        zahtev.setDatum(datum);
        zahtev.setTrazilac(generateTrazilac(factory));
        zahtev.setFooter("ovo je tekst footer-a");
        return zahtev;
    }

    private static InfoOrgana generateInfoOrgana(ObjectFactory factory){
        InfoOrgana infoOrgana = factory.createInfoOrgana();
        infoOrgana.setNaziv("organ1");
        infoOrgana.setSediste("Novi Sad");
        return infoOrgana;
    }

    private static OpisZahteva generateOpisZahteva(ObjectFactory factory){
        OpisZahteva opisZahteva = factory.createOpisZahteva();
        opisZahteva.setTekstZahteva("na osnovu clana X zahtevam sledece:");
        opisZahteva.setTipoviZahteva(generateTipoviZahteva(factory));
        opisZahteva.setDodatneInformacije(generateDodatneInformacije(factory));
        return opisZahteva;
    }

    private static TipoviZahteva generateTipoviZahteva(ObjectFactory factory) {

        TipZahteva tipZahteva = factory.createTipZahteva();
        tipZahteva.setTekst("zelim uvid u dokument ...");
        tipZahteva.setSelektovan(true);
        tipZahteva.setRb(1);

        TipZahteva tipZahteva2 = factory.createTipZahteva();
        tipZahteva2.setTekst("zelim da mi posaljete dokument ...");
        tipZahteva2.setSelektovan(false);
        tipZahteva2.setRb(2);
        NaciniSlanja nacini = factory.createTipZahtevaNaciniSlanja();
        NacinSlanja n1 = factory.createNacinSlanja();
        n1.setTekst("elektronski");
        n1.setRb(1);
        n1.setSelektovan(false);
        nacini.getNacinSlanja().add(n1);
        tipZahteva2.setNaciniSlanja(nacini);

        TipoviZahteva tipoviZahteva = factory.createOpisZahtevaTipoviZahteva();
        tipoviZahteva.getTipZahteva().add(tipZahteva);
        tipoviZahteva.getTipZahteva().add(tipZahteva2);

        return tipoviZahteva;
    }

    private static DodatneInformacije generateDodatneInformacije(ObjectFactory factory){
        DodatneInformacije dInformacije = factory.createOpisZahtevaDodatneInformacije();
        dInformacije.getContent().add("Ovaj zahtev se odnosi na sledece info: ");
        // dInformacije.getContent().add(" Trazim informaciju tu i tu pod rednim brojem tim.");
        JAXBElement<String> s = factory.createOpisZahtevaDodatneInformacijeOpisDodatneInformacije(
            "Trazim informaciju tu i tu pod rednim brojem tim.");
        dInformacije.getContent().add(s);

        return dInformacije;
    }

    private static Trazilac generateTrazilac(ObjectFactory factory){
        Trazilac trazilac =  factory.createTrazilac();

        ImeIPrezime ip = new ImeIPrezime();
        ip.setValue("Nikola Jokic");
        trazilac.setImeIPrezime(ip);

        Adresa adresa = new Adresa();
        adresa.setValue("Sombor, somborska 5");
        trazilac.setAdresa(adresa);
        trazilac.setKontakt("063 645658");

        return trazilac;
    }

    private static XMLGregorianCalendar generateDate(){
        Date date = new Date();
        XMLGregorianCalendar xmlDate = null;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlDate;
    }
}