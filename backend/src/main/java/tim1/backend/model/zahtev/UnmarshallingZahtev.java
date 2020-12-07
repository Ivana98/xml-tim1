package tim1.backend.model.zahtev;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import tim1.backend.model.zahtev.OpisZahteva.TipoviZahteva;
import tim1.backend.model.zahtev.TipZahteva.NaciniSlanja;

public class UnmarshallingZahtev {
    
    private static String output = "";
    
    public static void testXmlToObject(){
        try {
            File file = new File("documents/xml_documents/zahtev.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Zahtev.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Zahtev zahtev = (Zahtev) jaxbUnmarshaller.unmarshal(file);

            //formatiranje printa
            printZahtev(zahtev);
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printZahtev(Zahtev zahtev){

        addToOutput("naziv organa", zahtev.getInfoOrgana().getNaziv(), "\n");
        addToOutput("sediste organa", zahtev.getInfoOrgana().getSediste(), "\n");
        addToOutput("naslov", zahtev.getNaslov(), "\n");
        addToOutput("svrha zahteva", zahtev.getSvrhaZahteva(), "\n");

        addToOutput("tekst zahteva", zahtev.getOpisZahteva().getTekstZahteva(), "\n");
        printTipoviZahteva(zahtev);
        printDodatneInformacije(zahtev);

        addToOutput("mesto", zahtev.getMesto(), "\n");
        addToOutput("datum", String.valueOf(zahtev.getDatum()), "\n");
        
        addToOutput("trazilac", zahtev.getTrazilac().getImeIPrezime(), "\n");
        addToOutput("adresa", zahtev.getTrazilac().getAdresa(), "\n");
        addToOutput("kontakt", zahtev.getTrazilac().getKontakt(), "\n");
        addToOutput("potpis", zahtev.getTrazilac().getPotpis(), "\n");
        
        addToOutput("footer", zahtev.getFooter(), "\n");
    }

    private static void printTipoviZahteva(Zahtev zahtev){
        TipoviZahteva tipoviZahteva = zahtev.getOpisZahteva().getTipoviZahteva();
        for (TipZahteva tipZahteva : tipoviZahteva.getTipZahteva()) {
            addToOutput("\t tip", tipZahteva.getTekst(), "");
            addToOutput(" rb", String.valueOf(tipZahteva.getRb()), "");
            addToOutput(" selektovan", String.valueOf(tipZahteva.isSelektovan()), "\n");

            //nacini slanja
            NaciniSlanja nacini =tipZahteva.getNaciniSlanja();
            if(null != nacini){
                for (NacinSlanja nacinSlanja : nacini.getNacinSlanja()) {
                    if(null == nacinSlanja.getDetaljanOpis())  {
                        addToOutput("\t\t slanje", nacinSlanja.getTekst(), "");
                    }
                    else{
                        addToOutput("\t\t slanje", 
                        nacinSlanja.getTekst() + nacinSlanja.getDetaljanOpis(), "");
                    }
                    addToOutput(" rb", String.valueOf(nacinSlanja.getRb()), "");
                    addToOutput(" selektovan", String.valueOf(nacinSlanja.isSelektovan()), "\n");   
                }
            }
        }
    }

    private static void printDodatneInformacije(Zahtev zahtev){
        String x;
        x = zahtev.getOpisZahteva().getDodatneInformacije().getContent().get(0).toString();
        addToOutput("dodatne informacije", x , "\n");

        //ono sto je korisnik uneo, ako je uneo
        JAXBElement<String> text = (JAXBElement<String>)zahtev.getOpisZahteva().getDodatneInformacije().getContent().get(1);
        addToOutput("korisnik uneo",text.getValue(), "\n");

        x = zahtev.getOpisZahteva().getDodatneInformacije().getContent().get(2).toString();
        addToOutput("tekst", x , "\n");
    }

    private static void addToOutput(String tag, String content, String end){
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        if(tag.contains("\t"))
            output +=PURPLE + tag + ": " + BLUE + content + end;
        else
            output +=YELLOW + tag + ": " + BLUE + content + end;
    }

}
