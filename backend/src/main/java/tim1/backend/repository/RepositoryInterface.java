package tim1.backend.repository;

import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

public interface RepositoryInterface {
    
    public XMLResource getById(String id) throws Exception;

    public void save(String id) throws Exception;

}
