package com.promineotech.consoles.service;

import java.util.List;
import com.promineotech.consoles.entity.Users;

/**
 * @author Owner
 *
 */
public interface UsersService {
  
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
