package io.swagger.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ErrorModel
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

public class ErrorModel {
	private Long errorModelId = null;

	private Integer code = null;

	private String message = null;

	public ErrorModel errorModelId(Long errorModelId) {
		this.errorModelId = errorModelId;
		return this;
	}

	/**
	* Get errorModelId
	* @return errorModelId
	**/
	@ApiModelProperty(required = true, value = "")
	public Long getErrorModelId() {
		return errorModelId;
	}

	public void setErrorModelId(Long errorModelId) {
		this.errorModelId = errorModelId;
	}

	public ErrorModel code(Integer code) {
		this.code = code;
		return this;
	}

	/**
	* Get code
	* @return code
	**/
	@ApiModelProperty(required = true, value = "")
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public ErrorModel message(String message) {
		this.message = message;
		return this;
	}

	/**
	* Get message
	* @return message
	**/
	@ApiModelProperty(required = true, value = "")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ErrorModel errorModel = (ErrorModel) o;
		return Objects.equals(this.errorModelId, errorModel.errorModelId) &&
			Objects.equals(this.code, errorModel.code) &&
			Objects.equals(this.message, errorModel.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorModelId, code, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorModel {\n");

		sb.append("    errorModelId: ").append(toIndentedString(errorModelId)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
