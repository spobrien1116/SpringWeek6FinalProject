package com.promineotech.consoles.service;

import java.util.List;
import com.promineotech.consoles.entity.UserGames;

/**
 * @author Shawn O'Brien
 *
 */


public interface UserGamesService {
  
  /**
   * @return
   */
  List<UserGames> getAllUserGames();
  
  
  /**
   * @param fillerParameter
   * @return
   */
  UserGames createUserGame(UserGames fillerParameter);
  
  
  /**
   * @param fillerParameter
   * @return
   */
  UserGames updateUserGame(UserGames fillerParameter);
  
  
  /**
   * @param userGameId (database's user_game_id)
   * @return
   */
  int deleteUserGame(int userGameId);
  
}
