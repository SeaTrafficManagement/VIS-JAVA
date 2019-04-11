package io.swagger.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

public class ApiException extends Exception {
	private static final long serialVersionUID = 1L;

	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
