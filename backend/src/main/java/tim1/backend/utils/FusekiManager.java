package tim1.backend.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
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

    public static void writeFuseki(String rdfFilePath, String NAMED_GRAPH) throws IOException {
		ConnectionProperties fusekiConn = FueskiAuthenticationUtilities.loadProperties();
		// String rdfFilePath = EXAMPLE_RDF;
		// String NAMED_GRAPH = EXAMPLE_PATH_URI;

		// String rdfFilePath = ZAHTEV_RDF;
		// String NAMED_GRAPH = ZAHTEV_PATH_URI;

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
    
    public static ResultSet readFile(String graph_uri) throws IOException {
        ConnectionProperties fusekiConn = FueskiAuthenticationUtilities.loadProperties();
		//String NAMED_GRAPH_URI = "/example/person/metadata";

        // Querying the first named graph with a simple SPARQL query
		System.out.println("[INFO] Selecting the triples from the named graph \"" + graph_uri + "\".");
		String sparqlQuery = SparqlUtil.selectData(fusekiConn.dataEndpoint + graph_uri, "?s ?p ?o");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(fusekiConn.queryEndpoint, sparqlQuery);

		// Query the SPARQL endpoint
        ResultSet results = query.execSelect();

		ResultSetFormatter.outputAsXML(System.out, results);
		ResultSetFormatter.outputAsJSON(System.out, results);

		query.close();

        System.out.println("[INFO] End.");

        return results;
	}
	
	public static ResultSet readFile() throws IOException {
        ConnectionProperties fusekiConn = FueskiAuthenticationUtilities.loadProperties();

        // Querying the first named graph with a simple SPARQL query
		System.out.println("[INFO] Selecting the triples from the named graph \"" + ZAHTEV_PATH_URI + "\".");
		String sparqlQuery = SparqlUtil.selectData(fusekiConn.dataEndpoint + ZAHTEV_PATH_URI, "?s ?p ?o");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(fusekiConn.queryEndpoint, sparqlQuery);

		// Query the SPARQL endpoint
        ResultSet results = query.execSelect();

		// String varName;
		// RDFNode varValue;
		
		// while(results.hasNext()) {
		    
		// 	// A single answer from a SELECT query
		// 	QuerySolution querySolution = results.next() ;
		// 	Iterator<String> variableBindings = querySolution.varNames();
			
		// 	// Retrieve variable bindings
		//     while (variableBindings.hasNext()) {
		   
		//     	varName = variableBindings.next();
		//     	varValue = querySolution.get(varName);
		    	
		//     	System.out.println(varName + ": " + varValue);
		//     }
		//     System.out.println();
		// }
		
		// ResultSetFormatter.outputAsXML(System.out, results);
		ResultSetFormatter.outputAsJSON(System.out, results);
		
		query.close() ;
		
		System.out.println("[INFO] End.");

		return results;
    }

}
