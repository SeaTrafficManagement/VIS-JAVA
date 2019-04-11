package stm.vis.ssc.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.support.RestGatewaySupport;

import stm.vis.data.FindServicesParams;
import stm.vis.data.ResponseObject;
import stm.vis.data.StatusCode;
import stm.vis.data.VISRequestType;
import stm.vis.exception.VISException;
import stm.vis.ssc.client.data.CallServiceRequestObj;
import stm.vis.ssc.client.data.CallServiceResponseObj;
import stm.vis.ssc.client.data.FindIdentitiesResponseObj;
import stm.vis.ssc.client.data.FindServicesRequestObj;
import stm.vis.ssc.client.data.FindServicesResponseObj;
import stm.vis.ssc.client.data.IRService;
import stm.vis.ssc.client.data.IdentityRegistryGeneralRequestObj;
import stm.vis.ssc.client.data.IdentityRegistryGeneralResponseObj;
import stm.vis.ssc.client.data.SRService;
import stm.vis.ssc.client.data.ServiceRegistryGeneralRequestObj;
import stm.vis.ssc.client.data.ServiceRegistryGeneralResponseObj;
import stm.vis.ssc.client.data.VISOrganization;

@Component
public class SscClientRestHelper extends RestGatewaySupport implements SscClientHelper {

	private static final Logger log = LoggerFactory.getLogger(SscClientRestHelper.class);

	@Value("${vis.config.ssc.endpoint}")
	private String sscEndpoint;

	@Autowired
	private ConvertUtil converter;

	@Autowired
	public SscClientRestHelper(ClientHttpRequestFactory requestFactory) {
		super(requestFactory);
	}

	@Override
	public ResponseObject callService(VISRequestType requestType, String targetUrl, Map<String, String> headersMap, String body) throws VISException {
		log.info("Sending REST callService request to SSC...");
		String url = String.format("%s/ssc/callService", this.sscEndpoint);
		log.info("- URL: POST " + url);

		CallServiceRequestObj request = this.converter.createCallServiceRequest(requestType, targetUrl, headersMap, body);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CallServiceRequestObj> entity = new HttpEntity<CallServiceRequestObj>(request, headers);

		ResponseEntity<CallServiceResponseObj> response = this.getRestTemplate().exchange(url, HttpMethod.POST, entity, CallServiceResponseObj.class);
		log.info(String.format("[callServiceREST] Received response: [%s] %s", response.getBody().getStatusCode().toString(), response.getBody().getBody()));

		ResponseObject result = new ResponseObject();
		result.setStatusCode(StatusCode.fromCode(response.getBody().getStatusCode().toString()));
		result.setBody(response.getBody().getBody());
		return result;
	}

	@Override
	public List<VISOrganization> findOrganizations() throws VISException {
		ResponseObject response = this.callFindIdentities();
		if (response.getStatusCode() != StatusCode.OK) {
			throw new VISException("Error in findOrganizations - " + response.getBody());
		}
		try {
			return this.converter.toOrganizationList(response.getBody());
		} catch (IOException e) {
			throw new VISException("Unable to convert message to List<Organization>: " + response, e);
		}
	}

	private ResponseObject callFindIdentities() {
		log.info("Sending REST FindIdentities request to SSC...");
		String url = String.format("%s/ssc/findIdentities", this.sscEndpoint);
		log.info("- GET " + url);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("", headers);

		ResponseEntity<FindIdentitiesResponseObj> response = this.getRestTemplate().exchange(url, HttpMethod.GET, entity, FindIdentitiesResponseObj.class);
		log.info(String.format("[FindIdentities] Received response: [%s] %s", response.getBody().getStatusCode().toString(), response.getBody().getBody()));

		ResponseObject result = new ResponseObject();
		result.setStatusCode(StatusCode.fromCode(response.getBody().getStatusCode().toString()));
		result.setBody(response.getBody().getBody());
		return result;
	}

	@Override
	public VISOrganization findOrganization(String organisationMrn) throws VISException {
		ResponseObject response = this.callIdentityRegistryRequest(VISRequestType.GET, String.format("/org/%s", organisationMrn), null, null);
		if (response.getStatusCode() != StatusCode.OK) {
			throw new VISException("Error in findOrganization - " + response.getBody());
		}
		try {
			return this.converter.toOrganization(response.getBody());
		} catch (IOException e) {
			throw new VISException("Unable to convert message to Organization: " + response, e);
		}
	}

