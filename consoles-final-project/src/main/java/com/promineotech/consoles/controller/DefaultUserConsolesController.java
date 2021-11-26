package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
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
  public List<UserConsoles> fetchUserConsoles() {
    log.debug("In fetchUserConsoles method");
    return userConsolesService.fetchUserConsoles();
  }
  
  @Override
  public UserConsoles createUserConsole(@Valid UserConsoles fillerParameter) {
    log.debug("Filler parameter that will contain all columns in UserConsoles");
    return userConsolesService.createUserConsole(fillerParameter);
  }

}
