package stm.vis.ssc.client;

import java.util.List;
import java.util.Map;

import stm.vis.data.FindServicesParams;
import stm.vis.data.VISRequestType;
import stm.vis.data.ResponseObject;
import stm.vis.exception.VISException;
import stm.vis.ssc.client.data.IRService;
import stm.vis.ssc.client.data.VISOrganization;
import stm.vis.ssc.client.data.SRService;

/**
 * Helper for the {@link SscClient}. Used to ease the communcation with the seaswim connector.
 * @author aheredia
 *
 */
public interface SscClientHelper {

	List<VISOrganization> findOrganizations() throws VISException;

	VISOrganization findOrganization(String organisationMrn) throws VISException;

	IRService findIdentity(String organisationMrn, String serviceMrn, String type) throws VISException;

	List<SRService> findServices(FindServicesParams params) throws VISException;

	ResponseObject callService(VISRequestType requestType, String targetUrl, Map<String, String> headersMap, String body) throws VISException;

	ResponseObject callIdentityRegistryRequest(VISRequestType requestType, String requestUrl, Map<String, String> headersMap, String body) throws VISException;

	ResponseObject callServiceRegistryRequest(VISRequestType requestType, String requestUrl, Map<String, String> headersMap, String body) throws VISException;

}
