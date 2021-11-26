package com.promineotech.consoles.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
  public List<Users> fetchUsers() {
    log.debug("In fetchUsers method");
    return usersService.fetchUsers();
  }
  
  @Override
  public Users createUser(@Valid Users fillerParameter) {
    log.debug("Filler parameter that will contain all columns in users");
    return usersService.createUser(fillerParameter);
  }
  
}
