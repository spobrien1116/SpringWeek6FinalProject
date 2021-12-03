package com.promineotech.consoles.dao;

import java.util.List;
import com.promineotech.consoles.entity.GamesOnConsoles;

/**
 * @author Shawn O'Brien
 *
 */

public interface GamesOnConsolesDao {

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
