package stm.vis.ssc.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import stm.vis.data.FindServicesParams;
import stm.vis.data.FindServicesParams.FindServicesFilter;
import stm.vis.data.FindServicesParams.FindServicesFilter.FindServicesFilterCoverageArea;
import stm.vis.data.VISRequestType;
import stm.vis.ssc.client.data.CallServiceRequestObj;
import stm.vis.ssc.client.data.FindServicesRequestObj;
import stm.vis.ssc.client.data.FindServicesRequestObjFilter;
import stm.vis.ssc.client.data.FindServicesRequestObjFilterCoverageArea;
import stm.vis.ssc.client.data.Header;
import stm.vis.ssc.client.data.IRService;
import stm.vis.ssc.client.data.IdentityRegistryGeneralRequestObj;
import stm.vis.ssc.client.data.VISOrganization;
import stm.vis.ssc.client.data.VISOrganizationContent;
import stm.vis.ssc.client.data.Xml;
import stm.vis.ssc.client.data.RequestType;
import stm.vis.ssc.client.data.SRService;
import stm.vis.ssc.client.data.SRService.ServiceDefinition;
import stm.vis.ssc.client.data.ServiceInstance;
import stm.vis.ssc.client.data.ServiceRegistryGeneralRequestObj;

@Component
public class ConvertUtil {

	public CallServiceRequestObj createCallServiceRequest(VISRequestType requestType, String targetUrl, Map<String, String> headersMap, String body) {
		CallServiceRequestObj request = new CallServiceRequestObj();
		request.setRequestType(RequestType.fromValue(requestType.value()));
		request.setEndpointMethod(targetUrl);
//		try {
//			request.setEndpointMethod(URLEncoder.encode(targetUrl, "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			// Continue with non-encoded string
//			request.setEndpointMethod(targetUrl);
//		}

		this.fillHeaders(headersMap, request.getHeaders());
		request.setBody(body);
		return request;
	}

	public IdentityRegistryGeneralRequestObj createIdentityRegistryGeneralRequest(VISRequestType requestType, String requestUrl, Map<String, String> headersMap, String body) {
		IdentityRegistryGeneralRequestObj request = new IdentityRegistryGeneralRequestObj();
		request.setRequestType(RequestType.fromValue(requestType.value()));
		request.setUrl(requestUrl);
		this.fillHeaders(headersMap, request.getHeaders());
		request.setBody(body);
		return request;
	}

	public ServiceRegistryGeneralRequestObj createServiceRegistryGeneralRequest(VISRequestType requestType, String requestUrl, Map<String, String> headersMap, String body) {
		ServiceRegistryGeneralRequestObj request = new ServiceRegistryGeneralRequestObj();
		request.setRequestType(RequestType.fromValue(requestType.value()));
		request.setUrl(requestUrl);
		this.fillHeaders(headersMap, request.getHeaders());
		request.setBody(body);
		return request;
	}

	private void fillHeaders(Map<String, String> headersMap, List<Header> headers) {
		if (!CollectionUtils.isEmpty(headersMap)) {
			for (Entry<String, String> entry : headersMap.entrySet()) {
				Header header = new Header();
				header.setKey(entry.getKey());
				header.setValue(entry.getValue());
				headers.add(header);
			}
		}
	}

	public List<SRService> toSRServiceList(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<SRService> list = mapper.readValue(json, new TypeReference<List<SRService>>() {
		});
		return list;
	}

	public IRService toIRService(String json, VISOrganization organization) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		IRService service = mapper.readValue(json, IRService.class);
		service.setOwner(organization);
		return service;
	}

	public List<VISOrganization> toOrganizationList(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		VISOrganizationContent content = mapper.readValue(json, VISOrganizationContent.class);
//		List<VISOrganization> list = mapper.readValue(json, new TypeReference<List<VISOrganization>>() {
//		});
		return content.getContent();
	}

	public VISOrganization toOrganization(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(json, VISOrganization.class);
	}

	public FindServicesRequestObj toFindServicesRequestObj(FindServicesParams params) {
		return new FindServicesRequestObj()
				.page(params.getPage())
				.pageSize(params.getPageSize())
				.filter(this.toFindServicesRequestObjFilter(params.getFilter()));
	}

	private FindServicesRequestObjFilter toFindServicesRequestObjFilter(FindServicesFilter filter) {
		return new FindServicesRequestObjFilter()
				.coverageArea(this.toCoverageArea(filter.getCoverageArea()))
				.unLoCode(filter.getUnLoCode())
				.serviceProviderIds(filter.getServiceProviderIds())
				.serviceDesignId(filter.getServiceDesignId())
				.serviceInstanceId(filter.getServiceInstanceId())
				.mmsi(filter.getMmsi())
				.imo(filter.getImo())
				.serviceType(filter.getServiceType())
				.serviceStatus(filter.getServiceStatus())
				.keyWords(filter.getKeyWords())
				.freeText(filter.getFreeText());
	}

	private FindServicesRequestObjFilterCoverageArea toCoverageArea(FindServicesFilterCoverageArea coverageArea) {
		if (coverageArea == null) {
			return null;
		}
		return new FindServicesRequestObjFilterCoverageArea()
				.coverageType(coverageArea.getCoverageType())
				.value(coverageArea.getValue());
	}

	public List<SRService> toSRServiceList(List<ServiceInstance> servicesInstances) {
		if (servicesInstances == null) {
			return null;
		}
		
		List<SRService> list = new ArrayList<>();
		for (ServiceInstance serviceInstance : servicesInstances) {
			list.add(this.toSRService(serviceInstance));
		}
		
		return list;
	}

	private SRService toSRService(ServiceInstance serviceInstance) {
		SRService service = new SRService();
		service.setComment(serviceInstance.getComment());
		service.setEndpointType(serviceInstance.getEndpointType());
		service.setEndpointUri(serviceInstance.getEndpointUri());
		service.setInstanceAsXml(this.toServiceDefinition(serviceInstance.getInstanceAsXml()));
		service.setInstanceId(serviceInstance.getInstanceId());
		service.setKeywords(serviceInstance.getKeywords());
		service.setName(serviceInstance.getName());
		service.setOrganizationId(serviceInstance.getOrganizationId());
		service.setStatus(serviceInstance.getStatus());
		service.setUnlocode(serviceInstance.getUnlocode());
		service.setVersion(serviceInstance.getVersion());
		return service;
	}

	private ServiceDefinition toServiceDefinition(Xml instanceAsXml) {
		ServiceDefinition def = new ServiceDefinition();
		def.setComment(instanceAsXml.getComment());
		def.setContent(instanceAsXml.getContent());
		def.setContentContentType(instanceAsXml.getContentContentType());
		def.setId(instanceAsXml.getId());
		def.setName(instanceAsXml.getName());
		return def;
	}

}
