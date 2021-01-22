package tim1.backend.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.liste.ZalbaNaCutanjeLista;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.repository.ZalbaNaCutanjeRepository;

@Service
public class ZalbaNaCutanjeService implements ServiceInterface {

    @Autowired
    private ZalbaNaCutanjeRepository repository;

    private String collectionId = "/db/poverenik/zalbanacutanje/";

    private String fusekiCollectionId = "/zalbanacutanje/";
    
    @Override
    public void saveRDF(String content, String uri) throws Exception {
        repository.saveRDF(content, fusekiCollectionId + uri);
    }

    @Override
    public void saveXML(String documentId, String content) throws Exception {
        
        repository.saveXML(documentId, collectionId, content );

    }

    @Override
    public XMLResource readXML(String documentId) {

        XMLResource document = null;
        
        try {
            document = repository.readXML(documentId, collectionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return document;
    }

    @Override
    public String readFileAsXML(String uri) throws Exception {
        uri = fusekiCollectionId + uri;
        return repository.readFileAsXML(uri);
    }

    @Override
    public String readFileAsJSON(String uri) throws Exception {
        uri = fusekiCollectionId + uri;
        return repository.readFileAsJSON(uri);
    }

    public ZalbaNaCutanjeLista findAllFromCollection() throws Exception{
        List<ZalbaNaCutanje> temp = new ArrayList<>();
        List<XMLResource> retval =  repository.findAllFromCollection(collectionId);

        JAXBContext context = JAXBContext.newInstance(ZalbaNaCutanje.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        for (XMLResource dokument : retval) {
            String s = dokument.getContent().toString();
            StringReader reader = new StringReader(s);
            ZalbaNaCutanje zalba = (ZalbaNaCutanje) unmarshaller.unmarshal(reader);
            temp.add(zalba);
        }

        ZalbaNaCutanjeLista lista = new ZalbaNaCutanjeLista(temp);
        
        return lista;
    }
}
