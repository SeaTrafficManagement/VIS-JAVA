package stm.vis.web.privateapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SubscriptionObject
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-13T06:38:39.503Z")

public class SubscriptionObject {
	@JsonProperty("IdentityId")
	private String identityId = null;

	@JsonProperty("IdentityName")
	private String identityName = null;

	@JsonProperty("EndpointURL")
	private String endpointURL = null;

	public SubscriptionObject identityId(String identityId) {
		this.identityId = identityId;
		return this;
	}

	/**
   * 
	* @return identityId
	**/
	@ApiModelProperty(value = "")
	public String getIdentityId() {
		return this.identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public SubscriptionObject identityName(String identityName) {
		this.identityName = identityName;
		return this;
	}

	/**
   * 
	* @return identityName
	**/
	@ApiModelProperty(value = "")
	public String getIdentityName() {
		return this.identityName;
	}

	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}

	public SubscriptionObject endpointURL(String endpointURL) {
		this.endpointURL = endpointURL;
		return this;
	}

	/**
   * 
	* @return endpointURL
	**/
	@ApiModelProperty(value = "")
	public String getEndpointURL() {
		return this.endpointURL;
	}

	public void setEndpointURL(String endpointURL) {
		this.endpointURL = endpointURL;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		SubscriptionObject subscriptionObject = (SubscriptionObject) o;
		return Objects.equals(this.identityId, subscriptionObject.identityId) &&
			Objects.equals(this.identityName, subscriptionObject.identityName) &&
			Objects.equals(this.endpointURL, subscriptionObject.endpointURL);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.identityId, this.identityName, this.endpointURL);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SubscriptionObject {\n");

		sb.append("    identityId: ").append(this.toIndentedString(this.identityId)).append("\n");
		sb.append("    identityName: ").append(this.toIndentedString(this.identityName)).append("\n");
		sb.append("    endpointURL: ").append(this.toIndentedString(this.endpointURL)).append("\n");
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
