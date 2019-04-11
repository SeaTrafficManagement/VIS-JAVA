package io.swagger.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * AreaMessage
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

public class AreaMessage {
	private Long id = null;

	private String name = null;

	private String tag = null;

	public AreaMessage id(Long id) {
		this.id = id;
		return this;
	}

	/**
	* Get id
	* @return id
	**/
	@ApiModelProperty(value = "")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AreaMessage name(String name) {
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

	public AreaMessage tag(String tag) {
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
		AreaMessage areaMessage = (AreaMessage) o;
		return Objects.equals(this.id, areaMessage.id) &&
			Objects.equals(this.name, areaMessage.name) &&
			Objects.equals(this.tag, areaMessage.tag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, tag);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AreaMessage {\n");

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
