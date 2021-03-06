package tim1.sluzbenik.model.obavestenje;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import static tim1.sluzbenik.utils.PathConstants.*;

public class UnmarshalingObavestenjecir {

    public static void test() {

        try {
            System.out.println("\n[INFO] Obavestenje JAXB unmarshalling.\n");

            JAXBContext context = JAXBContext.newInstance(Obavestenje.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Obavestenje obavestenje = (Obavestenje) unmarshaller
                    .unmarshal(new File("./documents/xml_documents/obavestenjecir.xml"));

            printObavestenjecir(obavestenje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printObavestenjecir(Obavestenje obavestenje) {

        printOsnovniPodaci(obavestenje.getOsnovniPodaci());
        System.out.println();

        printSadrzaj(obavestenje.getSadrzaj());

        System.out.println();
        printDostavljeno(obavestenje.getSadrzaj().getDostavljeno());

    }

    private static void printDostavljeno(Select select) {

        System.out.println("- Dostavljeno:");
        System.out.print("\t" + select.getSelectedOption().getValue());

    }

    private static void printOsnovniPodaci(Obavestenje.OsnovniPodaci osnovniPodaci) {

        System.out.println("- Osnovni podaci:");

        System.out.println("\t- Naziv organa: " + osnovniPodaci.getOrgan().getNaziv());
        System.out.println("\t- Sediste organa: " + osnovniPodaci.getOrgan().getSediste());
        System.out.println("\t- Broj predmeta: " + osnovniPodaci.getBrojPredmeta());
        System.out.println("\t- Datum: " + osnovniPodaci.getDatum());
        System.out.println("\t- Podnosioc zahteva: ");
        System.out.println("\t\t- Ime: " + osnovniPodaci.getPodnosiocZahteva().getIme());
        System.out.println("\t\t- Prezime: " + osnovniPodaci.getPodnosiocZahteva().getPrezime());
        System.out.println("\t\t- Naziv: " + osnovniPodaci.getPodnosiocZahteva().getNaziv());
        System.out.println("\t\t- Adresa: " + osnovniPodaci.getPodnosiocZahteva().getAdresa());
    }

    private static void printSadrzaj(Obavestenje.Sadrzaj sadrzaj) {

        System.out.println("- Sadrzaj:");

        System.out.println("\t- Naslov: " + sadrzaj.getNaslov());
        System.out.println("\t- Podnaslov: " + sadrzaj.getPodnaslov());
        System.out.println("\t- Paragraf: ");
        System.out.print(sadrzaj.getParagraf().getContent().get(0));

        JAXBElement<Date> godina = (JAXBElement<Date>) sadrzaj.getParagraf().getContent().get(1);
        System.out.print("(-Godina-)" + godina.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(2));

        JAXBElement<String> opisInformacije = (JAXBElement<String>) sadrzaj.getParagraf().getContent().get(3);
        System.out.print("(-Opis Informacije-)" + opisInformacije.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(4));

        JAXBElement<Date> datumUvida = (JAXBElement<Date>) sadrzaj.getParagraf().getContent().get(5);
        System.out.print("(-Datum uvida-)" + datumUvida.getValue());

        System.out.print("" + sadrzaj.getParagraf().getContent().get(6));

        JAXBElement<Date> vremeUvida = (JAXBElement<Date>) sadrzaj.getParagraf().getContent().get(7);
        System.out.print("(-Vreme uvida-)" + vremeUvida.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(8));

        JAXBElement<Date> pocetakCas = (JAXBElement<Date>) sadrzaj.getParagraf().getContent().get(9);
        System.out.print("(-Pocetak cas-)" + pocetakCas.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(10));

        JAXBElement<Date> krajCas = (JAXBElement<Date>) sadrzaj.getParagraf().getContent().get(11);
        System.out.print("(-Kraj cas-)" + krajCas.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(12));

        JAXBElement<String> gradOrgana = (JAXBElement<String>) sadrzaj.getParagraf().getContent().get(13);
        System.out.print("(-Grad organa-)" + gradOrgana.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(14));

        JAXBElement<String> ulicaOrgana = (JAXBElement<String>) sadrzaj.getParagraf().getContent().get(15);
        System.out.print("(-Ulica organa-)" + ulicaOrgana.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(16));

        JAXBElement<String> brojOrgana = (JAXBElement<String>) sadrzaj.getParagraf().getContent().get(17);
        System.out.print("(-Broj organa-)" + brojOrgana.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(18));

        JAXBElement<String> brojKancelarije = (JAXBElement<String>) sadrzaj.getParagraf().getContent().get(19);
        System.out.print("(-Broj kancelarije-)" + brojKancelarije.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(20));

        JAXBElement<Double> iznosTroskova = (JAXBElement<Double>) sadrzaj.getParagraf().getContent().get(21);
        System.out.print("(-iznos troskova-)" + iznosTroskova.getValue());

        System.out.print(sadrzaj.getParagraf().getContent().get(22));

    }

}
