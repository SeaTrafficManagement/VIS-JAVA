package stm.vis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stm.vis.exception.AuthorizationException;
import stm.vis.model.ACLObject;
import stm.vis.model.Identity;
import stm.vis.repository.ACLObjectRepository;
import stm.vis.repository.IdentityRepository;
import stm.vis.service.AclService;

@Service
public class AclServiceImpl implements AclService {

	@Autowired
	private ACLObjectRepository repository;

	@Autowired
	private IdentityRepository identityRepository;

	@Override
	public ACLObject createACL(String message, List<Identity> identities) {
		ACLObject acl = this.repository.findByMessage(message);
		if (acl == null) {
			acl = new ACLObject();
			acl.setMessage(message);
		}
		for (Identity identity : identities) {
			if (!this.included(identity, acl.getIdentities())) {
				acl.getIdentities().add(identity);
			}
		}
		acl.setLastUpdateTime(new Date());
		return this.repository.save(acl);
	}

	private boolean included(Identity newIdentity, List<Identity> identities) {
		for (Identity identity : identities) {
			if (identity.getId().equals(newIdentity.getId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ACLObject getAclForMessage(String dataId) {
		return this.repository.findByMessage(dataId);
	}

	@Override
	public void checkAuthorization(Identity sourceIdentity, String message) throws AuthorizationException {
		ACLObject acl = this.repository.findByMessage(message);
		if (acl == null) {
			throw new AuthorizationException("No acl found for message " + message);
		}
		for (Identity identity : acl.getIdentities()) {
			if (identity.getId().equals(sourceIdentity.getId())) {
				return;
			}
		}
		throw new AuthorizationException("Identity " + sourceIdentity.getId() + " not authorized for message " + message);
	}

	@Override
	@Transactional
	public void removeAuthorizedIdentities(String dataId, List<Identity> identities) throws AuthorizationException {
		ACLObject acl = this.repository.findByMessage(dataId);
		for (Identity identity : identities) {
			if (!acl.getIdentities().remove(identity)) {
				throw new AuthorizationException("Identity " + identity.getId() + " was not authorized for message " + dataId);
			}
		}
	}

	@Override
	public List<Identity> createIdentities(List<Identity> identities) {
		List<Identity> savedIdentities = new ArrayList<>();
		for (Identity identity : identities) {
			savedIdentities.add(this.createIdentity(identity));
		}
		return savedIdentities;
	}

	private Identity createIdentity(Identity identity) {
		return this.identityRepository.save(identity);
	}

	@Override
	public List<String> getAuthorizedMessages(Identity identity) {
		List<ACLObject> acls = this.repository.findAllByIdentities(identity);
		return acls.stream().map(acl -> acl.getMessage()).collect(Collectors.toList());
	}

}
