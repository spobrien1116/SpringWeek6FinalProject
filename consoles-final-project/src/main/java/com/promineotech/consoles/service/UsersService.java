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
  List<Users> fetchUsers();
  
  /**
   * @param fillerParameter
   * @return
   */
  Users createUser(Users fillerParameter);

}
