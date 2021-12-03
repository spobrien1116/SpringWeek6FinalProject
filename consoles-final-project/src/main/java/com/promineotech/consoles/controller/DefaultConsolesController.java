package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
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
  public List<Consoles> getAllConsoles() {
    log.debug("In getAllConsoles method");
    return consolesService.getAllConsoles();
  }

  @Override
  public Consoles createConsole(@Valid Consoles fillerParameter) {
    log.debug("Filler parameter that will contain the console row created in consoles");
    return consolesService.createConsole(fillerParameter);
  }
  
  @Override
  public Consoles updateConsole(@Valid Consoles fillerParameter) {
    log.debug("Filler parameter that will contain the console row updated in consoles");
    return consolesService.updateConsole(fillerParameter);
  }
  
  @Override
  public String deleteConsole(@Valid @Length(max = 25) @Pattern(regexp = "[\\w\\s]*")
    String consoleName) {
    log.debug("Name of the console for the console row deleted in consoles");
    log.debug("consoleName={}", consoleName);
    return consolesService.deleteConsole(consoleName);
  }

}
