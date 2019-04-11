package getVPResponseObject;

import STMMessage.STMMessage;

/**
 * Code 200 + <Voyage Plan in RTZ>
 * Code 20x + message="No voyage plan published"
 * Code 20x + message="Identity <requesterIdentity> is not authorized"
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:02
 */
public class getVPResponseObject {

	/**
	 * Status code (20x, 40x)
	 */
	private int code;
	/**
	 * Message e.g. error text
	 */
	private string message;
	private STMMessage STM_Message;
	/**
	 * Type of response (TBD)
	 */
	private string type;
	public STMMessage m_STMMessage;

	public getVPResponseObject(){

	}

	public void finalize() throws Throwable {

	}
}//end getVPResponseObject