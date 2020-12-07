package tim1.backend.model.zalbacutanje;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MarshalZalbaNaCutanje {
	
	public static void test() {
		try {
			System.out.println("[INFO] Zalba na cutanje: JAXB marshalling.\n");
			
			JAXBContext context = JAXBContext.newInstance("tim1.backend.model.zalbacutanje");
			
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(new File("./../documents/xml_documents/zalbacutanjecir.xml"));
			
			
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(zalba, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	

}
