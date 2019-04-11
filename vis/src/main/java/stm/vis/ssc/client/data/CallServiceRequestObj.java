package stm.vis.ssc.client.data;

import java.util.ArrayList;
import java.util.List;

public class CallServiceRequestObj {

	protected RequestType requestType;
	protected String endpointMethod;
	protected String body;
	protected List<Header> headers;

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType value) {
		this.requestType = value;
	}

	public String getEndpointMethod() {
		return endpointMethod;
	}

	public void setEndpointMethod(String value) {
		this.endpointMethod = value;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String value) {
		this.body = value;
	}

	public List<Header> getHeaders() {
		if (headers == null) {
			headers = new ArrayList<Header>();
		}
		return this.headers;
	}

}
