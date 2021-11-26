package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.consoles.entity.Consoles;
import com.promineotech.consoles.service.ConsolesService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@RestController
@Slf4j
public class DefaultConsolesController implements ConsolesController {
  
  @Autowired
  private ConsolesService consolesService;
  
  @Override
  public List<Consoles> fetchConsoles() {
    log.debug("In fetchConsoles method");
    return consolesService.fetchConsoles();
  }

  @Override
  public Consoles createConsole(@Valid Consoles fillerParameter) {
    log.debug("Filler parameter that will contain all columns in Consoles");
    return consolesService.createConsole(fillerParameter);
  }
  
  @Override
  public Consoles updateConsole(@Valid Consoles fillerParameter) {
    log.debug("Filler parameter that will contain the console row updated in Consoles");
    return consolesService.updateConsole(fillerParameter);
  }
  
  @Override
  public Consoles deleteConsole(@Valid Consoles fillerParameter) {
    log.debug("Filler parameter that will contain the console row deleted in Consoles");
    return consolesService.deleteConsole(fillerParameter);
  }

}
