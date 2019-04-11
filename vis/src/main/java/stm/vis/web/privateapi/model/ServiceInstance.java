package stm.vis.web.privateapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SRService
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-08T10:03:25.020Z")

public class ServiceInstance {
	@JsonProperty("comment")
	private String comment = null;

	@JsonProperty("endpointType")
	private String endpointType = null;

	@JsonProperty("endpointUri")
	private String endpointUri = null;

	@JsonProperty("instanceAsXml")
	private Xml instanceAsXml = null;

	@JsonProperty("instanceId")
	private String instanceId = null;

	@JsonProperty("keywords")
	private String keywords = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("organizationId")
	private String organizationId = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("unlocode")
	private String unlocode = null;

	@JsonProperty("version")
	private String version = null;

	public ServiceInstance comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	* Get comment
	* @return comment
	**/
	@ApiModelProperty(value = "")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ServiceInstance endpointType(String endpointType) {
		this.endpointType = endpointType;
		return this;
	}

	/**
	* Get endpointType
	* @return endpointType
	**/
	@ApiModelProperty(value = "")
	public String getEndpointType() {
		return this.endpointType;
	}

	public void setEndpointType(String endpointType) {
		this.endpointType = endpointType;
	}

	public ServiceInstance endpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
		return this;
	}

	/**
	* Get endpointUri
	* @return endpointUri
	**/
	@ApiModelProperty(value = "")
	public String getEndpointUri() {
		return this.endpointUri;
	}

	public void setEndpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
	}

	public ServiceInstance instanceAsXml(Xml instanceAsXml) {
		this.instanceAsXml = instanceAsXml;
		return this;
	}

	/**
	* Get instanceAsXml
	* @return instanceAsXml
	**/
	@ApiModelProperty(value = "")
	public Xml getInstanceAsXml() {
		return this.instanceAsXml;
	}

	public void setInstanceAsXml(Xml instanceAsXml) {
		this.instanceAsXml = instanceAsXml;
	}

	public ServiceInstance instanceId(String instanceId) {
		this.instanceId = instanceId;
		return this;
	}

	/**
	* Get instanceId
	* @return instanceId
	**/
	@ApiModelProperty(value = "")
	public String getInstanceId() {
		return this.instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public ServiceInstance keywords(String keywords) {
		this.keywords = keywords;
		return this;
	}

	/**
	* Get keywords
	* @return keywords
	**/
	@ApiModelProperty(value = "")
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public ServiceInstance name(String name) {
		this.name = name;
		return this;
	}

	/**
	* Get name
	* @return name
	**/
	@ApiModelProperty(value = "")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ServiceInstance organizationId(String organizationId) {
		this.organizationId = organizationId;
		return this;
	}

	/**
	* Get organizationId
	* @return organizationId
	**/
	@ApiModelProperty(value = "")
	public String getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public ServiceInstance status(String status) {
		this.status = status;
		return this;
	}

	/**
	* Get status
	* @return status
	**/
	@ApiModelProperty(value = "")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServiceInstance unlocode(String unlocode) {
		this.unlocode = unlocode;
		return this;
	}

	/**
	* Get unlocode
	* @return unlocode
	**/
	@ApiModelProperty(value = "")
	public String getUnlocode() {
		return this.unlocode;
	}

	public void setUnlocode(String unlocode) {
		this.unlocode = unlocode;
	}

	public ServiceInstance version(String version) {
		this.version = version;
		return this;
	}

	/**
	* Get version
	* @return version
	**/
	@ApiModelProperty(value = "")
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		ServiceInstance serviceInstance = (ServiceInstance) o;
		return Objects.equals(this.comment, serviceInstance.comment) &&
			Objects.equals(this.endpointType, serviceInstance.endpointType) &&
			Objects.equals(this.endpointUri, serviceInstance.endpointUri) &&
			Objects.equals(this.instanceAsXml, serviceInstance.instanceAsXml) &&
			Objects.equals(this.instanceId, serviceInstance.instanceId) &&
			Objects.equals(this.keywords, serviceInstance.keywords) &&
			Objects.equals(this.name, serviceInstance.name) &&
			Objects.equals(this.organizationId, serviceInstance.organizationId) &&
			Objects.equals(this.status, serviceInstance.status) &&
			Objects.equals(this.unlocode, serviceInstance.unlocode) &&
			Objects.equals(this.version, serviceInstance.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.comment, this.endpointType, this.endpointUri, this.instanceAsXml, this.instanceId, this.keywords, this.name, this.organizationId, this.status, this.unlocode, this.version);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SRService {\n");

		sb.append("    comment: ").append(this.toIndentedString(this.comment)).append("\n");
		sb.append("    endpointType: ").append(this.toIndentedString(this.endpointType)).append("\n");
		sb.append("    endpointUri: ").append(this.toIndentedString(this.endpointUri)).append("\n");
		sb.append("    instanceAsXml: ").append(this.toIndentedString(this.instanceAsXml)).append("\n");
		sb.append("    instanceId: ").append(this.toIndentedString(this.instanceId)).append("\n");
		sb.append("    keywords: ").append(this.toIndentedString(this.keywords)).append("\n");
		sb.append("    name: ").append(this.toIndentedString(this.name)).append("\n");
		sb.append("    organizationId: ").append(this.toIndentedString(this.organizationId)).append("\n");
		sb.append("    status: ").append(this.toIndentedString(this.status)).append("\n");
		sb.append("    unlocode: ").append(this.toIndentedString(this.unlocode)).append("\n");
		sb.append("    version: ").append(this.toIndentedString(this.version)).append("\n");
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
