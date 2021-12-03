package com.promineotech.consoles.dao;

import java.util.List;
import com.promineotech.consoles.entity.Consoles;

/**
 * @author Shawn O'Brien
 *
 */
public interface ConsolesDao {

  /**
   * @return
   */
  List<Consoles> getAllConsoles();
  
  
  /**
   * @param fillerParameter (will include all columns in Consoles)
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
