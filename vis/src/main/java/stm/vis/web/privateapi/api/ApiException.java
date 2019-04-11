package stm.vis.web.privateapi.api;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

public class ApiException extends Exception {
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
