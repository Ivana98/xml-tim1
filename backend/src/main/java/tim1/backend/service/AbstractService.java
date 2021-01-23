package tim1.backend.service;

import java.util.List;

import org.xmldb.api.modules.XMLResource;

import tim1.backend.repository.RepositoryInterface;

public abstract class AbstractService {
  
  protected RepositoryInterface repository;

  protected String collectionId;

  protected String fusekiCollectionId;

  public AbstractService(RepositoryInterface repository, String collectionId, String fusekiCollectionId){
    this.repository = repository;
    this.collectionId = collectionId;
    this.fusekiCollectionId = fusekiCollectionId;
  }
   
  public void saveRDF(String content, String uri) throws Exception {
      repository.saveRDF(content, fusekiCollectionId + uri);
  }

  public void saveXML(String documentId, String content) throws Exception {
      
      repository.saveXML(documentId, collectionId, content );

  }


  public XMLResource readXML(String documentId) {

      XMLResource document = null;
      
      try {
          document = repository.readXML(documentId, collectionId);
      } catch (Exception e) {
          e.printStackTrace();
      }
      
      return document;
  }

  public String readFileAsXML(String uri) throws Exception {
      uri = fusekiCollectionId + uri;
      return repository.readFileAsXML(uri);
  }

  public String readFileAsJSON(String uri) throws Exception {
      uri = fusekiCollectionId + uri;
      return repository.readFileAsJSON(uri);
  }

}
