package tim1.backend;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.exist.http.BadRequestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.obavestenje.MarshalingObavestenjecir;
import tim1.backend.model.obavestenje.UnmarshalingObavestenjecir;
import tim1.backend.model.resenje.MarshalingResenje;
import tim1.backend.model.resenje.ValidationResenje;
import tim1.backend.model.zahtev.MarshallingZahtev;
import tim1.backend.model.zahtev.UnmarshallingZahtev;
import tim1.backend.model.zahtev.Validation;
import tim1.backend.model.zahtev.Zahtev;
import tim1.backend.model.resenje.UnmarshallingResenje;
import tim1.backend.model.zalbacutanje.MarshalZalbaNaCutanje;
import tim1.backend.model.zalbacutanje.UnmarshalZalbaNaCutanje;
import tim1.backend.model.zalbaodluka.MarshallingZalbaNaOdluku;
import tim1.backend.model.zalbaodluka.UnmarshallingZalbaNaOdluku;
import tim1.backend.repository.ObavestenjeRepository;
import tim1.backend.utils.DBManager;
import tim1.backend.utils.FusekiManager;
import tim1.backend.utils.MetadataExtractor;

import static tim1.backend.utils.PathConstants.*;

@SpringBootApplication
public class XmlBackendApplication {

	// run tomcat on port: 8080
	// run spring boot as usual

	public static void main(String[] args) throws Exception {
		SpringApplication.run(XmlBackendApplication.class, args);

		// UnmarshalZalbaNaCutanje.test();
		// MarshalZalbaNaCutanje.test();

		// UnmarshallingResenje.test();
		// MarshalingResenje.test();
		// ValidationResenje.test();

		// UnmarshallingZalbaNaOdluku.test();
		// MarshallingZalbaNaOdluku.test();

		// UnmarshalingObavestenjecir.test();
		// MarshalingObavestenjecir.test();
		// tim1.backend.model.obavestenje.Validation.test();

		//UnmarshallingZahtev.testXmlToObject();
		// MarshallingZahtev.testObjectToXml();
		// createRDFs();
		//Validation.test();

		/*
		File file = new File("./../documents/xml_documents/zahtev.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Zahtev.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Zahtev zahtev = (Zahtev) jaxbUnmarshaller.unmarshal(file);
		*/

		//formatiranje printa
		// System.out.println("\nzahtev");
		// printZahtev(zahtev);

		// System.out.println("\noutput");
		// System.out.println(output);

		/*
		File file1 = new File("./../documents/xml_documents/zahtev1.xml");

		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(zahtev, System.out);

		jaxbMarshaller.marshal(zahtev, file1);
		zahtev.getMesto().setValue("Beograd");

		System.out.println("\nsacuvani xml dokument:");
		jaxbMarshaller.marshal(zahtev, System.out);
		*/


		// DBManager dbManager = new DBManager();
		// dbManager.findAllFromCollection("/db/poverenik/zalbanacutanje/");
	}

	public static void createRDFs() throws SAXException, IOException, TransformerException, BadRequestException {
		// InputStream in = new FileInputStream(new File(ZALBA_ODLUKA_XML));
		// OutputStream out = new FileOutputStream(new File(ZALBA_ODLUKA_RDF));
		MetadataExtractor extractor = new MetadataExtractor();
		// extractor.extractMetadata(in, out);

		// FusekiManager.writeFuseki(ZALBA_ODLUKA_RDF, ZALBA_ODLUKA_PATH_URI);
		// System.out.println("\nZalba na odluku");
		// FusekiManager.readFile(ZALBA_ODLUKA_PATH_URI);
		
		// in = new FileInputStream(new File(ZALBA_CUTANJE_XML));
		// out = new FileOutputStream(new File(ZALBA_CUTANJE_RDF));
		// extractor.extractMetadata(in, out);

		// FusekiManager.writeFuseki(ZALBA_CUTANJE_RDF, ZALBA_CUTANJE_PATH_URI);
		// System.out.println("\nZalba na cutanje");
		// FusekiManager.readFile(ZALBA_CUTANJE_PATH_URI);

		InputStream in = new FileInputStream(new File("./../documents/xml_documents/zahtev1.xml"));
		OutputStream out = new FileOutputStream(new File(ZAHTEV_RDF));
		extractor.extractMetadata(in, out);

		InputStream inrdf = new FileInputStream(new File(ZAHTEV_RDF));
		FusekiManager fuseki = new FusekiManager();
		fuseki.writeFuseki(inrdf, ZAHTEV_PATH_URI);
		System.out.println("\nZahtev");
		fuseki.readFileAsXML(ZAHTEV_PATH_URI);

		// in = new FileInputStream(new File(OBAVESTENJE_XML));
		// out = new FileOutputStream(new File(OBAVESTENJE_RDF));
		// extractor.extractMetadata(in, out);

		// FusekiManager.writeFuseki(OBAVESTENJE_RDF, OBAVESTENJE_PATH_URI);
		// System.out.println("\nObavestenje");
		// FusekiManager.readFile(OBAVESTENJE_PATH_URI);

		// in = new FileInputStream(new File(RESENJE_XML));
		// out = new FileOutputStream(new File(RESENJE_RDF));
		// extractor.extractMetadata(in, out);
		
		// FusekiManager.writeFuseki(RESENJE_RDF, RESENJE_PATH_URI);
		// System.out.println("\nResenje");
		// FusekiManager.readFile(RESENJE_PATH_URI);
		


	}

	public static void xmlDatabase() {
		try {
			// String documentName = "resenje.xml";
			// DBManager.saveFileToDB(documentName);
			// DBManager.readFileFromDB(documentName);

			// documentName = "zalbanaodlukucir.xml";
			// DBManager.saveFileToDB(documentName);
			// DBManager.readFileFromDB(documentName);

			// documentName = "obavestenjecir.xml";
			// ObavestenjeRepository repo = new ObavestenjeRepository();
			// System.out.println("\nSAVE");
			// repo.saveXML(documentName);
			// System.out.println("\nGET BY ID");
			// XMLResource res = repo.readXML(documentName);
			// System.out.println(res);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
