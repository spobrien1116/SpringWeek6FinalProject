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
public class Consoles {
  private String consoleName;
  private int controllers;
  private int releaseYear;
  private double releasePrice;
  private int onlineCapable;
  
//  @JsonIgnore
//  public String getConsoleName() {
//    return consoleName;
//  }
}
