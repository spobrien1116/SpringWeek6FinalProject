package com.promineotech.consoles.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.consoles.dao.ConsolesDao;
import com.promineotech.consoles.entity.Consoles;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Service
@Slf4j
public class DefaultConsolesService implements ConsolesService {
  
  @Autowired
  private ConsolesDao consolesDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Consoles> getAllConsoles() {
    log.info("The ConsolesDao.getAllConsoles method was called from the service layer "
        + "attempting to retrieve a list of all Consoles");
    
    List<Consoles> consoles = consolesDao.getAllConsoles();
    
    if (consoles.isEmpty()) {
      String msg = String.format("No consoles were found in the consoles table");
      throw new NoSuchElementException(msg);
    }
    
//    Collections.sort(consoles);
    return consoles;
  }
  
  @Transactional
  @Override
  public Consoles createConsole(Consoles fillerParameter) {
    log.info("The ConsolesDao.createConsole method was called from the service layer "
        + "attempting to create a console");
    return consolesDao.createConsole(fillerParameter);
  }
  
  @Transactional
  @Override
  public Consoles updateConsole(Consoles fillerParameter) {
    log.info("The ConsolesDao.updateConsole method was called from the service layer "
        + "attempting to update a console");
    return consolesDao.updateConsole(fillerParameter);
  }
  
  @Transactional
  @Override
  public String deleteConsole(String consoleName) {
    log.info("The ConsolesDao.deleteConsole method was called from the service layer "
        + "attempting to delete a console");
    return consolesDao.deleteConsole(consoleName);
  }

}
