package stm.vis.web.privateapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * FindServicesRequestObjFilter
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-08T10:03:25.020Z")

public class FindServicesRequestObjFilter {
	@JsonProperty("coverageArea")
	private FindServicesRequestObjFilterCoverageArea coverageArea = null;

	@JsonProperty("UnLoCode")
	private String unLoCode = null;

	@JsonProperty("ServiceProviderIds")
	private List<String> serviceProviderIds = new ArrayList<String>();

	@JsonProperty("serviceDesignId")
	private String serviceDesignId = null;

	@JsonProperty("serviceInstanceId")
	private String serviceInstanceId = null;

	@JsonProperty("mmsi")
	private String mmsi = null;

	@JsonProperty("imo")
	private String imo = null;

	@JsonProperty("serviceType")
	private String serviceType = null;

	@JsonProperty("serviceStatus")
	private String serviceStatus = null;

	@JsonProperty("keyWords")
  private List<String> keyWords = null;

	@JsonProperty("freeText")
	private String freeText = null;

	public FindServicesRequestObjFilter coverageArea(FindServicesRequestObjFilterCoverageArea coverageArea) {
		this.coverageArea = coverageArea;
		return this;
	}

	/**
	* Get coverageArea
	* @return coverageArea
	**/
	@ApiModelProperty(value = "")
	public FindServicesRequestObjFilterCoverageArea getCoverageArea() {
		return this.coverageArea;
	}

	public void setCoverageArea(FindServicesRequestObjFilterCoverageArea coverageArea) {
		this.coverageArea = coverageArea;
	}

	public FindServicesRequestObjFilter unLoCode(String unLoCode) {
		this.unLoCode = unLoCode;
		return this;
	}

	/**
	* Get unLoCode
	* @return unLoCode
	**/
	@ApiModelProperty(value = "")
	public String getUnLoCode() {
		return this.unLoCode;
	}

	public void setUnLoCode(String unLoCode) {
		this.unLoCode = unLoCode;
	}

	public FindServicesRequestObjFilter serviceProviderIds(List<String> serviceProviderIds) {
		this.serviceProviderIds = serviceProviderIds;
		return this;
	}

	public FindServicesRequestObjFilter addServiceProviderIdsItem(String serviceProviderIdsItem) {
		this.serviceProviderIds.add(serviceProviderIdsItem);
		return this;
	}

	/**
	* Get serviceProviderIds
	* @return serviceProviderIds
	**/
	@ApiModelProperty(value = "")
	public List<String> getServiceProviderIds() {
		return this.serviceProviderIds;
	}

	public void setServiceProviderIds(List<String> serviceProviderIds) {
		this.serviceProviderIds = serviceProviderIds;
	}

	public FindServicesRequestObjFilter serviceDesignId(String serviceDesignId) {
		this.serviceDesignId = serviceDesignId;
		return this;
	}

	/**
	* Get serviceDesignId
	* @return serviceDesignId
	**/
	@ApiModelProperty(value = "")
	public String getServiceDesignId() {
		return this.serviceDesignId;
	}

	public void setServiceDesignId(String serviceDesignId) {
		this.serviceDesignId = serviceDesignId;
	}

	public FindServicesRequestObjFilter serviceInstanceId(String serviceInstanceId) {
		this.serviceInstanceId = serviceInstanceId;
		return this;
	}

	/**
	* Get serviceInstanceId
	* @return serviceInstanceId
	**/
	@ApiModelProperty(value = "")
	public String getServiceInstanceId() {
		return this.serviceInstanceId;
	}

	public void setServiceInstanceId(String serviceInstanceId) {
		this.serviceInstanceId = serviceInstanceId;
	}

	public FindServicesRequestObjFilter mmsi(String mmsi) {
		this.mmsi = mmsi;
		return this;
	}

