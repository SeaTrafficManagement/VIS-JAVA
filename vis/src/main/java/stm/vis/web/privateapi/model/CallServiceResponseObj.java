package stm.vis.web.privateapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CallServiceResponseObj
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-10T10:34:20.466Z")

public class CallServiceResponseObj {
	@JsonProperty("body")
	private String body = null;

	@JsonProperty("statusCode")
	private Long statusCode = null;

	public CallServiceResponseObj body(String body) {
		this.body = body;
		return this;
	}

	/**
	* Get body
	* @return body
	**/
	@ApiModelProperty(value = "")
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public CallServiceResponseObj statusCode(Long statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	/**
	* Get statusCode
	* @return statusCode
	**/
	@ApiModelProperty(value = "")
	public Long getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		CallServiceResponseObj callServiceResponseObj = (CallServiceResponseObj) o;
		return Objects.equals(this.body, callServiceResponseObj.body) &&
			Objects.equals(this.statusCode, callServiceResponseObj.statusCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.body, this.statusCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CallServiceResponseObj {\n");

		sb.append("    body: ").append(this.toIndentedString(this.body)).append("\n");
		sb.append("    statusCode: ").append(this.toIndentedString(this.statusCode)).append("\n");
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
