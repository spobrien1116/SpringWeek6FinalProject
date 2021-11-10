package com.promineotech.consoles.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Shawn O'Brien
 *
 */

@Data
@Builder
public class UserGames {
  private int userGameId;
  private int personId;
  private int gameSerialNum;
  private String gameName;
}
