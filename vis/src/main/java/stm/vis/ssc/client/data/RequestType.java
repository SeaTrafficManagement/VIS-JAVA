package stm.vis.ssc.client.data;

public enum RequestType {

	GET, POST, DELETE, PATCH;

	public String value() {
		return name();
	}

	public static RequestType fromValue(String v) {
		return valueOf(v);
	}

}
