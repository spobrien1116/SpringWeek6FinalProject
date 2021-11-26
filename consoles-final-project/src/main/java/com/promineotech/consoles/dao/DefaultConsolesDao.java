package com.promineotech.consoles.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
  public List<Consoles> fetchConsoles() {
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
        + ":console_name, :controllers, :release_year, :release_price, :online_capable"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("console_name", fillerParameter.getConsoleName());
    params.source.addValue("controllers", fillerParameter.getControllers());
    params.source.addValue("release_year", fillerParameter.getReleaseYear());
    params.source.addValue("release_price", fillerParameter.getReleasePrice());
    params.source.addValue("online_capable", fillerParameter.getOnlineCapable());
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    if (jdbcTemplate.update(params.sql, params.source, keyHolder) == 0) {
      throw new NoSuchElementException("Update unsuccessful");
    }
    
    String consoleName = keyHolder.getKey().toString();
    
    // @formatter:off
    return Consoles.builder()
        .consoleName(consoleName)
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
    params.source.addValue("console_name", fillerParameter.getConsoleName());
    params.source.addValue("controllers", fillerParameter.getControllers());
    params.source.addValue("release_year", fillerParameter.getReleaseYear());
    params.source.addValue("release_price", fillerParameter.getReleasePrice());
    params.source.addValue("online_capable", fillerParameter.getOnlineCapable());
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    if (jdbcTemplate.update(params.sql, params.source, keyHolder) == 0) {
      throw new NoSuchElementException("Update unsuccessful");
    }
    
    String consoleName = keyHolder.getKey().toString();
    
    // @formatter:off
    return Consoles.builder()
        .consoleName(consoleName)
        .controllers(fillerParameter.getControllers())
        .releaseYear(fillerParameter.getReleaseYear())
        .releasePrice(fillerParameter.getReleasePrice())
        .onlineCapable(fillerParameter.getOnlineCapable())
        .build();
    // @formatter:on
  }
  
  @Override
  public Consoles deleteConsole(Consoles fillerParameter) {
    log.debug("DAO: consoleName={}, controllers={}, releaseYear={}, releasePrice={}, "
        + "onlineCapable={}",
        fillerParameter.getConsoleName(), fillerParameter.getControllers(), 
        fillerParameter.getReleaseYear(), fillerParameter.getReleasePrice(), 
        fillerParameter.getOnlineCapable());
    
    // @formatter:off
    String sql = ""
        + "DELETE FROM consoles "
        + "WHERE console_name = :consoleName";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("console_name", fillerParameter.getConsoleName());
    params.source.addValue("controllers", fillerParameter.getControllers());
    params.source.addValue("release_year", fillerParameter.getReleaseYear());
    params.source.addValue("release_price", fillerParameter.getReleasePrice());
    params.source.addValue("online_capable", fillerParameter.getOnlineCapable());
    
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

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
}


