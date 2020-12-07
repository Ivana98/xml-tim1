package tim1.backend.model.zahtev;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import tim1.backend.model.zahtev.OpisZahteva.TipoviZahteva;
import tim1.backend.model.zahtev.TipZahteva.NaciniSlanja;

public class MarshalZahtev {
    
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
        //info organa
        
        addToOutput("naziv organa", zahtev.getInfoOrgana().getNaziv());
        addToOutput("sediste organa", zahtev.getInfoOrgana().getSediste());
        addToOutput("naslov", zahtev.getNaslov());
        addToOutput("svrha zahteva", zahtev.getSvrhaZahteva());

        addToOutput("tekst zahteva", zahtev.getOpisZahteva().getTekstZahteva());
        printTipoviZahteva(zahtev);

        
    }

    private static void printTipoviZahteva(Zahtev zahtev){
        TipoviZahteva tipoviZahteva = zahtev.getOpisZahteva().getTipoviZahteva();
        for (TipZahteva tipZahteva : tipoviZahteva.getTipZahteva()) {
            addToOutput("\t tip zahteva:", tipZahteva.getTekst());
            addToOutput("\t rb", String.valueOf(tipZahteva.getRb()));
            addToOutput("\t selektovan", String.valueOf(tipZahteva.isSelektovan()));

            //nacini slanja
            NaciniSlanja nacini =tipZahteva.getNaciniSlanja();
            if(null != nacini){
                for (NacinSlanja nacinSlanja : nacini.getNacinSlanja()) {
                    if(null == nacinSlanja.getDetaljanOpis())  {
                        addToOutput("\t\t nacin slanja", nacinSlanja.getTekst());
                    }
                    else{
                        addToOutput("\t\t nacin slanja", nacinSlanja.getTekst() + nacinSlanja.getDetaljanOpis());
                    }
                    addToOutput("\t\t rb", String.valueOf(nacinSlanja.getRb()));
                    addToOutput("\t\t selektovan", String.valueOf(nacinSlanja.isSelektovan()));
                    
                }
            }
        }
    }



    private static void addToOutput(String tag, String content){
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        if(tag.contains("\t"))
            output +=PURPLE + tag + ": " + BLUE + content + '\n';
        else
            output +=YELLOW + tag + ": " + BLUE + content + '\n';
    }

}
