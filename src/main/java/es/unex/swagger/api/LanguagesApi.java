/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.62).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package es.unex.swagger.api;


import es.unex.swagger.model.Language;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-18T10:29:32.211856553Z[GMT]")
@Validated
public interface LanguagesApi {

    @Operation(summary = "Elimina el idioma por su id", description = "Elimina el idioma dado su id en el endpoint.", security = {
        @SecurityRequirement(name = "cookieAuth"),
@SecurityRequirement(name = "medifli_auth", scopes = {
            "write:users",
"read:users"        })    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación exitosa.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Language.class))),
        
        @ApiResponse(responseCode = "400", description = "Valor no soportado"),
        
        @ApiResponse(responseCode = "404", description = "Idioma no encontrado") })
    @RequestMapping(value = "/languages/{idLanguage}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Language> deleteLanguageById(@Parameter(in = ParameterIn.PATH, description = "El id del idioma que se desea buscar.", required=true, schema=@Schema()) @PathVariable("idLanguage") Integer idLanguage
);


    @Operation(summary = "Devuelve todos los idiomas", description = "Devuelve la lista de todos los idiomas del sistema.", security = {
        @SecurityRequirement(name = "cookieAuth"),
@SecurityRequirement(name = "medifli_auth", scopes = {
            "write:users",
"read:users"        })    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Language.class)))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "404", description = "Language not found") })
    @RequestMapping(value = "/languages",
        produces = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Language>> getAllLanguages();


    @Operation(summary = "Devuelve el idioma por su id", description = "Devuelve toda la información del idioma, dado su id", security = {
        @SecurityRequirement(name = "cookieAuth"),
@SecurityRequirement(name = "medifli_auth", scopes = {
            "write:users",
"read:users"        })    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación exitosa.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Language.class))),
        
        @ApiResponse(responseCode = "400", description = "Valor no soportado"),
        
        @ApiResponse(responseCode = "404", description = "Idioma no encontrado") })
    @RequestMapping(value = "/languages/{idLanguage}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<Language> getLanguageById(@Parameter(in = ParameterIn.PATH, description = "El id del idioma que se desea buscar.", required=true, schema=@Schema()) @PathVariable("idLanguage") Integer idLanguage
);


    @Operation(summary = "Añade un nuevo idioma a la base de datos.", description = "Añade un nuevo idioma a la base de datos, recibiendo toda su información en el cuerpo de la petición.", security = {
        @SecurityRequirement(name = "medifli_auth", scopes = {
            "write:users",
"read:users"        })    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Operación exitosa, idioma añadido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Language.class))),
        
        @ApiResponse(responseCode = "400", description = "Valor no soportado"),
        
        @ApiResponse(responseCode = "404", description = "Idioma no encontrado"),
        
        @ApiResponse(responseCode = "422", description = "Excepción de validación") })
    @RequestMapping(value = "/languages",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.POST)
    ResponseEntity<Language> postLanguage(@Parameter(in = ParameterIn.DEFAULT, description = "Add a new kind of language in the database", required=true, schema=@Schema()) @Valid @RequestBody Language body
);


    @Operation(summary = "Actualiza la información del idioma por su id", description = "Actualiza la información del idioma dado su id en el endpoint.", security = {
        @SecurityRequirement(name = "cookieAuth"),
@SecurityRequirement(name = "medifli_auth", scopes = {
            "write:users",
"read:users"        })    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación exitosa.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Language.class))),
        
        @ApiResponse(responseCode = "400", description = "Valor no soportado"),
        
        @ApiResponse(responseCode = "404", description = "Idioma no encontrado") })
    @RequestMapping(value = "/languages/{idLanguage}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Language> putLanguageById(@Parameter(in = ParameterIn.PATH, description = "El id del idioma que se desea buscar.", required=true, schema=@Schema()) @PathVariable("idLanguage") Integer idLanguage
);

}
