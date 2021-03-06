
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package tim1.backend.soap.ZalbaNaOdluku;

import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;

import javax.annotation.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import tim1.backend.model.liste.JaxbLista;
import tim1.backend.model.zalbaodluka.ZalbaNaOdluku;
import tim1.backend.service.ZalbaNaOdlukuService;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-03T16:13:11.984+01:00
 * Generated source version: 3.2.1
 * 
 */


@javax.jws.WebService(
                      serviceName = "ZalbaNaOdlukuService",
                      portName = "ZalbaNaOdlukuServiceSoapBinding",
                      targetNamespace = "http://www.ftn.uns.ac.rs/zalba-na-odluku",
                      wsdlLocation = "classpath:wsdl/ZalbaNaOdluku.wsdl",
                      endpointInterface = "tim1.backend.soap.ZalbaNaOdluku.ZalbaNaOdlukuServicePortType")
@Service
public class ZalbaNaOdlukuServiceSoapBindingImpl implements ZalbaNaOdlukuServicePortType {

    @Autowired
    private ZalbaNaOdlukuService zalbaNaOdlukuService;

    private static final Logger LOG = Logger.getLogger(ZalbaNaOdlukuServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see rs.ac.uns.ftn.zalba_na_odluku.ZalbaNaOdlukuServicePortType#getAll()*
     */
    public java.lang.String getAll() { 
        LOG.info("Executing operation getAll");
        try {
            JaxbLista<ZalbaNaOdluku> lista = zalbaNaOdlukuService.findAllFromCollection();
            JAXBContext context = JAXBContext.newInstance(JaxbLista.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            marshaller.marshal(lista, stream);
            String listaString = new String(stream.toByteArray());
            return listaString;

        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see rs.ac.uns.ftn.zalba_na_odluku.ZalbaNaOdlukuServicePortType#getZalbaNaOdlukuById(java.lang.String id)*
     */
    public java.lang.String getZalbaNaOdlukuById(java.lang.String id) { 
        LOG.info("Executing operation getZalbaNaOdlukuById");

        try {
            String documentId = id;
            XMLResource xml = zalbaNaOdlukuService.readXML(documentId);
            return xml.getContent().toString();
            // return "";
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
