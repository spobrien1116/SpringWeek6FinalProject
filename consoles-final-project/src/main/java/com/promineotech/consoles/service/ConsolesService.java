package com.promineotech.consoles.service;

import java.util.List;
import com.promineotech.consoles.entity.Consoles;

/**
 * @author Shawn O'Brien
 *
 */
public interface ConsolesService {

  /**
   * @return
   */
  List<Consoles> getAllConsoles();
  
  /**
   * @param fillerParameter
   * @return
   */
  Consoles createConsole(Consoles fillerParameter);

  /**
   * @param fillerParameter
   * @return
   */
  Consoles updateConsole(Consoles fillerParameter);

  /**
   * @param consoleName (database's console_name)
   * @return
   */
  String deleteConsole(String consoleName);

}
