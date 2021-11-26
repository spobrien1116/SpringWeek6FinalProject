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
public class Users {
  private int personId;
  private String fullName;
  private String userName;
  
  @JsonIgnore
  public int getPersonId() {
    return personId;
  }
}
