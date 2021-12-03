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
  List<Users> getAllUsers();
  
  
  /**
   * @param fillerParameter
   * @return
   */
  Users createUser(Users fillerParameter);
  
  
  /**
   * @param fillerParameter
   * @return
   */
  Users updateUser(Users fillerParameter);
  
  
  /**
   * @param fullName (database's full_name)
   * @param userName (database's user_name)
   * @return
   */
  Users deleteUser(String fullName, String userName);

}
