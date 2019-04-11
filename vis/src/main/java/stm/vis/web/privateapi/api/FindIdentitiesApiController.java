package stm.vis.web.privateapi.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import stm.vis.exception.VISException;
import stm.vis.service.VISPrivateInterface;
import stm.vis.ssc.client.data.VISOrganization;
import stm.vis.web.privateapi.model.FindIdentitiesResponseObj;
import stm.vis.web.privateapi.model.Organization;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-10T10:34:20.466Z")

@Controller
public class FindIdentitiesApiController implements FindIdentitiesApi {

	private static final Logger log = LoggerFactory.getLogger(FindIdentitiesApiController.class);

	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<List<FindIdentitiesResponseObj>> findIdentities() {
		try {
			List<VISOrganization> organizations = this.service.findIdentities();
			// FIXME [change API] response should not be a LIST
			return new ResponseEntity<List<FindIdentitiesResponseObj>>(Collections.singletonList(this.toFindOrganizationsResponse(organizations)), HttpStatus.OK);
		} catch (VISException e) {
			log.error("Error in findIdentities: " + e.getMessage(), e);
			return new ResponseEntity<List<FindIdentitiesResponseObj>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private FindIdentitiesResponseObj toFindOrganizationsResponse(List<VISOrganization> organizations) {
		FindIdentitiesResponseObj response = new FindIdentitiesResponseObj();
		response.setOrganizations(this.toModelOrganization(organizations));
		response.setStatusCode((long) HttpStatus.OK.value());
		response.setStatusMessage(HttpStatus.OK.name());
		return response;
	}

	private List<Organization> toModelOrganization(List<VISOrganization> organizations) {
		List<Organization> list = new ArrayList<>();
		for (VISOrganization organization : organizations) {
			list.add(this.toModelOrganization(organization));
		}
		return list;
	}

	private stm.vis.web.privateapi.model.Organization toModelOrganization(VISOrganization organization) {
		Organization model = new Organization();
		model.setCountry(organization.getCountry());
		model.setEmail(organization.getEmail());
		model.setMrn(organization.getMrn());
		model.setName(organization.getName());
		return model;
	}

}
