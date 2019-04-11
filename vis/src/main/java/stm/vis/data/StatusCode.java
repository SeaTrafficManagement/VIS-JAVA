package stm.vis.data;

public enum StatusCode {
	OK("200"), ERROR("400"), NOT_AUTHORIZED("403"), NOT_FOUND("404"), SCHEMA_OK("210"), SCHEMA_NOK("410"), DATAID_NOK("411"), VP_NOT_FOUND("412"), INTERNAL_SERVER_ERROR("500");

	private String code;

	private StatusCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public static StatusCode fromCode(String code) {
		for (StatusCode statusCode : StatusCode.values()) {
			if (statusCode.getCode().equals(code)) {
				return statusCode;
			}
		}
		return null;
	}

}
