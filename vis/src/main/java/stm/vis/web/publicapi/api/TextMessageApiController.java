package stm.vis.web.publicapi.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import stm.vis.data.ResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.exception.VISException;
import stm.vis.service.VISUploadInterface;

@javax.annotation.Generated(value = "class stm.vis.web.publicapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:19:39.094Z")

@Controller
public class TextMessageApiController extends BasePublicApiController implements TextMessageApi {

	private static final Logger log = LoggerFactory.getLogger(TextMessageApiController.class);

	@Autowired
	private VISUploadInterface uploadService;

	@Override
	public ResponseEntity<Void> uploadTextMessage(HttpServletRequest request,
			@ApiParam(value = "STM Text message v1.3", required = true) @Valid @RequestBody String textMessageObject,
			@ApiParam(value = "Acknowledgement expected. Base URL for VIS as in Service Registry. An ACK is expected to this URL when the receiving private application retrieve the message") @RequestParam(value = "deliveryAckEndPoint", required = false) String deliveryAckEndPoint) {
		SourceIdentity sourceIdentity = null;
		try {
			sourceIdentity = this.getSourceIdentity(request);
			this.logEvent(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 5, 7, this.getUploadTextMessageLogParameters(deliveryAckEndPoint), 2, textMessageObject);
			ResponseObject response = this.uploadService.uploadTextMessage(sourceIdentity, textMessageObject, deliveryAckEndPoint);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in uploadTextMessage: " + e.getMessage(), e);
			if (sourceIdentity != null) {
				this.logError(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 6, 5, this.getUploadTextMessageLogParameters(deliveryAckEndPoint), e);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private String getUploadTextMessageLogParameters(String deliveryAckEndPoint) {
		return "deliveryAckEndPoint=" + deliveryAckEndPoint;
	}

}
