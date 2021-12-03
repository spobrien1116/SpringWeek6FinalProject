package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.consoles.entity.UserGames;
import com.promineotech.consoles.service.UserGamesService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@RestController
@Slf4j
public class DefaultUserGamesController implements UserGamesController {
  
  @Autowired
  private UserGamesService userGamesService; 
  
  @Override
  public List<UserGames> getAllUserGames() {
    log.debug("In getAllUserGames method");
    log.debug("No parameters for this method");
    return userGamesService.getAllUserGames();
  }
  
  @Override
  public UserGames createUserGame(@Valid UserGames fillerParameter) {
    log.debug("In createUserGame method");
    log.debug("Filler parameter that will contain the user game row created in user_games");
    return userGamesService.createUserGame(fillerParameter);
  }
  
  @Override
  public UserGames updateUserGame(@Valid UserGames fillerParameter) {
    log.debug("In updateUserGame method");
    log.debug("Filler parameter that will contain the user game row updated in user_games");
    return userGamesService.updateUserGame(fillerParameter);
  }
  
  @Override
  public int deleteUserGame(@Valid @Positive int userGameId) {
    log.debug("In deleteUserGame method");
    log.debug("Parameter of the user_game_id for the user game row deleted in user_games");
    log.debug("userGameId={}", userGameId);
    return userGamesService.deleteUserGame(userGameId);
  }

}
