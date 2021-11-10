package com.promineotech.consoles.entity;

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
}
