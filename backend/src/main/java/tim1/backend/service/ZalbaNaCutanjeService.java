package tim1.backend.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.tools.ant.util.ReaderInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zalbacutanje.ZalbaNaCutanje;
import tim1.backend.repository.ZalbaNaCutanjeRepository;

@Service
public class ZalbaNaCutanjeService extends AbstractService {

    @Autowired
    public ZalbaNaCutanjeService(ZalbaNaCutanjeRepository repository) {
        super(repository, "/db/poverenik/zalbanacutanje/", "/zalbanacutanje/");
    }

    @Override
    public void saveXML(String documentId, String content) throws Exception {

        InputStream inputStream = new ReaderInputStream(new StringReader(content));

        JAXBContext context = JAXBContext.newInstance(ZalbaNaCutanje.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ZalbaNaCutanje zalbaNaCutanje = (ZalbaNaCutanje) unmarshaller.unmarshal(inputStream);

        zalbaNaCutanje.setId(documentId);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
        marshaller.marshal(zalbaNaCutanje, stream);
        
        String finalString = new String(stream.toByteArray());
        System.out.println(finalString);
        
        content = finalString;
        
        repository.saveXML(documentId, collectionId, content);
        repository.saveRDF(content, documentId);
    }

    public JaxbLista<ZalbaNaCutanje> findAllFromCollection() throws Exception {

        List<ZalbaNaCutanje> listaZalbi = this.findAllFromCollection(ZalbaNaCutanje.class);
        JaxbLista<ZalbaNaCutanje> listaObj = new JaxbLista<ZalbaNaCutanje>(listaZalbi);
        return listaObj;
    }

}
