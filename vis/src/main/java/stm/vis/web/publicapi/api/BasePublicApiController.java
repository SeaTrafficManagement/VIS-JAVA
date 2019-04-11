package stm.vis.web.publicapi.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import stm.vis.data.ResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.exception.VISException;
import stm.vis.model.LogEvent;
import stm.vis.service.VISPrivateInterface;
import stm.vis.service.impl.VISInternal;
import stm.vis.ssc.client.SscHeaders;
import stm.vis.ssc.client.data.IRService;

public abstract class BasePublicApiController {

	@Value("${vis.config.component}")
	private String component;

	@Autowired
	private VISPrivateInterface privateService;

	@Autowired
	private VISInternal internalService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	protected LogEvent logEvent(String externalOrgId, String externalEntityId, int eventNumber, int eventType, String eventParameters, int eventDataType, Object data) {
		return this.log(externalOrgId, externalEntityId, eventNumber, eventType, eventParameters, eventDataType, data);
	}
	
	protected LogEvent logReturn(String externalOrgId, String externalEntityId, int eventNumber, int eventType, String eventParameters, int eventDataType, Object data) {
		return this.log(externalOrgId, externalEntityId, eventNumber, eventType, eventParameters, eventDataType, data);
	}
	
	protected LogEvent logError(String externalOrgId, String externalEntityId, int eventNumber, int eventType, String eventParameters, Exception e) {
		return this.log(externalOrgId, externalEntityId, eventNumber, eventType, eventParameters, 5, e.getMessage());
	}
	
	private LogEvent log(String externalOrgId, String externalEntityId, int eventNumber, int eventType, String eventParameters, int eventDataType, Object data) {
		String eventData = null;
		try {
			if (data != null) {
				if (data instanceof String) {
					eventData = (String) data;
				} else if (data instanceof Number) {
					eventData = data.toString();
				} else {
					eventData = this.objectMapper.writeValueAsString(data);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			eventData = "(JsonProcessingException) " + e.getMessage();
		}
		return this.internalService.logEvent(this.component, externalOrgId, externalEntityId, eventNumber, eventType, eventParameters, eventDataType, eventData);
	}

	protected SourceIdentity getSourceIdentity(HttpServletRequest request) throws VISException {
		String incomingOrganisationMrn = request.getHeader(SscHeaders.HEADER_INCOMING_ORGANIZATION_MRN);
		String incomingServiceId = request.getHeader(SscHeaders.HEADER_INCOMING_SERVICE_ID);
		String incomingCertificateType = request.getHeader(SscHeaders.HEADER_INCOMING_CERTIFICATE_TYPE);
		try {
			IRService service = this.privateService.findIdentity(incomingOrganisationMrn, incomingServiceId, incomingCertificateType);
			return this.toSourceIdentity(service);
		} catch (VISException e) {
			this.logError(incomingOrganisationMrn, incomingServiceId, 23, 3, this.getSourceIdentityLogParams(incomingOrganisationMrn, incomingServiceId, incomingCertificateType), e);
			throw e;
		}
	}
	
	private String getSourceIdentityLogParams(String incomingOrganisationMrn, String incomingServiceId, String incomingCertificateType) {
		return "incomingOrganisationMrn=" + incomingOrganisationMrn + ", incomingServiceId=" + incomingServiceId + ", incomingCertificateType=" + incomingCertificateType;
	}

	protected SourceIdentity toSourceIdentity(IRService service) {
		SourceIdentity identity = null;
		if (service != null) {
			identity = new SourceIdentity();
			identity.setServiceId(service.getMrn());
			identity.setServiceName(service.getName());
			identity.setOrganisationMrn(service.getOwner().getMrn());
			identity.setOrganisationName(service.getOwner().getName());
		}
		return identity;
	}

	protected ResponseEntity<Void> createResponseEntity(ResponseObject response) {
		HttpStatus status;
		switch (response.getStatusCode()) {
			case OK:
				status = HttpStatus.OK;
				break;
			case NOT_AUTHORIZED:
				status = HttpStatus.UNAUTHORIZED;
				break;
			case ERROR:
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				break;
			default:
				status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(status);
	}

}
