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
  public List<Users> getAllUsers() {
    log.info("The UsersDao.getAllUsers method was called from the service layer "
        + "attempting to retrieve a list of all Users");
    
    List<Users> users = usersDao.getAllUsers();
    
    if (users.isEmpty()) {
      String msg = String.format("No users were found in the users table");
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
  
  @Transactional
  @Override
  public Users updateUser(Users fillerParameter) {
    log.info("The UsersDao.updateUser method was called from the service layer "
        + "attempting to update a user");
    return usersDao.updateUser(fillerParameter);
  }
  
  @Transactional
  @Override
  public Users deleteUser(String fullName, String userName) {
    log.info("The UsersDao.deleteUser method was called from the service layer "
        + "attempting to delete a user");
    return usersDao.deleteUser(fullName, userName);
  }

}
