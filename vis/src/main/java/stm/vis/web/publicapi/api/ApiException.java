package stm.vis.web.publicapi.api;

@javax.annotation.Generated(value = "class stm.vis.web.publicapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:19:39.094Z")

public class ApiException extends Exception {
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
