package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.consoles.entity.UserGames;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author Shawn O'Brien
 *
 */

@Validated
@RequestMapping("/user_games")
@OpenAPIDefinition(info = @Info(title = "Consoles and Games Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserGamesController {
  
  // @formatter:off
  @Operation(
      summary = "Returns a list of user_games",
      description = "Returns a list of all user_games",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of user_games is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserGames.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No user games were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<UserGames> getAllUserGames();
  // @formatter:on
  
  
  // @formatter:off
  @Operation(
      summary = "Create an entry for user_games",
      description = "Returns the created user game",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "The created user game is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserGames.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No user games were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  UserGames createUserGame(@Valid @RequestBody UserGames fillerParameter);
  // @formatter:on
  
  
  // @formatter:off
  @Operation(
      summary = "Update an entry for user_games",
      description = "Returns the updated user game",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The updated user game is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserGames.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No user games were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }
  )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  UserGames updateUserGame(@Valid @RequestBody UserGames fillerParameter);
  // @formatter:on
  
  
  // @formatter:off
  @Operation(
      summary = "Delete an entry for user_games",
      description = "Returns the deleted user game",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The deleted user game is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserGames.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No user games were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "userGameId",
              allowEmptyValue = false,
              required = true,
              description = "The user_game_id (i.e., '1')")
      }
  )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  int deleteUserGame(
      @Valid
      @RequestParam(required = true)
      @Positive
          int userGameId);
  // @formatter:on
  
}
