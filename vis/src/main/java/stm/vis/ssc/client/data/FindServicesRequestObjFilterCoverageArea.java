package stm.vis.ssc.client.data;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * FindServicesRequestObjFilterCoverageArea
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-08T10:03:25.020Z")

public class FindServicesRequestObjFilterCoverageArea {
	@JsonProperty("coverageType")
	private String coverageType = null;

	@JsonProperty("value")
	private String value = null;

	public FindServicesRequestObjFilterCoverageArea coverageType(String coverageType) {
		this.coverageType = coverageType;
		return this;
	}

	/**
	* Get coverageType
	* @return coverageType
	**/
	@ApiModelProperty(value = "")
	public String getCoverageType() {
		return this.coverageType;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

	public FindServicesRequestObjFilterCoverageArea value(String value) {
		this.value = value;
		return this;
	}

	/**
	* Get value
	* @return value
	**/
	@ApiModelProperty(value = "")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		FindServicesRequestObjFilterCoverageArea findServicesRequestObjFilterCoverageArea = (FindServicesRequestObjFilterCoverageArea) o;
		return Objects.equals(this.coverageType, findServicesRequestObjFilterCoverageArea.coverageType) &&
			Objects.equals(this.value, findServicesRequestObjFilterCoverageArea.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.coverageType, this.value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FindServicesRequestObjFilterCoverageArea {\n");

		sb.append("    coverageType: ").append(this.toIndentedString(this.coverageType)).append("\n");
		sb.append("    value: ").append(this.toIndentedString(this.value)).append("\n");
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
