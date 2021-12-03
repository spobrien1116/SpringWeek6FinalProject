package com.promineotech.consoles.service;

import java.util.List;
import com.promineotech.consoles.entity.UserConsoles;

/**
 * @author Shawn O'Brien
 *
 */
public interface UserConsolesService {

  /**
   * @return
   */
  List<UserConsoles> getAllUserConsoles();

  
  /**
   * @param fillerParameter
   * @return
   */
  UserConsoles createUserConsole(UserConsoles fillerParameter);
  
  
  /**
   * @param fillerParameter
   * @return
   */
  UserConsoles updateUserConsole(UserConsoles fillerParameter);
  
  
  /**
   * @param userConsoleId (database's user_console_id)
   * @return
   */
  int deleteUserConsole(int userConsoleId);

}
