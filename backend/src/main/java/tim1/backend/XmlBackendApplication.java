package tim1.backend;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.ObavestenjeRepository;
import tim1.backend.utils.DBManager;
import tim1.backend.utils.FueskiAuthenticationUtilities;
import tim1.backend.utils.SparqlUtil;
import tim1.backend.utils.FueskiAuthenticationUtilities.ConnectionProperties;
import tim1.backend.utils.MetadataExtractor;

@SpringBootApplication
public class XmlBackendApplication {

	// run tomcat on port: 8080
	// run spring boot as usual

	public static void main(String[] args) {
		SpringApplication.run(XmlBackendApplication.class, args);
		try {
			writeFuseki();
			xmlDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeFuseki() throws IOException {
		ConnectionProperties fusekiConn = FueskiAuthenticationUtilities.loadProperties();
		String rdfFilePath = "./../documents/rdf/example.rdf";
		String NAMED_GRAPH = "/example/person/metadata";

		// Creates a default model
		Model model = ModelFactory.createDefaultModel();
		model.read(rdfFilePath);

		// out stream nam treba da bismo videli ispis na konzoli
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		model.write(out, SparqlUtil.NTRIPLES);
		System.out.println("[INFO] Rendering model as RDF/XML...");
		model.write(System.out, SparqlUtil.RDF_XML);

		/*
		 * Create UpdateProcessor, an instance of execution of an UpdateRequest.
		 * UpdateProcessor sends update request to a remote SPARQL update service.
		*/
		UpdateRequest request = UpdateFactory.create() ;

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, fusekiConn.updateEndpoint);
		processor.execute();


		// Creating the first named graph and updating it with RDF data
		System.out.println("[INFO] Writing the triples to a named graph \"" + NAMED_GRAPH + "\".");
		String sparqlUpdate = SparqlUtil.insertData(fusekiConn.dataEndpoint + NAMED_GRAPH, new String(out.toByteArray()));
		System.out.println(sparqlUpdate);

		// UpdateRequest represents a unit of execution
		UpdateRequest update = UpdateFactory.create(sparqlUpdate);
		processor = UpdateExecutionFactory.createRemote(update, fusekiConn.updateEndpoint);
		processor.execute();


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
			// repo.save(documentName);
			// System.out.println("\nGET BY ID");
			// XMLResource res = repo.getById(documentName);
			// System.out.println(res);

			System.out.println("GEN");
			InputStream in = new FileInputStream(new File("./../documents/xml_documents/contacts.xml")); 
			OutputStream out = new FileOutputStream(new File("./../documents/gen/contacts.rdf"));
			MetadataExtractor extractor = new MetadataExtractor();
			extractor.extractMetadata(in, out);
			System.out.println("KRAJ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
