package stm.vis.web.privateapi.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import stm.vis.data.ResponseObject;
import stm.vis.model.Identity;
import stm.vis.service.VISPrivateInterface;
import stm.vis.web.privateapi.model.IdentityDescriptionObject;
import stm.vis.web.privateapi.model.ResponseObj;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

@Controller
public class AuthorizeIdentitiesApiController implements AuthorizeIdentitiesApi {

	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<List<IdentityDescriptionObject>> findAuthorizedIdentities(
			@NotNull @ApiParam(value = "Data id usually an uvid", required = true) @RequestParam(value = "dataId", required = true) String dataId) {
		List<Identity> identities = this.service.findAuthorizedIdentities(dataId);
		return this.createResponseEntity(identities, dataId);
	}

	@Override
	public ResponseEntity<ResponseObj> authorizeIdentities(
			@NotNull @ApiParam(value = "Data id usually an UVID", required = true) @RequestParam(value = "dataId", required = true) String dataId,
			@ApiParam(value = "Attributes to describe an organization in STM", required = true) @Valid @RequestBody List<IdentityDescriptionObject> identityDescriptionObjects) {
		try {
			ResponseObject response = this.service.authorizeIdentities(this.toIdentitiesList(identityDescriptionObjects), dataId);
			return this.createResponseEntity(response, dataId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return this.createResponseEntity(ex, dataId);
		}
	}

	@Override
	public ResponseEntity<ResponseObj> authorizeIdentitiesRemoveAuthorizedIdentitites(
			@NotNull @ApiParam(value = "Data id usually an uvid", required = true) @RequestParam(value = "dataId", required = true) String dataId,
			@ApiParam(value = "Attributes to describe an organization in STM", required = true) @Valid @RequestBody List<IdentityDescriptionObject> identityDescriptionObjects) {
		ResponseObject response = this.service.removeAuthorizedIdentitites(this.toIdentitiesList(identityDescriptionObjects), dataId);
		return this.createResponseEntity(response, dataId);
	}

	private ResponseEntity<ResponseObj> createResponseEntity(ResponseObject response, String dataId) {
		ResponseObj obj = new ResponseObj();
		obj.setDataId(dataId);
		HttpStatus status;
		switch (response.getStatusCode()) {
			case OK:
				obj.setDataId(response.getBody());
				status = HttpStatus.OK;
				break;
			case NOT_AUTHORIZED:
				status = HttpStatus.UNAUTHORIZED;
				break;
			default:
				status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<ResponseObj>(obj, status);
	}

	private ResponseEntity<ResponseObj> createResponseEntity(Exception ex, String dataId) {
		ResponseObj obj = new ResponseObj();
		obj.setDataId(dataId);
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<ResponseObj>(obj, status);
	}

	private ResponseEntity<List<IdentityDescriptionObject>> createResponseEntity(List<Identity> identities, String dataId) {
		List<IdentityDescriptionObject> list = new ArrayList<>();
		for (Identity identity : identities) {
			list.add(this.toIdentityDescriptionObject(identity));
		}

		return new ResponseEntity<List<IdentityDescriptionObject>>(list, HttpStatus.OK);
	}

	private List<Identity> toIdentitiesList(List<IdentityDescriptionObject> identityDescriptionObjects) {
		List<Identity> list = new ArrayList<>();
		if (!CollectionUtils.isEmpty(identityDescriptionObjects)) {
			for (IdentityDescriptionObject object : identityDescriptionObjects) {
				list.add(this.toIdentity(object));
			}
		}
		return list;
	}

	private Identity toIdentity(IdentityDescriptionObject object) {
		Identity identity = new Identity();
		identity.setId(object.getIdentityId());
		identity.setName(object.getIdentityName());
		return identity;
	}

	private IdentityDescriptionObject toIdentityDescriptionObject(Identity identity) {
		IdentityDescriptionObject object = new IdentityDescriptionObject();
		object.setIdentityId(identity.getId());
		object.setIdentityName(identity.getName());
		return object;
	}

}
