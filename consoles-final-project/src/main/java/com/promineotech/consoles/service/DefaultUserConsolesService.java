package com.promineotech.consoles.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.consoles.dao.UserConsolesDao;
import com.promineotech.consoles.entity.UserConsoles;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Service
@Slf4j
public class DefaultUserConsolesService implements UserConsolesService {

  @Autowired
  private UserConsolesDao userConsolesDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<UserConsoles> getAllUserConsoles() {
    log.info("The UserConsolesDao.getAllUserConsoles method was called from the service layer "
        + "attempting to retrieve a list of all user consoles");
    
    List<UserConsoles> userConsoles = userConsolesDao.getAllUserConsoles();
    
    if (userConsoles.isEmpty()) {
      String msg = String.format("No user consoles were found in the user consoles table");
      throw new NoSuchElementException(msg);
    }
    
    return userConsoles;
  }
  
  @Transactional
  @Override
  public UserConsoles createUserConsole(UserConsoles fillerParameter) {
    log.info("The UserConsolesDao.createUserConsole method was called from the service layer "
        + "attempting to create a user console");
    return userConsolesDao.createUserConsole(fillerParameter);
  }
  
  @Transactional
  @Override
  public UserConsoles updateUserConsole(UserConsoles fillerParameter) {
    log.info("The UserConsolesDao.updateUserConsole method was called from the service layer "
        + "attempting to update a user console");
    return userConsolesDao.updateUserConsole(fillerParameter);
  }
  
  @Transactional
  @Override
  public int deleteUserConsole(int userConsoleId) {
    log.info("The UserConsolesDao.deleteUserConsole method was called from the service layer "
        + "attempting to delete a user console");
    return userConsolesDao.deleteUserConsole(userConsoleId);
  }

}
