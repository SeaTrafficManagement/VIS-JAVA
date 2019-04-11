package stm.vis.web.privateapi.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import stm.vis.data.ResponseObject;
import stm.vis.data.VISRequestType;
import stm.vis.exception.VISException;
import stm.vis.service.VISPrivateInterface;
import stm.vis.web.privateapi.model.CallServiceRequestObj;
import stm.vis.web.privateapi.model.CallServiceResponseObj;
import stm.vis.web.privateapi.model.Header;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

@Controller
public class CallServiceApiController implements CallServiceApi {

	private static final Logger log = LoggerFactory.getLogger(FindServicesApiController.class);

	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<CallServiceResponseObj> callServiceCallService(
			@ApiParam(value = "", required = true) @Valid @RequestBody CallServiceRequestObj callServiceObj) {
		VISRequestType requestType = VISRequestType.fromValue(callServiceObj.getRequestType());
		String url = callServiceObj.getEndpointMethod();
		Map<String, String> headers = this.toHeadersMap(callServiceObj.getHeaders());
		String body = callServiceObj.getBody();

		try {
			ResponseObject response = this.service.callService(requestType, url, headers, body);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in callService: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Map<String, String> toHeadersMap(List<Header> headers) {
		Map<String, String> map = new LinkedHashMap<>();
		for (Header header : headers) {
			map.put(header.getKey(), header.getValue());
		}
		return map;
	}

	private ResponseEntity<CallServiceResponseObj> createResponseEntity(ResponseObject response) {
		CallServiceResponseObj callServiceResponse = new CallServiceResponseObj();
		callServiceResponse.setBody(response.getBody());
		callServiceResponse.setStatusCode(Long.parseLong(response.getStatusCode().getCode()));
		return new ResponseEntity<CallServiceResponseObj>(callServiceResponse, HttpStatus.OK);
	}

}
