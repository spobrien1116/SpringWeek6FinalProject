package com.promineotech.consoles.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.consoles.dao.UserGamesDao;
import com.promineotech.consoles.entity.UserGames;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Service
@Slf4j
public class DefaultUserGamesService implements UserGamesService {
  
  @Autowired
  private UserGamesDao userGamesDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<UserGames> getAllUserGames() {
    log.info("The UserGamesDao.getAllUserGames method was called from the service layer "
        + "attempting to retrieve a list of all user_games");
    
    List<UserGames> userGames = userGamesDao.getAllUserGames();
    
    if (userGames.isEmpty()) {
      String msg = String.format("No user games were found in the user_games table");
      throw new NoSuchElementException(msg);
    }
    
    return userGames;
  }
  
  @Transactional
  @Override
  public UserGames createUserGame(UserGames fillerParameter) {
    log.info("The UserGamesDao.createUserGame method was called from the service layer "
        + "attempting to create a user game");
    return userGamesDao.createUserGame(fillerParameter);
  }
  
  @Transactional
  @Override
  public UserGames updateUserGame(UserGames fillerParameter) {
    log.info("The UserGamesDao.updateUserGame method was called from the service layer "
        + "attempting to update a user game");
    return userGamesDao.updateUserGame(fillerParameter);
  }
  
  @Transactional
  @Override
  public int deleteUserGame(int userGameId) {
    log.info("The UserGamesDao.deleteUserGame method was called from the service layer "
        + "attempting to update a user game");
    return userGamesDao.deleteUserGame(userGameId);
  }

}
