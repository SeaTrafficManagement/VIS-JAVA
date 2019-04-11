package ACL;

import STMTypes.URN;
import messageObjects.messageObject;

/**
 * ACL objects for each information/data object.
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:01
 */
public class ACLObject {

	/**
	 * Reference to data related to the ACL object
	 */
	private URN dataId;
	/**
	 * Identity of the ACL object
	 */
	private string id;
	/**
	 * Identities that have access to the information object
	 */
	private URN identity;
	/**
	 * Time of last update
	 */
	private dateTime lastUpdateTime;

	public ACLObject(){

	}

	public void finalize() throws Throwable {

	}
}//end ACLObject