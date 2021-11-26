package com.promineotech.consoles.dao;

import java.util.List;
import com.promineotech.consoles.entity.Users;

/**
 * @author Shawn O'Brien
 *
 */
public interface UsersDao {
  
  /**
   * @return
   */
  List<Users> fetchUsers();
  
  
  /**
   * @param fillerParameter
   * @return
   */
  Users createUser(Users fillerParameter);

}
