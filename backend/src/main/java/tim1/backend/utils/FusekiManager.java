package tim1.backend.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.exist.http.BadRequestException;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.stereotype.Component;

import tim1.backend.utils.FueskiAuthenticationUtilities.ConnectionProperties;
import static tim1.backend.utils.PathConstants.*;

@Component
public class FusekiManager {

	public static void writeFuseki(InputStream i, String NAMED_GRAPH) throws IOException {
		ConnectionProperties fusekiConn = FueskiAuthenticationUtilities.loadProperties();
		// String rdfFilePath = EXAMPLE_RDF;
		// String NAMED_GRAPH = EXAMPLE_PATH_URI;

		// String rdfFilePath = ZAHTEV_RDF;
		// String NAMED_GRAPH = ZAHTEV_PATH_URI;

		// Creates a default model
		Model model = ModelFactory.createDefaultModel();
		model.read(i, null);

		// out stream nam treba da bismo videli ispis na konzoli
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		model.write(out, SparqlUtil.NTRIPLES);
		System.out.println("[INFO] Rendering model as RDF/XML...");
		model.write(System.out, SparqlUtil.RDF_XML);

		String s =  new String(out.toByteArray());

		/*
		 * Create UpdateProcessor, an instance of execution of an UpdateRequest.
		 * UpdateProcessor sends update request to a remote SPARQL update service.
		 */
		UpdateRequest request = UpdateFactory.create();

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

	/**
	 * 
	 * @param graph_uri
	 * @param type     
	 * @return
	 * @throws IOException
	 * @throws BadRequestException
	 */
	public static String readFileAsXML(String graph_uri) throws IOException, BadRequestException {
		ConnectionProperties fusekiConn = FueskiAuthenticationUtilities.loadProperties();
		// Querying the first named graph with a simple SPARQL query
		System.out.println("[INFO] Selecting the triples from the named graph \"" + graph_uri + "\".");
		String sparqlQuery = SparqlUtil.selectData(fusekiConn.dataEndpoint + graph_uri, "?s ?p ?o");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(fusekiConn.queryEndpoint, sparqlQuery);

		// Query the SPARQL endpoint
		ResultSet results = query.execSelect();

		// citanje rdfa u promenljivu tipa string
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsXML(stream, results);
		String rdfString = new String(stream.toByteArray());

		query.close();
		System.out.println("[INFO] End.");

		return rdfString;

	}

	public static String readFileAsJSON(String uri) throws IOException, BadRequestException {
		ConnectionProperties fusekiConn = FueskiAuthenticationUtilities.loadProperties();

		// Querying the first named graph with a simple SPARQL query
		System.out.println("[INFO] Selecting the triples from the named graph \"" + uri + "\".");
		String sparqlQuery = SparqlUtil.selectData(fusekiConn.dataEndpoint + uri, "?s ?p ?o");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(fusekiConn.queryEndpoint, sparqlQuery);

		// Query the SPARQL endpoint
		ResultSet results = query.execSelect();

		// citanje rdfa u promenljivu tipa string
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(stream, results);
		String rdfString = new String(stream.toByteArray());

		query.close();
		System.out.println("[INFO] End.");

		return rdfString;
	}
}
