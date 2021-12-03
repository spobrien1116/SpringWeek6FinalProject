package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.consoles.entity.GamesOnConsoles;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/games_on_consoles")
@OpenAPIDefinition(info = @Info(title = "Consoles and Games Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GamesOnConsolesController {
  
  // @formatter:off
  @Operation(
      summary = "Returns a list of games_on_consoles",
      description = "Returns a list of all games_on_consoles",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of games_on_consoles is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GamesOnConsoles.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No games on consoles were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<GamesOnConsoles> getAllGamesOnConsoles();
  // @formatter:on
  
  
  // @formatter:off
  @Operation(
      summary = "Create an entry for games_on_consoles",
      description = "Returns the created game on console",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "The created game on console is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GamesOnConsoles.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No games on consoles were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  GamesOnConsoles createGameOnConsole(@Valid @RequestBody GamesOnConsoles fillerParameter);
  // @formatter:on
  
  
//  // @formatter:off
//  @Operation(
//      summary = "Update an entry for games_on_consoles",
//      description = "Returns the updated game on console",
//      responses = {
//          @ApiResponse(
//              responseCode = "200",
//              description = "The updated game on console is returned",
//              content = @Content(
//                  mediaType = "application/json",
//                  schema = @Schema(implementation = GamesOnConsoles.class))),
//          @ApiResponse(
//              responseCode = "400",
//              description = "The request parameters are invalid",
//              content = @Content(mediaType = "application/json")),
//          @ApiResponse(
//              responseCode = "404",
//              description = "No games on consoles were found with the input criteria",
//              content = @Content(mediaType = "application/json")),
//          @ApiResponse(
//              responseCode = "500",
//              description = "An unplanned error occurred.",
//              content = @Content(mediaType = "application/json"))
//      }
//  )
//  @PutMapping
//  @ResponseStatus(code = HttpStatus.OK)
//  GamesOnConsoles updateGameOnConsole(@Valid @RequestBody GamesOnConsoles fillerParameter);
//  // @formatter:on
  
  
  // @formatter:off
  @Operation(
      summary = "Delete an entry for games_on_consoles",
      description = "Returns the deleted game on console",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The deleted game on console is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GamesOnConsoles.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No games on consoles were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }
  )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  GamesOnConsoles deleteGameOnConsole(@Valid @RequestBody GamesOnConsoles fillerParameter);
  // @formatter:on
  
}
