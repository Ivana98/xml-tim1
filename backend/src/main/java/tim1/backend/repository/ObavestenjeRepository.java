package tim1.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tim1.backend.utils.DBManager;

@Repository
public class ObavestenjeRepository {
  @Autowired
  private DBManager dbManager;
}
