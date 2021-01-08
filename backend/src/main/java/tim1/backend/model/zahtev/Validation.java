package tim1.backend.model.zahtev;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import static tim1.backend.utils.PathConstants.*;

public class Validation {
    public static void test() {
        try {
            

            File file = new File(ZAHTEV_XML);
            JAXBContext jaxbContext = JAXBContext.newInstance(Zahtev.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            

            // XML schema validacija
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(ZAHTEV_XSD));

            // // Podešavanje unmarshaller-a za XML schema validaciju
            jaxbUnmarshaller.setSchema(schema);
            jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
            
            //proveri dokument po xml schemi
            Zahtev zahtev = (Zahtev) jaxbUnmarshaller.unmarshal(file);
            System.out.println("JAXB XML Schema validation is successful.\n");

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (org.xml.sax.SAXException e) {
			e.printStackTrace();
		}
    }
}
