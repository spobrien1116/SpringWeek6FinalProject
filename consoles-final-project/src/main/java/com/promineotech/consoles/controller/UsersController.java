package com.promineotech.consoles.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
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
import com.promineotech.consoles.entity.Users;
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
@RequestMapping("/users")
@OpenAPIDefinition(info = @Info(title = "Consoles and Games Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UsersController {
  
  //@formatter:off
  @Operation(
      summary = "Returns a list of Users",
      description = "Returns a list of all Users",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Users is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No Users were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))

      }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Users> getAllUsers();
  // @formatter:on
  
  
  //@formatter:off
  @Operation(
      summary = "Create an entry for user",
      description = "Returns the created user",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "The created user is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "A user component was not found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
//      },
//      parameters = {
//          @Parameter(
//              name = "fillerParameter",
//              required = true,
//              description = "One row entry of user_consoles as JSON")
      }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Users createUser(@Valid @RequestBody Users fillerParameter);
  //@formatter:on
  
  
  //@formatter:off
  @Operation(
      summary = "Update an entry for Users",
      description = "Returns the updated user",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The updated user is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "A user was not found with the name input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
//      },
//      parameters = {
//          @Parameter(
//              name = "fillerParameter",
//              required = true,
//              description = "One row entry of consoles as JSON")
      }
  )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Users updateUser(@Valid @RequestBody Users fillerParameter);
  //@formatter:on
  
  
  // @formatter:off
  @Operation(
      summary = "Delete an entry from Users",
      description = "Returns the deleted user",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The deleted user is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "A user was not found with the name input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(
             name = "fullName",
             allowEmptyValue = false,
             required = true,
             description = "The person's full name (i.e., 'Test Person')"),
         @Parameter(
             name = "userName",
             allowEmptyValue = false,
             required = true,
             description = "The person's user name (i.e., 'tester123')")
    }
 )
 @DeleteMapping
 @ResponseStatus(code = HttpStatus.OK)
 Users deleteUser(
     @RequestParam(required = true)
         String fullName,
     @Length(max = 40)
     @Pattern(regexp = "[\\w\\s]*")
     @RequestParam(required = true)
         String userName);
 // @formatter:on
 
}
