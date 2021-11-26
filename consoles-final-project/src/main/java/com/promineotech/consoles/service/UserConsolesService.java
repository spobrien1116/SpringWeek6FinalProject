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
  List<UserConsoles> fetchUserConsoles();

  
  /**
   * @param fillerParameter
   * @return
   */
  UserConsoles createUserConsole(UserConsoles fillerParameter);

}
