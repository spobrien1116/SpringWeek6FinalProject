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
import com.promineotech.consoles.entity.Consoles;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Component
@Slf4j
public class DefaultConsolesDao implements ConsolesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Consoles> getAllConsoles() {
    log.debug("No parameters for this method");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM consoles";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Consoles>() {
      @Override
      public Consoles mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Consoles.builder()
            .consoleName(rs.getString("console_name"))
            .controllers(rs.getInt("controllers"))
            .releaseYear(rs.getInt("release_year"))
            .releasePrice(rs.getDouble("release_price"))
            .onlineCapable(rs.getInt("online_capable"))
            .build();
        // @formatter:on
      }
    });
  }
  
  @Override
  public Consoles createConsole(Consoles fillerParameter) {
    log.debug("DAO: consoleName={}, controllers={}, releaseYear={}, "
        + "releasePrice={}, onlineCapable={}", 
        fillerParameter.getConsoleName(), fillerParameter.getControllers(),
        fillerParameter.getReleaseYear(), fillerParameter.getReleasePrice(),
        fillerParameter.getOnlineCapable());
    
    // @formatter:off
    String sql = ""
        + "INSERT INTO consoles ("
        + "console_name, controllers, release_year, release_price, online_capable"
        + ") VALUES ("
        + ":consoleName, :controllers, :releaseYear, :releasePrice, :onlineCapable"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("consoleName", fillerParameter.getConsoleName());
    params.source.addValue("controllers", fillerParameter.getControllers());
    params.source.addValue("releaseYear", fillerParameter.getReleaseYear());
    params.source.addValue("releasePrice", fillerParameter.getReleasePrice());
    params.source.addValue("onlineCapable", fillerParameter.getOnlineCapable());
    
    if (jdbcTemplate.update(params.sql, params.source) == 0) {
      throw new NoSuchElementException("Creation unsuccessful");
    }
    
    // @formatter:off
    return Consoles.builder()
        .consoleName(fillerParameter.getConsoleName())
        .controllers(fillerParameter.getControllers())
        .releaseYear(fillerParameter.getReleaseYear())
        .releasePrice(fillerParameter.getReleasePrice())
        .onlineCapable(fillerParameter.getOnlineCapable())
        .build();
    // @formatter:on
  }
  
  @Override
  public Consoles updateConsole(Consoles fillerParameter) {
    log.debug("DAO: consoleName={}, controllers={}, releaseYear={}, releasePrice={}, "
        + "onlineCapable={}",
        fillerParameter.getConsoleName(), fillerParameter.getControllers(), 
        fillerParameter.getReleaseYear(), fillerParameter.getReleasePrice(), 
        fillerParameter.getOnlineCapable());
    
    // @formatter:off
    String sql = ""
        + "UPDATE consoles SET "
        + "controllers = :controllers, "
        + "release_year = :releaseYear, "
        + "release_price = :releasePrice, "
        + "online_capable = :onlineCapable "
        + "WHERE console_name = :consoleName";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("consoleName", fillerParameter.getConsoleName());
    params.source.addValue("controllers", fillerParameter.getControllers());
    params.source.addValue("releaseYear", fillerParameter.getReleaseYear());
    params.source.addValue("releasePrice", fillerParameter.getReleasePrice());
    params.source.addValue("onlineCapable", fillerParameter.getOnlineCapable());
    
    if (jdbcTemplate.update(params.sql, params.source) == 0) {
      throw new NoSuchElementException("Update unsuccessful");
    }
    
    // @formatter:off
    return Consoles.builder()
        .consoleName(fillerParameter.getConsoleName())
        .controllers(fillerParameter.getControllers())
        .releaseYear(fillerParameter.getReleaseYear())
        .releasePrice(fillerParameter.getReleasePrice())
        .onlineCapable(fillerParameter.getOnlineCapable())
        .build();
    // @formatter:on
  }
  
  @Override
  public String deleteConsole(String consoleName) {
    log.debug("DAO: consoleName={}",
        consoleName);
    
    // @formatter:off
    String sql = ""
        + "DELETE FROM consoles "
        + "WHERE console_name = :consoleName";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("consoleName", consoleName);
    
    if (jdbcTemplate.update(params.sql, params.source) == 0) {
      throw new NoSuchElementException("Delete unsuccessful");
    }
    
    return consoleName;
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
}


