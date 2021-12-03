package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.consoles.entity.UserConsoles;
import com.promineotech.consoles.service.UserConsolesService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@RestController
@Slf4j
public class DefaultUserConsolesController implements UserConsolesController {
  
  @Autowired
  private UserConsolesService userConsolesService;

  @Override
  public List<UserConsoles> getAllUserConsoles() {
    log.debug("In getAllUserConsoles method");
    return userConsolesService.getAllUserConsoles();
  }
  
  @Override
  public UserConsoles createUserConsole(@Valid UserConsoles fillerParameter) {
    log.debug("In createUserConsole method");
    log.debug("Filler parameter that will contain the user console row created in user_consoles");
    return userConsolesService.createUserConsole(fillerParameter);
  }
  
  @Override
  public UserConsoles updateUserConsole(@Valid UserConsoles fillerParameter) {
    log.debug("In updateUserConsole method");
    log.debug("Filler parameter that will contain the user console row updated in user_consoles");
    return userConsolesService.updateUserConsole(fillerParameter);
  }
  
  @Override
  public int deleteUserConsole(@Valid @Positive int userConsoleId) {
    log.debug("In deleteUserConsole method");
    log.debug("Parameter for user_console_id for the user console row deleted in user_consoles");
    log.debug("userConsoleId={}", userConsoleId);
    return userConsolesService.deleteUserConsole(userConsoleId);
  }

}
