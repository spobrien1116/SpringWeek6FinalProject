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
  List<UserConsoles> fetchUserConsoles();

  
  /**
   * @param fillerParameter
   * @return
   */
  UserConsoles createUserConsole(UserConsoles fillerParameter);

}
