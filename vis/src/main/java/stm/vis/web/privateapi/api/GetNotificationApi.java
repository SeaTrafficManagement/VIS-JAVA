package stm.vis.web.privateapi.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import stm.vis.web.privateapi.model.Notification;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-10T12:58:37.496Z")

@Api(value = "getNotification", description = "the getNotification API")
public interface GetNotificationApi {

	@ApiOperation(value = "", notes = "Get all awaiting notifications", response = Notification.class, responseContainer = "List", tags = {
			"Notification", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Notification.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized (the user cannot be auhtenticated", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/getNotification", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Notification>> getNotification();

}