	@Override
	public IRService findIdentity(String organisationMrn, String serviceMrn, String type) throws VISException {
		VISOrganization organization = this.findOrganization(organisationMrn);
		ResponseObject response = this.callIdentityRegistryRequest(VISRequestType.GET, String.format("/org/%s/%s/%s", organisationMrn, type, serviceMrn), null, null);
		if (response.getStatusCode() != StatusCode.OK) {
			throw new VISException("Error in findIdentity - " + response.getBody());
		}
		try {
			return this.converter.toIRService(response.getBody(), organization);
		} catch (IOException e) {
			throw new VISException("Unable to convert message to IRService: " + response, e);
		}
	}

	@Override
	public List<SRService> findServices(FindServicesParams params) throws VISException {
		log.info("Sending REST FindServices request to SSC...");
		String url = String.format("%s/ssc/findServices", this.sscEndpoint);
		log.info("- URL: POST " + url);
		
		FindServicesRequestObj request = this.converter.toFindServicesRequestObj(params);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<FindServicesRequestObj> entity = new HttpEntity<FindServicesRequestObj>(request, headers);
		
		ResponseEntity<FindServicesResponseObj> response = this.getRestTemplate().exchange(url, HttpMethod.POST, entity, FindServicesResponseObj.class);
		log.info(String.format("[FindServices] Received response: [%s] %s", response.getBody().getStatusCode().toString(), response.getBody().getStatusMessage()));
		
		if (StatusCode.fromCode(response.getBody().getStatusCode().toString()) != StatusCode.OK) {
			throw new VISException("Error in findServices - " + response.getBody());
		}
		return this.converter.toSRServiceList(response.getBody().getServicesInstances());
	}

	@Override
	public ResponseObject callIdentityRegistryRequest(VISRequestType requestType, String requestUrl, Map<String, String> headersMap, String body) throws VISException {
		log.info("Sending REST IdentityServiceRequest request to SSC...");
		String url = String.format("%s/ssc/identityRegistryGeneral", this.sscEndpoint);
		log.info("- URL: POST " + url + ": " + requestUrl);

		IdentityRegistryGeneralRequestObj request = this.converter.createIdentityRegistryGeneralRequest(requestType, requestUrl, headersMap, body);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<IdentityRegistryGeneralRequestObj> entity = new HttpEntity<IdentityRegistryGeneralRequestObj>(request, headers);

		ResponseEntity<IdentityRegistryGeneralResponseObj> response = this.getRestTemplate().exchange(url, HttpMethod.POST, entity, IdentityRegistryGeneralResponseObj.class);
		log.info(String.format("[IdentityRegistryGeneralRequest] Received response: [%s] %s", response.getBody().getStatusCode().toString(), response.getBody().getBody()));

		ResponseObject result = new ResponseObject();
		result.setStatusCode(StatusCode.fromCode(response.getBody().getStatusCode().toString()));
		result.setBody(response.getBody().getBody());
		return result;
	}

	@Override
	public ResponseObject callServiceRegistryRequest(VISRequestType requestType, String requestUrl, Map<String, String> headersMap, String body) throws VISException {
		log.info("Sending REST RegistryServiceRequest request to SSC...");
		String url = String.format("%s/ssc/serviceRegistryGeneral", this.sscEndpoint);
		log.info("- URL: POST " + url);

		ServiceRegistryGeneralRequestObj request = this.converter.createServiceRegistryGeneralRequest(requestType, requestUrl, headersMap, body);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ServiceRegistryGeneralRequestObj> entity = new HttpEntity<ServiceRegistryGeneralRequestObj>(request, headers);

		ResponseEntity<ServiceRegistryGeneralResponseObj> response = this.getRestTemplate().exchange(url, HttpMethod.POST, entity, ServiceRegistryGeneralResponseObj.class);
		log.info(String.format("[ServiceRegistryGeneralRequest] Received response: [%s] %s", response.getBody().getStatusCode().toString(), response.getBody().getBody()));

		ResponseObject result = new ResponseObject();
		result.setStatusCode(StatusCode.fromCode(response.getBody().getStatusCode().toString()));
		result.setBody(response.getBody().getBody());
		return result;
	}

}
