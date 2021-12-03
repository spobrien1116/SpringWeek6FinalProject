package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.consoles.entity.Users;
import com.promineotech.consoles.service.UsersService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@RestController
@Slf4j
public class DefaultUsersController implements UsersController {
  
  @Autowired
  private UsersService usersService;
  
  @Override
  public List<Users> getAllUsers() {
    log.debug("In getAllUsers method");
    return usersService.getAllUsers();
  }
  
  @Override
  public Users createUser(@Valid Users fillerParameter) {
    log.debug("In createUser method");
    log.debug("Filler parameter that will contain the user row created in users");
    return usersService.createUser(fillerParameter);
  }
  
  @Override
  public Users updateUser(@Valid Users fillerParameter) {
    log.debug("In updateUser method");
    log.debug("Filler parameter that will contain the user row updated in users");
    return usersService.updateUser(fillerParameter);
  }
  
  @Override
  public Users deleteUser(String fullName, String userName) {
    log.debug("In deleteUser method");
    log.debug("Parameters of the full_name and user_name for the user row deleted in users");
    log.debug("fullName={}, userName={}", fullName, userName);
    return usersService.deleteUser(fullName, userName);
  }
  
}
