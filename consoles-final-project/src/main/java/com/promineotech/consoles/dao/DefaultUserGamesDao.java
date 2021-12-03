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
import com.promineotech.consoles.entity.UserGames;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shawn O'Brien
 *
 */

@Component
@Slf4j
public class DefaultUserGamesDao implements UserGamesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<UserGames> getAllUserGames() {
    log.debug("No parameters for this method");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM user_games";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<UserGames>() {
      @Override
      public UserGames mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return UserGames.builder()
            .userGameId(rs.getInt("user_game_id"))
            .personId(rs.getInt("person_id"))
            .gameSerialNum(rs.getInt("game_serial_num"))
            .gameName(rs.getString("game_name"))
            .consoleName(rs.getString("console_name"))
            .build();
        // @formatter:on
      }
    });
  }
  
  @Override
  public UserGames createUserGame(UserGames fillerParameter) {
    log.debug("DAO: personId={}, gameSerialNum={}, gameName={}, consoleName={}",
        fillerParameter.getPersonId(), fillerParameter.getGameSerialNum(),
        fillerParameter.getGameName(), fillerParameter.getConsoleName());
    
    // @formatter:off
    String sql = ""
        + "INSERT INTO user_games ("
        + "person_id, game_serial_num, game_name, console_name"
        + ") VALUES ("
        + ":personId, :gameSerialNum, :gameName, :consoleName"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("personId", fillerParameter.getPersonId());
    params.source.addValue("gameSerialNum", fillerParameter.getGameSerialNum());
    params.source.addValue("gameName", fillerParameter.getGameName());
    params.source.addValue("consoleName", fillerParameter.getConsoleName());
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    if (jdbcTemplate.update(params.sql, params.source, keyHolder) == 0) {
      throw new NoSuchElementException("Creation unsuccessful");
    }
    
    int userGameId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return UserGames.builder()
        .userGameId(userGameId)
        .personId(fillerParameter.getPersonId())
        .gameSerialNum(fillerParameter.getGameSerialNum())
        .gameName(fillerParameter.getGameName())
        .consoleName(fillerParameter.getConsoleName())
        .build();
    // @formatter:on
  }
  
  @Override
  public UserGames updateUserGame(UserGames fillerParameter) {
    log.debug("DAO: userGameId={}, personId={}, gameSerialNum={}, gameName={}, consoleName={}",
        fillerParameter.getUserGameId(),
        fillerParameter.getPersonId(), fillerParameter.getGameSerialNum(), 
        fillerParameter.getGameName(), fillerParameter.getConsoleName());
    
 // @formatter:off
    String sql = ""
        + "UPDATE user_games SET "
        + "person_id = :personId, "
        + "game_serial_num = :gameSerialNum, "
        + "game_name = :gameName, "
        + "console_name = :consoleName "
        + "WHERE user_game_id = :userGameId";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("userGameId", fillerParameter.getUserGameId());
    params.source.addValue("gameSerialNum", fillerParameter.getGameSerialNum());
    params.source.addValue("gameName", fillerParameter.getGameName());
    params.source.addValue("consoleName", fillerParameter.getConsoleName());
    params.source.addValue("personId", fillerParameter.getPersonId());
    
    
//    KeyHolder keyHolder = new GeneratedKeyHolder();
    if (jdbcTemplate.update(params.sql, params.source) == 0) {
      throw new NoSuchElementException("Update unsuccessful");
    }
    
//    int userGameId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return UserGames.builder()
//        .userGameId(userGameId)
        .personId(fillerParameter.getPersonId())
        .gameSerialNum(fillerParameter.getGameSerialNum())
        .gameName(fillerParameter.getGameName())
        .consoleName(fillerParameter.getConsoleName())
        .build();
    // @formatter:on
  }
  
  @Override
  public int deleteUserGame(int userGameId) {
    log.debug("DAO: userGameId={}",
        userGameId);
    
    // @formatter:off
    String sql = ""
        + "DELETE FROM user_games "
        + "WHERE user_game_id = :userGameId";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("userGameId", userGameId);
    
    if (jdbcTemplate.update(params.sql, params.source) == 0) {
      throw new NoSuchElementException("Delete unsuccessful");
    }
    
    return userGameId;
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}
