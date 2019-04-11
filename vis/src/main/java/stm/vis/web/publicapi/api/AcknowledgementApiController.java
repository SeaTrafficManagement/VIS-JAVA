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

import io.swagger.annotations.ApiParam;
import stm.vis.data.SourceIdentity;
import stm.vis.exception.VISException;
import stm.vis.service.AcknowledgementService;
import stm.vis.web.publicapi.model.DeliveryAck;

@javax.annotation.Generated(value = "class stm.vis.web.publicapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:19:39.094Z")

@Controller
public class AcknowledgementApiController extends BasePublicApiController implements AcknowledgementApi {

	private static final Logger log = LoggerFactory.getLogger(AcknowledgementApiController.class);

	@Autowired
	private AcknowledgementService service;

	@Override
	public ResponseEntity<Void> acknowledgement(HttpServletRequest request, 
			@ApiParam(value = "Acknowledgement", required = true) @Valid @RequestBody DeliveryAck deliveryAck) {
		SourceIdentity sourceIdentity = null;
		try {
			log.info("Acknowledgement received: " + deliveryAck.toString());
			sourceIdentity = this.getSourceIdentity(request);
			this.logEvent(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 13, 7, "", 6, deliveryAck);
			this.service.acknowledgementReceived(deliveryAck, sourceIdentity);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (VISException e) {
			log.error("Error in acknowledgement: " + e.getMessage(), e);
			if (sourceIdentity != null) {
				this.logError(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 14, 5, "", e);
			}
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
