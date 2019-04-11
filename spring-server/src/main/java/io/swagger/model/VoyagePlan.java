package io.swagger.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * VoyagePlan
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

public class VoyagePlan {
	private Long id = null;

	private String name = null;

	private String tag = null;

	public VoyagePlan id(Long id) {
		this.id = id;
		return this;
	}

	/**
	* Get id
	* @return id
	**/
	@ApiModelProperty(required = true, value = "")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VoyagePlan name(String name) {
		this.name = name;
		return this;
	}

	/**
	* Get name
	* @return name
	**/
	@ApiModelProperty(required = true, value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VoyagePlan tag(String tag) {
		this.tag = tag;
		return this;
	}

	/**
	* Get tag
	* @return tag
	**/
	@ApiModelProperty(value = "")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VoyagePlan voyagePlan = (VoyagePlan) o;
		return Objects.equals(this.id, voyagePlan.id) &&
			Objects.equals(this.name, voyagePlan.name) &&
			Objects.equals(this.tag, voyagePlan.tag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, tag);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VoyagePlan {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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
