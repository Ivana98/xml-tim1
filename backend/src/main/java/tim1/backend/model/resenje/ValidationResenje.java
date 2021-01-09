package tim1.backend.model.resenje;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import static tim1.backend.utils.PathConstants.*;

public class ValidationResenje {
    
    public static void test() {
		try {
			System.out.println("JAXB XML Schema validation .\n");
			
			JAXBContext context = JAXBContext.newInstance(ResenjeObrazac.class);

			// Unmarshaller je objekat zadužen za konverziju iz XML-a u objektni model
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			// XML schema validacija
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File(RESENJE_XSD));
            
			// Podešavanje unmarshaller-a za XML schema validaciju
			unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new MyValidationEventHandlerResenje());
			
            // Test: proširiti XML fajl nepostojećim elementom (npr. <test></test>)
            ResenjeObrazac resenjeObrazac = (ResenjeObrazac) unmarshaller.unmarshal(new File(RESENJE_XML));

            // Ispis sadržaja objektnog modela, nakon uspešne validacije
            // printResenje(resenjeObrazac);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (org.xml.sax.SAXException e) {
			e.printStackTrace();
		}
    }
}
