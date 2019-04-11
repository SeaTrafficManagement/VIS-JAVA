package stm.vis.service;

import java.util.List;

import stm.vis.exception.AuthorizationException;
import stm.vis.model.ACLObject;
import stm.vis.model.Identity;

public interface AclService {

	ACLObject createACL(String message, List<Identity> identities);

	void checkAuthorization(Identity sourceIdentity, String messageId) throws AuthorizationException;

	List<Identity> createIdentities(List<Identity> identities);

	ACLObject getAclForMessage(String dataId);

	void removeAuthorizedIdentities(String dataId, List<Identity> identities) throws AuthorizationException;

	List<String> getAuthorizedMessages(Identity identity);
}
