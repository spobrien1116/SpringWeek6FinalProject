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
import com.promineotech.consoles.entity.Consoles;
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
@RequestMapping("/consoles")
@OpenAPIDefinition(info = @Info(title = "Consoles and Games Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface ConsolesController {

  // @formatter:off
  @Operation(
     summary = "Returns a list of consoles",
     description = "Returns a list of all consoles",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A list of consoles is returned",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Consoles.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "No consoles were found with the input criteria",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occurred.",
             content = @Content(mediaType = "application/json"))
//     },
//     parameters = {
//         @Parameter(
//             name = "brand",
//             allowEmptyValue = false,
//             required = false,
//             description = "The console brand (i.e., 'Nintendo')")
     }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Consoles> getAllConsoles();
  // @formatter:on
  
  
  // @formatter:off
  @Operation(
     summary = "Create an entry for consoles",
     description = "Returns the created console",
     responses = {
         @ApiResponse(
             responseCode = "201",
             description = "The created console is returned",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Consoles.class))),
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
//     },
//     parameters = {
//         @Parameter(
//             name = "fillerParameter",
//             required = true,
//             description = "One row entry of consoles as JSON")
     }
 )
 @PostMapping
 @ResponseStatus(code = HttpStatus.CREATED)
 Consoles createConsole(@Valid @RequestBody Consoles fillerParameter);
 // @formatter:on
 
 
 // @formatter:off
 @Operation(
    summary = "Update an entry for consoles",
    description = "Returns the updated console",
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "The updated console is returned",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Consoles.class))),
        @ApiResponse(
            responseCode = "400",
            description = "The request parameters are invalid",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "A console was not found with the name input criteria",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "An unplanned error occurred.",
            content = @Content(mediaType = "application/json"))
    }
 )
 @PutMapping
 @ResponseStatus(code = HttpStatus.OK)
 Consoles updateConsole(@Valid @RequestBody Consoles fillerParameter);
 // @formatter:on


 // @formatter:off
 @Operation(
    summary = "Delete an entry from consoles",
    description = "Returns the deleted console",
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "The deleted console is returned",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Consoles.class))),
        @ApiResponse(
            responseCode = "400",
            description = "The request parameters are invalid",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "A console was not found with the name input criteria",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "An unplanned error occurred.",
            content = @Content(mediaType = "application/json"))
    },
    parameters = {
        @Parameter(
            name = "consoleName",
            allowEmptyValue = false,
            required = true,
            description = "The console_name (i.e., 'Sega Genesis')")
    }
 )
 @DeleteMapping
 @ResponseStatus(code = HttpStatus.OK)
 String deleteConsole(
     @Valid 
     @RequestParam(required = true)
     @Length(max = 25)
     @Pattern(regexp = "[\\w\\s]*")
         String consoleName);
 // @formatter:on
 
}
