package tim1.backend.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import static tim1.backend.utils.PathConstants.*;


public class MetadataExtractor {
	
	private TransformerFactory transformerFactory;
	// ako ne rade putanje dodati ./../
	private static final String XSLT_FILE = "./../documents/xsl_documents/RDFa2RDFXML.xsl";
	
	public MetadataExtractor() throws SAXException, IOException {
		
		// Setup the XSLT transformer factory
		transformerFactory = new TransformerFactoryImpl();
	}

	public void extractMetadata(InputStream in, OutputStream out) throws FileNotFoundException, TransformerException {
		
		// Create transformation source
		StreamSource transformSource = new StreamSource(new File(XSLT_FILE));
		
		// Initialize GRDDL transformer object
		Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);
		
		// Set the indentation properties
		grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
		grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		// Initialize transformation subject
		StreamSource source = new StreamSource(in);

		// Initialize result stream
		StreamResult result = new StreamResult(out);
		
		// Trigger the transformation
		grddlTransformer.transform(source, result);
		
	}
	
	
	public void test(String name) throws Exception, FileNotFoundException {

		System.out.println("[INFO] " + MetadataExtractor.class.getSimpleName());
		
        String filePath = BASE + "/gen/grddl_metadata.rdf";
        
        String xml_document = BASE + "/xml_documents/" + name;
		
		InputStream in = new FileInputStream(new File(xml_document)); 

		OutputStream out = new FileOutputStream(filePath);
		
        extractMetadata(in, out);
		
		System.out.println("[INFO] File \"" + filePath + "\" generated successfully.");
		
		System.out.println("[INFO] End.");

	}


}
