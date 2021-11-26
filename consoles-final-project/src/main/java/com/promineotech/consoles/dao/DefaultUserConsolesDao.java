package com.promineotech.consoles.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.consoles.entity.UserConsoles;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Component
@Slf4j
public class DefaultUserConsolesDao implements UserConsolesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 

  @Override
  public List<UserConsoles> fetchUserConsoles() {
    log.debug("No parameters for this method");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM user_consoles";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<UserConsoles>() {
      @Override
      public UserConsoles mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return UserConsoles.builder()
            .userConsoleId(rs.getInt("user_console_id"))
            .personId(rs.getInt("person_id"))
            .consoleSerialNum(rs.getInt("console_serial_num"))
            .consoleName(rs.getString("console_name"))
            .build();
        // @formatter:on
      }
    });
  }
  
  @Override
  public UserConsoles createUserConsole(UserConsoles fillerParameter) {
    log.debug("DAO: personId={}, consoleSerialNum={}, consoleName={}", 
        fillerParameter.getPersonId(), fillerParameter.getConsoleSerialNum(),
        fillerParameter.getConsoleName());
    
    // @formatter:off
    String sql = ""
        + "INSERT INTO user_consoles ("
        + "person_id, console_serial_num, console_name"
        + ") VALUES ("
        + ":person_id, :console_serial_num, :console_name"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
//    Map<String, Object> params = new HashMap<>();
    
    params.sql = sql;
    params.source.addValue("person_id", fillerParameter.getPersonId());
    params.source.addValue("console_serial_num", fillerParameter.getConsoleSerialNum());
    params.source.addValue("console_name", fillerParameter.getConsoleName());
    
//    params.put("person_id", fillerParameter.getPersonId());
//    params.put("console_serial_num", fillerParameter.getConsoleSerialNum());
//    params.put("console_name", fillerParameter.getConsoleName());
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    if (jdbcTemplate.update(params.sql, params.source, keyHolder) == 0) {
      throw new NoSuchElementException("Update unsuccessful");
    }
    
//    KeyHolder keyHolder = new GeneratedKeyHolder();
//    if (jdbcTemplate.update(sql, params) == 0) {
//      throw new NoSuchElementException("Update unsuccessful");
//    }
    
    int userConsoleId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return UserConsoles.builder()
        .userConsoleId(userConsoleId)
        .personId(fillerParameter.getPersonId())
        .consoleSerialNum(fillerParameter.getConsoleSerialNum())
        .consoleName(fillerParameter.getConsoleName())
        .build();
    // @formatter:on
    
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}
