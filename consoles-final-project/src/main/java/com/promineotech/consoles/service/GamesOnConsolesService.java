package com.promineotech.consoles.service;

import java.util.List;
import com.promineotech.consoles.entity.GamesOnConsoles;

/**
 * @author Shawn O'Brien
 *
 */
public interface GamesOnConsolesService {
  
  /**
   * @return
   */
  List<GamesOnConsoles> getAllGamesOnConsoles();
  
  
  /**
   * @param fillerParameter
   * @return
   */
  GamesOnConsoles createGameOnConsole(GamesOnConsoles fillerParameter);
  
//  /**
//   * @param fillerParameter
//   * @return
//   */
//  GamesOnConsoles updateGameOnConsole(GamesOnConsoles fillerParameter);
  
  /**
   * @param fillerParameter
   * @return
   */
  GamesOnConsoles deleteGameOnConsole(GamesOnConsoles fillerParameter);
  
}
