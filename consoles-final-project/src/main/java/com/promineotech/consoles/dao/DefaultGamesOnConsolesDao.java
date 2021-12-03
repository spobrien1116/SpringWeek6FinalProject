package com.promineotech.consoles.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.consoles.entity.GamesOnConsoles;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Component
@Slf4j
public class DefaultGamesOnConsolesDao implements GamesOnConsolesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<GamesOnConsoles> getAllGamesOnConsoles() {
    log.debug("No parameters for this method");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM games_on_consoles";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<GamesOnConsoles>() {
      @Override
      public GamesOnConsoles mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return GamesOnConsoles.builder()
            .gameName(rs.getString("game_name"))
            .consoleName(rs.getString("console_name"))
            .build();
        // @formatter:on
      }
    });
  }
  
  @Override
  public GamesOnConsoles createGameOnConsole(GamesOnConsoles fillerParameter) {
    log.debug("DAO: gameName={}, consoleName={}", 
        fillerParameter.getGameName(), fillerParameter.getConsoleName());
    
    // @formatter:off
    String sql = ""
        + "INSERT INTO games_on_consoles ("
        + "game_name, console_name"
        + ") VALUES ("
        + ":gameName, :consoleName"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("gameName", fillerParameter.getGameName());
    params.source.addValue("consoleName", fillerParameter.getConsoleName());
    
    if (jdbcTemplate.update(params.sql, params.source) == 0) {
      throw new NoSuchElementException("Creation unsuccessful");
    }
    
    // @formatter:off
    return GamesOnConsoles.builder()
        .gameName(fillerParameter.getGameName())
        .consoleName(fillerParameter.getConsoleName())
        .build();
  }
  
//  @Override
//  public GamesOnConsoles updateGameOnConsole(GamesOnConsoles fillerParameter) {
//    log.debug("DAO: gameName={}, consoleName={}",
//        fillerParameter.getGameName(), fillerParameter.getConsoleName());
//    
//    // @formatter:off
//    String sql = ""
//        + "UPDATE games_on_consoles SET "
//        + "game_name = :gameName, "
//        + "console_name = :consoleName, "
//        + "WHERE game_name = :gameName";
//    // @formatter:on
//    
//    SqlParams params = new SqlParams();
//    
//    params.sql = sql;
//    params.source.addValue("gameName", fillerParameter.getGameName());
//    params.source.addValue("consoleName", fillerParameter.getConsoleName());
//    
//    if (jdbcTemplate.update(params.sql, params.source) == 0) {
//      throw new NoSuchElementException("Update unsuccessful");
//    }
//    
//    // @formatter:off
//    return GamesOnConsoles.builder()
//        .gameName(fillerParameter.getGameName())
//        .consoleName(fillerParameter.getConsoleName())
//        .build();
//    // @formatter:on
//  }
  
  @Override
  public GamesOnConsoles deleteGameOnConsole(GamesOnConsoles fillerParameter) {
    log.debug("DAO: gameName={}, consoleName={}",
        fillerParameter.getGameName(), fillerParameter.getConsoleName());
    
    // @formatter:off
    String sql = ""
        + "DELETE FROM games_on_consoles "
        + "WHERE game_name = :gameName "
        + "AND console_name = :consoleName";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("gameName", fillerParameter.getGameName());
    params.source.addValue("consoleName", fillerParameter.getConsoleName());
    
    if (jdbcTemplate.update(params.sql, params.source) == 0) {
      throw new NoSuchElementException("Delete unsuccessful");
    }
    
    // @formatter:off
    return GamesOnConsoles.builder()
        .gameName(fillerParameter.getGameName())
        .consoleName(fillerParameter.getConsoleName())
        .build();
    // @formatter:on
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}
