package responseObjects;


/**
 * Generic response object
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class responseObj {

	/**
	 * Error text if code is 40x
	 * Transaction ID if code is 20x
	 */
	public string body;
	/**
	 * 20x if OK
	 * 40x if NOK
	 */
	public statusCode statusCode;
	public statusCode m_statusCode;

	public responseObj(){

	}

	public void finalize() throws Throwable {

	}
}//end responseObj