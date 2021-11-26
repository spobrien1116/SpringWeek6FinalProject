package com.promineotech.consoles.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.consoles.dao.UsersDao;
import com.promineotech.consoles.entity.Users;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Service
@Slf4j
public class DefaultUsersService implements UsersService {
  
  @Autowired
  private UsersDao usersDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Users> fetchUsers() {
    log.info("The UsersDao.fetchUsers method was called from the service layer"
        + "attempting to retrieve a list of all Users");
    
    List<Users> users = usersDao.fetchUsers();
    
    if (users.isEmpty()) {
      String msg = String.format("No consoles were found in the consoles table");
      throw new NoSuchElementException(msg);
    }
    
    return users;
  }
  
  @Transactional
  @Override
  public Users createUser(Users fillerParameter) {
    log.info("The UsersDao.createUser method was called from the service layer "
        + "attempting to create a user");
    return usersDao.createUser(fillerParameter);
  }

}
