package stm.vis.web.privateapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * FindIdentitiesResponseObj
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-10T10:34:20.466Z")

public class FindIdentitiesResponseObj {
	@JsonProperty("organizations")
	private List<Organization> organizations = new ArrayList<Organization>();

	@JsonProperty("statusCode")
	private Long statusCode = null;

	@JsonProperty("statusMessage")
	private String statusMessage = null;

	public FindIdentitiesResponseObj organizations(List<Organization> organizations) {
		this.organizations = organizations;
		return this;
	}

	public FindIdentitiesResponseObj addOrganizationsItem(Organization organizationsItem) {
		this.organizations.add(organizationsItem);
		return this;
	}

	/**
	* Get organizations
	* @return organizations
	**/
	@ApiModelProperty(value = "")
  @Valid
	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public FindIdentitiesResponseObj statusCode(Long statusCode) {
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

	public FindIdentitiesResponseObj statusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
		return this;
	}

	/**
	* Get statusMessage
	* @return statusMessage
	**/
	@ApiModelProperty(value = "")
	public String getStatusMessage() {
		return this.statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		FindIdentitiesResponseObj findIdentitiesResponseObj = (FindIdentitiesResponseObj) o;
		return Objects.equals(this.organizations, findIdentitiesResponseObj.organizations) &&
			Objects.equals(this.statusCode, findIdentitiesResponseObj.statusCode) &&
			Objects.equals(this.statusMessage, findIdentitiesResponseObj.statusMessage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.organizations, this.statusCode, this.statusMessage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FindIdentitiesResponseObj {\n");

		sb.append("    organizations: ").append(this.toIndentedString(this.organizations)).append("\n");
		sb.append("    statusCode: ").append(this.toIndentedString(this.statusCode)).append("\n");
		sb.append("    statusMessage: ").append(this.toIndentedString(this.statusMessage)).append("\n");
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
