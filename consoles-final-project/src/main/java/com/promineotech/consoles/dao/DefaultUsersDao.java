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
import com.promineotech.consoles.entity.Consoles;
import com.promineotech.consoles.entity.Users;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Component
@Slf4j
public class DefaultUsersDao implements UsersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Users> fetchUsers() {
    log.debug("No parameters for this method");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM users";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Users>() {
      @Override
      public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Users.builder()
            .personId(rs.getInt("person_id"))
            .fullName(rs.getString("full_name"))
            .userName(rs.getString("user_name"))
            .build();
        // @formatter:on
      }
    });
  }
  
  @Override
  public Users createUser(Users fillerParameter) {
    log.debug("DAO: fullName={}, userName={}", 
        fillerParameter.getFullName(), fillerParameter.getUserName());
    
    // @formatter:off
    String sql = ""
        + "INSERT INTO users ("
        + "full_name, user_name"
        + ") VALUES ("
        + ":full_name, :user_name"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("full_name", fillerParameter.getFullName());
    params.source.addValue("user_name", fillerParameter.getUserName());
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    if (jdbcTemplate.update(params.sql, params.source, keyHolder) == 0) {
      throw new NoSuchElementException("Update unsuccessful");
    }
    
    int personId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return Users.builder()
        .personId(personId)
        .fullName(fillerParameter.getFullName())
        .userName(fillerParameter.getUserName())
        .build();
    // @formatter:on
  
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}
