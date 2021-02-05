package tim1.backend.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.tools.ant.util.ReaderInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zalbaodluka.ZalbaNaOdluku;
import tim1.backend.repository.ZalbaNaOdlukuRepository;

@Service
public class ZalbaNaOdlukuService extends AbstractService {

    @Autowired
    public ZalbaNaOdlukuService(ZalbaNaOdlukuRepository repository) {
        super(repository, "/db/poverenik/zalbanaodluku/", "/zalbanaodluku/");
    }

    @Override
    public void saveXML(String documentId, String content) throws Exception {

        InputStream inputStream = new ReaderInputStream(new StringReader(content));

        JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ZalbaNaOdluku zalbaNaOdluku = (ZalbaNaOdluku) unmarshaller.unmarshal(inputStream);
        zalbaNaOdluku.setId(documentId);
        
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
        marshaller.marshal(zalbaNaOdluku, stream);
        
        String finalString = new String(stream.toByteArray());
        System.out.println(finalString);
        
        content = finalString;

        repository.saveXML(documentId, collectionId, content);
        repository.saveRDF(content, documentId);

    }

    public JaxbLista<ZalbaNaOdluku> findAllFromCollection() throws Exception {

        List<ZalbaNaOdluku> listaZalbi = this.findAllFromCollection(ZalbaNaOdluku.class);
        JaxbLista<ZalbaNaOdluku> listaObj = new JaxbLista<ZalbaNaOdluku>(listaZalbi);
        return listaObj;
    }

}
