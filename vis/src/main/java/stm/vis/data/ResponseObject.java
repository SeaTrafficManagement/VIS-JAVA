package stm.vis.data;

/**
 * Generic response object
 * @author aheredia
 *
 */
public class ResponseObject {

	/**
	 * 20x if OK
	 * 40x if NOK
	 */
	private StatusCode statusCode;

	/**
	 * Error text if code is 40x
	 * Transaction ID if code is 20x
	 */
	private String body;

	public StatusCode getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
