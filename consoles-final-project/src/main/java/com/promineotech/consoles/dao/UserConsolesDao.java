package com.promineotech.consoles.dao;

import java.util.List;
import com.promineotech.consoles.entity.UserConsoles;

/**
 * @author Shawn O'Brien
 *
 */
public interface UserConsolesDao {

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
