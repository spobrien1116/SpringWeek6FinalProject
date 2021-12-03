package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.consoles.entity.GamesOnConsoles;
import com.promineotech.consoles.service.GamesOnConsolesService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@RestController
@Slf4j
public class DefaultGamesOnConsolesController implements GamesOnConsolesController {

  @Autowired
  private GamesOnConsolesService gamesOnConsolesService;
  
  @Override
  public List<GamesOnConsoles> getAllGamesOnConsoles() {
    log.debug("In getAllGamesOnConsoles method");
    return gamesOnConsolesService.getAllGamesOnConsoles();
  }
  
  @Override
  public GamesOnConsoles createGameOnConsole(@Valid GamesOnConsoles fillerParameter) {
    log.debug("Filler parameter that will contain the game on console row created in "
        + "games_on_consoles");
    return gamesOnConsolesService.createGameOnConsole(fillerParameter);
  }
  
//  @Override
//  public GamesOnConsoles updateGameOnConsole(@Valid GamesOnConsoles fillerParameter) {
//    log.debug("Filler parameter that will contain the game on console row updated in "
//        + "games_on_consoles");
//    return gamesOnConsolesService.updateGameOnConsole(fillerParameter);
//  }
  
  @Override
  public GamesOnConsoles deleteGameOnConsole(@Valid GamesOnConsoles fillerParameter) {
    log.debug("Filler parameter that will contain the game on console row deleted in "
        + "games_on_consoles");
    return gamesOnConsolesService.deleteGameOnConsole(fillerParameter);
  }

}
