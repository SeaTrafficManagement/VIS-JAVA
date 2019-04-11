package stm.vis.ssc.client.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class FindServicesResponseObj {
	@JsonProperty("servicesInstances")
	private List<ServiceInstance> servicesInstances = new ArrayList<ServiceInstance>();

	@JsonProperty("statusCode")
	private Long statusCode = null;

	@JsonProperty("statusMessage")
	private String statusMessage = null;

	public FindServicesResponseObj servicesInstances(List<ServiceInstance> servicesInstances) {
		this.servicesInstances = servicesInstances;
		return this;
	}

	public FindServicesResponseObj addServicesInstancesItem(ServiceInstance servicesInstancesItem) {
		this.servicesInstances.add(servicesInstancesItem);
		return this;
	}

	/**
	* Get servicesInstances
	* @return servicesInstances
	**/
	@ApiModelProperty(value = "")

  @Valid

	public List<ServiceInstance> getServicesInstances() {
		return this.servicesInstances;
	}

	public void setServicesInstances(List<ServiceInstance> servicesInstances) {
		this.servicesInstances = servicesInstances;
	}

	public FindServicesResponseObj statusCode(Long statusCode) {
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

	public FindServicesResponseObj statusMessage(String statusMessage) {
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
		FindServicesResponseObj findServicesResponseObj = (FindServicesResponseObj) o;
		return Objects.equals(this.servicesInstances, findServicesResponseObj.servicesInstances) &&
			Objects.equals(this.statusCode, findServicesResponseObj.statusCode) &&
			Objects.equals(this.statusMessage, findServicesResponseObj.statusMessage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.servicesInstances, this.statusCode, this.statusMessage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FindServicesResponseObj {\n");

		sb.append("    servicesInstances: ").append(this.toIndentedString(this.servicesInstances)).append("\n");
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
