package stm.vis.web.privateapi.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import stm.vis.web.privateapi.model.FindIdentitiesResponseObj;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-10T10:34:20.466Z")

@Api(value = "findIdentities", description = "the findIdentities API")
public interface FindIdentitiesApi {

    @ApiOperation(value = "", notes = "Seacrh for identities in STM identity registry", response = FindIdentitiesResponseObj.class, responseContainer = "List", tags={ "FindIdentities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = FindIdentitiesResponseObj.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized (the user cannot be auhtenticated in the Identity Registry)", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden (the user is not authorized to requested organization)", response = Void.class),
        @ApiResponse(code = 404, message = "Not Found (the requested identity is not found)", response = Void.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Void.class) })
    
    @RequestMapping(value = "/privateapi/findIdentities",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<FindIdentitiesResponseObj>> findIdentities();

}
