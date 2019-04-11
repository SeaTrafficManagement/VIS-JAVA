package stm.vis.web.privateapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CallServiceRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-10T10:34:20.466Z")

public class CallServiceRequestObj {

	@JsonProperty("body")
	private String body = null;

	@JsonProperty("endpointMethod")
	private String endpointMethod = null;

	@JsonProperty("headers")
	private List<Header> headers = new ArrayList<>();

	@JsonProperty("requestType")
	private String requestType = null;

	public CallServiceRequestObj requestType(String requestType) {
		this.requestType = requestType;
		return this;
	}

	/**
	* Request type
	* @return requestType
	**/
	@ApiModelProperty(required = true, value = "Request type")
	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public CallServiceRequestObj endpointMethod(String endpointMethod) {
		this.endpointMethod = endpointMethod;
		return this;
	}

	/**
	* Endpoint URL including port and method
	* @return url
	**/
	@ApiModelProperty(required = true, value = "Endpoint URL including port and method")
	public String getEndpointMethod() {
		return this.endpointMethod;
	}

	public void setEndpointMethod(String endpointMethod) {
		this.endpointMethod = endpointMethod;
	}

	public CallServiceRequestObj headers(List<Header> headers) {
		this.headers = headers;
		return this;
	}

  public CallServiceRequestObj addHeadersItem(Header headersItem) {
    if (this.headers == null) {
      this.headers = new ArrayList<Header>();
    }
    this.headers.add(headersItem);
    return this;
  }

	/**
	* Get headers
	* @return headers
	**/
	@ApiModelProperty(required = true, value = "")
	public List<Header> getHeaders() {
		return this.headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public CallServiceRequestObj body(String body) {
		this.body = body;
		return this;
	}

	/**
	* Get body
	* @return body
	**/
	@ApiModelProperty(required = true, value = "")
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
    CallServiceRequestObj callServiceRequestObj = (CallServiceRequestObj) o;
    return Objects.equals(this.body, callServiceRequestObj.body) &&
        Objects.equals(this.endpointMethod, callServiceRequestObj.endpointMethod) &&
        Objects.equals(this.headers, callServiceRequestObj.headers) &&
        Objects.equals(this.requestType, callServiceRequestObj.requestType);
	}

	@Override
	public int hashCode() {
    return Objects.hash(body, endpointMethod, headers, requestType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
    sb.append("class CallServiceRequestObj {\n");

    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    endpointMethod: ").append(toIndentedString(endpointMethod)).append("\n");
    sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
    sb.append("    requestType: ").append(toIndentedString(requestType)).append("\n");
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
