package stm.vis.web.privateapi.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import stm.vis.data.FindServicesParams;
import stm.vis.data.FindServicesParams.FindServicesFilter;
import stm.vis.data.FindServicesParams.FindServicesFilter.FindServicesFilterCoverageArea;
import stm.vis.exception.VISException;
import stm.vis.service.VISPrivateInterface;
import stm.vis.ssc.client.data.SRService;
import stm.vis.ssc.client.data.SRService.ServiceDefinition;
import stm.vis.web.privateapi.model.FindServicesRequestObj;
import stm.vis.web.privateapi.model.FindServicesRequestObjFilter;
import stm.vis.web.privateapi.model.FindServicesRequestObjFilterCoverageArea;
import stm.vis.web.privateapi.model.FindServicesResponseObj;
import stm.vis.web.privateapi.model.ServiceInstance;
import stm.vis.web.privateapi.model.Xml;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

@Controller
public class FindServicesApiController implements FindServicesApi {

	private static final Logger log = LoggerFactory.getLogger(FindServicesApiController.class);

	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<FindServicesResponseObj> findServicesFindServices(
			@ApiParam(value = "Filter keywords and organizationId for service instances", required = true) @Valid @RequestBody FindServicesRequestObj findServicesObj) {
		try {
			List<SRService> services = this.service.findServices(this.toFindServicesParams(findServicesObj));
			FindServicesResponseObj response = this.toFindServiceIdentityResponse(services);
			return new ResponseEntity<FindServicesResponseObj>(response, HttpStatus.OK);
		} catch (VISException e) {
			log.error("Error in findServices: " + e.getMessage(), e);
			FindServicesResponseObj response = new  FindServicesResponseObj();
			response.setStatusCode(new Long(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setStatusMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private FindServicesParams toFindServicesParams(FindServicesRequestObj request) throws VISException {
		FindServicesParams params = new FindServicesParams();
		params.setPage(request.getPage());
		params.setPageSize(request.getPageSize());
		params.setFilter(this.toParamsFilter(request.getFilter()));
		return params;
	}

	private FindServicesFilter toParamsFilter(FindServicesRequestObjFilter request) throws VISException {
		if (request == null) {
			throw new VISException("No filter received in request body");
		}
		FindServicesFilter filter = new FindServicesFilter();
		filter.setCoverageArea(this.toParamsFilterCoverageArea(request.getCoverageArea()));
		filter.setUnLoCode(request.getUnLoCode());
		filter.setServiceProviderIds(request.getServiceProviderIds());
		filter.setServiceDesignId(request.getServiceDesignId());
		filter.setServiceInstanceId(request.getServiceInstanceId());
		filter.setMmsi(request.getMmsi());
		filter.setImo(request.getImo());
		filter.setServiceType(request.getServiceType());
		filter.setServiceStatus(request.getServiceStatus());
		filter.setKeyWords(request.getKeyWords());
		filter.setFreeText(request.getFreeText());
		return filter;
	}

	private FindServicesFilterCoverageArea toParamsFilterCoverageArea(FindServicesRequestObjFilterCoverageArea request) {
		FindServicesFilterCoverageArea coverageArea = null;
		if (request != null) {
			coverageArea = new FindServicesFilterCoverageArea();
			coverageArea.setCoverageType(request.getCoverageType());
			coverageArea.setValue(request.getValue());
		}
		return coverageArea;
	}

	private FindServicesResponseObj toFindServiceIdentityResponse(List<SRService> services) {
		FindServicesResponseObj response = new FindServicesResponseObj();
		response.setServicesInstances(this.toServiceInstanceList(services));
		response.setStatusCode((long) HttpStatus.OK.value());
		response.setStatusMessage(HttpStatus.OK.name());
		return response;
	}

	private List<ServiceInstance> toServiceInstanceList(List<SRService> services) {
		List<ServiceInstance> list = new ArrayList<>();
		for (SRService service : services) {
			list.add(this.toServiceInstanceList(service));
		}
		return list;
	}

	private ServiceInstance toServiceInstanceList(SRService service) {
		ServiceInstance instance = new ServiceInstance();
		instance.setInstanceId(service.getInstanceId());
		instance.setName(service.getName());
		instance.setOrganizationId(service.getOrganizationId());
		instance.setComment(service.getComment());
		instance.setEndpointType(service.getEndpointType());
		instance.setEndpointUri(service.getEndpointUri());
		instance.setInstanceAsXml(this.toXml(service.getInstanceAsXml()));
		instance.setKeywords(service.getKeywords());
		instance.setStatus(service.getStatus());
		instance.setUnlocode(service.getUnlocode());
		instance.setVersion(service.getVersion());
		return instance;
	}

	private Xml toXml(ServiceDefinition instanceAsXml) {
		Xml xml = new Xml();
		xml.setComment(instanceAsXml.getComment());
		xml.setContent(instanceAsXml.getContent());
		xml.setContentContentType(instanceAsXml.getContentContentType());
		xml.setName(instanceAsXml.getName());
		xml.setId(instanceAsXml.getId());
		return xml;
	}

}