	/**
	* Get mmsi
	* @return mmsi
	**/
	@ApiModelProperty(value = "")
	public String getMmsi() {
		return this.mmsi;
	}

	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}

	public FindServicesRequestObjFilter imo(String imo) {
		this.imo = imo;
		return this;
	}

	/**
	* Get imo
	* @return imo
	**/
	@ApiModelProperty(value = "")
	public String getImo() {
		return this.imo;
	}

	public void setImo(String imo) {
		this.imo = imo;
	}

	public FindServicesRequestObjFilter serviceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	/**
	* Get serviceType
	* @return serviceType
	**/
	@ApiModelProperty(value = "")
	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public FindServicesRequestObjFilter serviceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
		return this;
	}

	/**
	* Get serviceStatus
	* @return serviceStatus
	**/
	@ApiModelProperty(value = "")
	public String getServiceStatus() {
		return this.serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

  public FindServicesRequestObjFilter keyWords(List<String> keyWords) {
		this.keyWords = keyWords;
    return this;
  }

  public FindServicesRequestObjFilter addKeyWordsItem(String keyWordsItem) {
    if (this.keyWords == null) {
      this.keyWords = new ArrayList<String>();
    }
    this.keyWords.add(keyWordsItem);
		return this;
	}

	/**
	* Get keyWords
	* @return keyWords
	**/
	@ApiModelProperty(value = "")


  public List<String> getKeyWords() {
    return keyWords;
	}

  public void setKeyWords(List<String> keyWords) {
		this.keyWords = keyWords;
	}

	public FindServicesRequestObjFilter freeText(String freeText) {
		this.freeText = freeText;
		return this;
	}

	/**
	* Get freeText
	* @return freeText
	**/
	@ApiModelProperty(value = "")
	public String getFreeText() {
		return this.freeText;
	}

	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		FindServicesRequestObjFilter findServicesRequestObjFilter = (FindServicesRequestObjFilter) o;
		return Objects.equals(this.coverageArea, findServicesRequestObjFilter.coverageArea) &&
			Objects.equals(this.unLoCode, findServicesRequestObjFilter.unLoCode) &&
			Objects.equals(this.serviceProviderIds, findServicesRequestObjFilter.serviceProviderIds) &&
			Objects.equals(this.serviceDesignId, findServicesRequestObjFilter.serviceDesignId) &&
			Objects.equals(this.serviceInstanceId, findServicesRequestObjFilter.serviceInstanceId) &&
			Objects.equals(this.mmsi, findServicesRequestObjFilter.mmsi) &&
			Objects.equals(this.imo, findServicesRequestObjFilter.imo) &&
			Objects.equals(this.serviceType, findServicesRequestObjFilter.serviceType) &&
			Objects.equals(this.serviceStatus, findServicesRequestObjFilter.serviceStatus) &&
			Objects.equals(this.keyWords, findServicesRequestObjFilter.keyWords) &&
			Objects.equals(this.freeText, findServicesRequestObjFilter.freeText);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.coverageArea, this.unLoCode, this.serviceProviderIds, this.serviceDesignId, this.serviceInstanceId, this.mmsi, this.imo, this.serviceType, this.serviceStatus, this.keyWords, this.freeText);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FindServicesRequestObjFilter {\n");

		sb.append("    coverageArea: ").append(this.toIndentedString(this.coverageArea)).append("\n");
		sb.append("    unLoCode: ").append(this.toIndentedString(this.unLoCode)).append("\n");
		sb.append("    serviceProviderIds: ").append(this.toIndentedString(this.serviceProviderIds)).append("\n");
		sb.append("    serviceDesignId: ").append(this.toIndentedString(this.serviceDesignId)).append("\n");
		sb.append("    serviceInstanceId: ").append(this.toIndentedString(this.serviceInstanceId)).append("\n");
		sb.append("    mmsi: ").append(this.toIndentedString(this.mmsi)).append("\n");
		sb.append("    imo: ").append(this.toIndentedString(this.imo)).append("\n");
		sb.append("    serviceType: ").append(this.toIndentedString(this.serviceType)).append("\n");
		sb.append("    serviceStatus: ").append(this.toIndentedString(this.serviceStatus)).append("\n");
		sb.append("    keyWords: ").append(this.toIndentedString(this.keyWords)).append("\n");
		sb.append("    freeText: ").append(this.toIndentedString(this.freeText)).append("\n");
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
