package com.promineotech.consoles.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  
  @JsonIgnore
  public int getUserConsoleId() {
    return userConsoleId;
  }
}
