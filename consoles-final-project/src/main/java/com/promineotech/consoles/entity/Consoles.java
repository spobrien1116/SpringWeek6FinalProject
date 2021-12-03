package com.promineotech.consoles.entity;

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
}
