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
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.STMMessage;
import stm.vis.exception.VISException;
import stm.vis.service.VISUploadInterface;

@javax.annotation.Generated(value = "class stm.vis.web.publicapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:19:39.094Z")

@Controller
public class AreaApiController extends BasePublicApiController implements AreaApi {

	private static final Logger log = LoggerFactory.getLogger(AreaApiController.class);

	@Autowired
	private VISUploadInterface uploadService;

	@Override
	public ResponseEntity<Void> uploadArea(HttpServletRequest request,
			@ApiParam(value = "Area message in S124 v0.0.7", required = true) @Valid @RequestBody String area,
			@ApiParam(value = "Acknowledgement expected. Base URL for VIS as in Service Registry. An ACK is expected to this URL when the receiving private application retrieve the message") @RequestParam(value = "deliveryAckEndPoint", required = false) String deliveryAckEndPoint) {
		SourceIdentity sourceIdentity = null;
		try {
			sourceIdentity = this.getSourceIdentity(request);
			this.logEvent(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 7, 7, this.getUploadAreaLogParameters(deliveryAckEndPoint), 4, area);
			STMMessage polygon = this.convert(area);
			ResponseObject response = this.uploadService.uploadArea(sourceIdentity, polygon, deliveryAckEndPoint);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in uploadArea: " + e.getMessage(), e);
			if (sourceIdentity != null) {
				this.logError(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 8, 5, this.getUploadAreaLogParameters(deliveryAckEndPoint), e);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private String getUploadAreaLogParameters(String deliveryAckEndPoint) {
		return "deliveryAckEndPoint=" + deliveryAckEndPoint;
	}

	private STMMessage convert(String area) {
		STMMessage polygon = new STMMessage();
		polygon.setMessageType(MessageType.S124);
		polygon.setData(area.getBytes());
		return polygon;
	}

}
