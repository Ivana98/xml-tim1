package tim1.backend.model.zahtev;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class MarshalZahtev {
    
    public static void testXmlToObject(){
        try {
            File file = new File("documents/xml_documents/zahtev.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Zahtev.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Zahtev zahtev = (Zahtev) jaxbUnmarshaller.unmarshal(file);
            printZahtev(zahtev);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printZahtev(Zahtev zahtev){
        System.out.println(zahtev);
    }

}
