package stm.vis.web.privateapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A technical way to describe aspects if a service.The Xml should validate against a XSD from a SpecificationTemplate.
 */
@ApiModel(description = "A technical way to describe aspects if a service.The Xml should validate against a XSD from a SpecificationTemplate.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-08T10:03:25.020Z")

public class Xml {
	@JsonProperty("comment")
	private String comment = null;

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("contentContentType")
	private String contentContentType = null;

	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("name")
	private String name = null;

	public Xml comment(String comment) {
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

	public Xml content(String content) {
		this.content = content;
		return this;
	}

	/**
	* Get content
	* @return content
	**/
	@ApiModelProperty(value = "")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Xml contentContentType(String contentContentType) {
		this.contentContentType = contentContentType;
		return this;
	}

	/**
	* Get contentContentType
	* @return contentContentType
	**/
	@ApiModelProperty(value = "")
	public String getContentContentType() {
		return this.contentContentType;
	}

	public void setContentContentType(String contentContentType) {
		this.contentContentType = contentContentType;
	}

	public Xml id(Long id) {
		this.id = id;
		return this;
	}

	/**
	* Get id
	* @return id
	**/
	@ApiModelProperty(value = "")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Xml name(String name) {
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
		Xml xml = (Xml) o;
		return Objects.equals(this.comment, xml.comment) &&
			Objects.equals(this.content, xml.content) &&
			Objects.equals(this.contentContentType, xml.contentContentType) &&
			Objects.equals(this.id, xml.id) &&
			Objects.equals(this.name, xml.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.comment, this.content, this.contentContentType, this.id, this.name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Xml {\n");

		sb.append("    comment: ").append(this.toIndentedString(this.comment)).append("\n");
		sb.append("    content: ").append(this.toIndentedString(this.content)).append("\n");
		sb.append("    contentContentType: ").append(this.toIndentedString(this.contentContentType)).append("\n");
		sb.append("    id: ").append(this.toIndentedString(this.id)).append("\n");
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
