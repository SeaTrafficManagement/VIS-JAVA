package stm.vis.data;

import java.net.URI;

public class SubscriptionObject {

	private URI callbackEndpoint;
	private String uvid;

	public URI getCallbackEndpoint() {
		return this.callbackEndpoint;
	}

	public void setCallbackEndpoint(URI callbackEndpoint) {
		this.callbackEndpoint = callbackEndpoint;
	}

	public String getUvid() {
		return this.uvid;
	}

	public void setUvid(String uvid) {
		this.uvid = uvid;
	}

}
