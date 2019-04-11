package stm.vis.web.publicapi.api;

@javax.annotation.Generated(value = "class stm.vis.web.publicapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:19:39.094Z")

public class NotFoundException extends ApiException {
	private int code;

	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
