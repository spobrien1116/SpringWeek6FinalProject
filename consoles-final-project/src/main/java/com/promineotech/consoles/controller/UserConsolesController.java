package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.consoles.entity.UserConsoles;
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
@RequestMapping("/user_consoles")
@OpenAPIDefinition(info = @Info(title = "Consoles and Games Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserConsolesController {
  
  // @formatter:off
  @Operation(
      summary = "Returns a list of User Consoles",
      description = "Returns a list of all Consoles",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of User Consoles is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserConsoles.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No Consoles were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
//      },
//      parameters = {
//          @Parameter(
//              name = "brand",
//              allowEmptyValue = false,
//              required = false,
//              description = "The console brand (i.e., 'Nintendo')")
      }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<UserConsoles> fetchUserConsoles();
  // @formatter:on
  
  // @formatter:off
  @Operation(
      summary = "Create an entry for user owned consoles",
      description = "Returns the created user owned console",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "The created user owned console is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserConsoles.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "A console component was not found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  UserConsoles createUserConsole(@Valid @RequestBody UserConsoles fillerParameter);
  // @formatter:on
  
}
