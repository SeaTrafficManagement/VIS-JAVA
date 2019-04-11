package stm.vis.web.privateapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Organization
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-08T10:03:25.020Z")

public class Organization {
	@JsonProperty("country")
	private String country = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("mrn")
	private String mrn = null;

	@JsonProperty("name")
	private String name = null;

	public Organization country(String country) {
		this.country = country;
		return this;
	}

	/**
	* Get country
	* @return country
	**/
  @ApiModelProperty(value = "")


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Organization email(String email) {
		this.email = email;
		return this;
	}

	/**
	* Get email
	* @return email
	**/
  @ApiModelProperty(value = "")


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Organization mrn(String mrn) {
		this.mrn = mrn;
		return this;
	}

	/**
   * Get mrn
	* @return mrn
	**/
  @ApiModelProperty(value = "")


	public String getMrn() {
		return this.mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public Organization name(String name) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Organization organization = (Organization) o;
		return Objects.equals(this.country, organization.country) &&
			Objects.equals(this.email, organization.email) &&
			Objects.equals(this.mrn, organization.mrn) &&
			Objects.equals(this.name, organization.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.country, this.email, this.mrn, this.name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Organization {\n");

		sb.append("    country: ").append(this.toIndentedString(this.country)).append("\n");
		sb.append("    email: ").append(this.toIndentedString(this.email)).append("\n");
		sb.append("    mrn: ").append(this.toIndentedString(this.mrn)).append("\n");
		sb.append("    name: ").append(this.toIndentedString(this.name)).append("\n");
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
