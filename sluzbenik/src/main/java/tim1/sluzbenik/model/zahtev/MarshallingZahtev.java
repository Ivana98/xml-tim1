package tim1.sluzbenik.model.zahtev;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import tim1.sluzbenik.model.zahtev.InfoOrgana.Naziv;
import tim1.sluzbenik.model.zahtev.InfoOrgana.Sediste;
import tim1.sluzbenik.model.zahtev.OpisZahteva.DodatneInformacije;
import tim1.sluzbenik.model.zahtev.OpisZahteva.TipoviZahteva;
import tim1.sluzbenik.model.zahtev.TipZahteva.NaciniSlanja;
import tim1.sluzbenik.model.zahtev.Trazilac.ImeIPrezime;
import tim1.sluzbenik.model.zahtev.Zahtev.Datum;
import tim1.sluzbenik.model.zahtev.Zahtev.Mesto;
import tim1.sluzbenik.model.zahtev.Trazilac.Adresa;

import static tim1.sluzbenik.utils.PathConstants.*;

public class MarshallingZahtev {

    public static void testObjectToXml() {
        try {

            Zahtev zahtev = generateZahtev();

            File file = new File("./../documents/xml_documents/zahtev1.xml");
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
        zahtev.setProperty("pred:status");
        zahtev.setDatatype("xs:string");
        zahtev.setContent("na cekanju");

        zahtev.setNaslov("Zahtev");
        zahtev.setSvrhaZahteva("za pristup informaciji od javnog znacaja");
        zahtev.setInfoOrgana(generateInfoOrgana(factory));
        zahtev.setOpisZahteva(generateOpisZahteva(factory));
        zahtev.setAbout("http://www.ftn.uns.ac.rs/rdf/zahtev/Zahtev");
        Mesto mesto = new Mesto();
        mesto.setValue("Novi Sad");
        mesto.setProperty("pred:mesto");
        mesto.setDatatype("xs:string");
        zahtev.setMesto(mesto);

        Datum datum = new Datum();
        datum.setProperty("pred:datum");
        datum.setDatatype("xs:date");
        datum.setValue(generateDate());
        zahtev.setDatum(datum);
        zahtev.setTrazilac(generateTrazilac(factory));
        zahtev.setFooter("ovo je tekst footer-a");
        return zahtev;
    }

    private static InfoOrgana generateInfoOrgana(ObjectFactory factory){
        InfoOrgana infoOrgana = factory.createInfoOrgana();
        infoOrgana.setAbout("http://www.ftn.uns.ac.rs/rdf/zahtev/Organ");

        Naziv naziv = new Naziv();
        naziv.setDatatype("xs:string");
        naziv.setProperty("pred:naziv");
        naziv.setValue("organ1");
        infoOrgana.setNaziv(naziv);

        Sediste sediste = new Sediste();
        sediste.setDatatype("xs:string");
        sediste.setProperty("pred:sediste");
        sediste.setValue("Novi Sad");
        infoOrgana.setSediste(sediste);
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

        trazilac.setAbout("http://www.ftn.uns.ac.rs/rdf/zahtev/Trazilac");

        ImeIPrezime ip = new ImeIPrezime();
        ip.setValue("Nikola Jokic");
        ip.setDatatype("xs:string");
        ip.setProperty("pred:ime-prezime");
        trazilac.setImeIPrezime(ip);

        Adresa adresa = new Adresa();
        adresa.setValue("Sombor, somborska 5");
        adresa.setProperty("pred:adresa");
        adresa.setValue("xs:string");
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