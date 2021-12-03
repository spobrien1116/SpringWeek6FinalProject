package com.promineotech.consoles.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.consoles.dao.GamesOnConsolesDao;
import com.promineotech.consoles.entity.GamesOnConsoles;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Service
@Slf4j
public class DefaultGamesOnConsolesService implements GamesOnConsolesService {
  
  @Autowired
  private GamesOnConsolesDao gamesOnConsolesDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<GamesOnConsoles> getAllGamesOnConsoles() {
    log.info("The GamesOnConsolesDao.getAllGamesOnConsoles method was called from the service "
        + "layer attempting to retrieve a list of all GamesOnConsoles");
    
    List<GamesOnConsoles> gamesOnConsoles = gamesOnConsolesDao.getAllGamesOnConsoles();
    
    if (gamesOnConsoles.isEmpty()) {
      String msg = String.format("No games on consoles were found in the games_on_consoles table");
      throw new NoSuchElementException(msg);
    }
    
    return gamesOnConsoles;
  }
  
  @Transactional
  @Override
  public GamesOnConsoles createGameOnConsole(GamesOnConsoles fillerParameter) {
    log.info("The GamesOnConsolesDao.createGameOnConsole method was called from the service layer "
        + "attempting to create a game on console");
    return gamesOnConsolesDao.createGameOnConsole(fillerParameter);
  }
  
//  @Transactional
//  @Override
//  public GamesOnConsoles updateGameOnConsole(GamesOnConsoles fillerParameter) {
//    log.info("The GamesOnConsolesDao.updateGameOnConsole method was called from the service layer "
//        + "attempting to update a game on console");
//    return gamesOnConsolesDao.updateGameOnConsole(fillerParameter);
//  }
  
  @Transactional
  @Override
  public GamesOnConsoles deleteGameOnConsole(GamesOnConsoles fillerParameter) {
    log.info("The GamesOnConsolesDao.deleteGameOnConsole method was called from the service layer "
        + "attempting to delete a game on console");
    return gamesOnConsolesDao.deleteGameOnConsole(fillerParameter);
  }

}
