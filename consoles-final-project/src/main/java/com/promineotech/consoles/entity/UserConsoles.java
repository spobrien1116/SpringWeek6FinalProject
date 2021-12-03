package com.promineotech.consoles.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Shawn O'Brien
 *
 */

@Data
@Builder
public class UserConsoles {
  private int userConsoleId;
  private int personId;
  private int consoleSerialNum;
  private String consoleName;
  
//  @JsonIgnore
//  public void setUserConsoleId(int userConsoleId) {
//    this.userConsoleId = userConsoleId;
//  }
}
