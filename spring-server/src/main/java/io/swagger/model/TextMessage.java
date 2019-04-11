package io.swagger.model;

import java.util.Objects;

import org.joda.time.DateTime;

import io.swagger.annotations.ApiModelProperty;

/**
 * TextMessage
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

public class TextMessage {
	private String textMessageId = null;

	private String informationObjectReferenceId = null;

	private String author = null;

	private String from = null;

	private String serviceType = null;

	private DateTime createdAt = null;

	private String subject = null;

	private String body = null;

	private GMPoint position = null;

	public TextMessage textMessageId(String textMessageId) {
		this.textMessageId = textMessageId;
		return this;
	}

	/**
	* Get textMessageId
	* @return textMessageId
	**/
	@ApiModelProperty(required = true, value = "")
	public String getTextMessageId() {
		return textMessageId;
	}

	public void setTextMessageId(String textMessageId) {
		this.textMessageId = textMessageId;
	}

	public TextMessage informationObjectReferenceId(String informationObjectReferenceId) {
		this.informationObjectReferenceId = informationObjectReferenceId;
		return this;
	}

	/**
	* Get informationObjectReferenceId
	* @return informationObjectReferenceId
	**/
	@ApiModelProperty(value = "")
	public String getInformationObjectReferenceId() {
		return informationObjectReferenceId;
	}

	public void setInformationObjectReferenceId(String informationObjectReferenceId) {
		this.informationObjectReferenceId = informationObjectReferenceId;
	}

	public TextMessage author(String author) {
		this.author = author;
		return this;
	}

	/**
	* Get author
	* @return author
	**/
	@ApiModelProperty(required = true, value = "")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public TextMessage from(String from) {
		this.from = from;
		return this;
	}

	/**
	* Get from
	* @return from
	**/
	@ApiModelProperty(required = true, value = "")
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public TextMessage serviceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	/**
	* Get serviceType
	* @return serviceType
	**/
	@ApiModelProperty(value = "")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public TextMessage createdAt(DateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	* Get createdAt
	* @return createdAt
	**/
	@ApiModelProperty(required = true, value = "")
	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public TextMessage subject(String subject) {
		this.subject = subject;
		return this;
	}

	/**
	* Get subject
	* @return subject
	**/
	@ApiModelProperty(required = true, value = "")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public TextMessage body(String body) {
		this.body = body;
		return this;
	}

	/**
	* Get body
	* @return body
	**/
	@ApiModelProperty(value = "")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public TextMessage position(GMPoint position) {
		this.position = position;
		return this;
	}

	/**
	* Get position
	* @return position
	**/
	@ApiModelProperty(value = "")
	public GMPoint getPosition() {
		return position;
	}

	public void setPosition(GMPoint position) {
		this.position = position;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TextMessage textMessage = (TextMessage) o;
		return Objects.equals(this.textMessageId, textMessage.textMessageId) &&
			Objects.equals(this.informationObjectReferenceId, textMessage.informationObjectReferenceId) &&
			Objects.equals(this.author, textMessage.author) &&
			Objects.equals(this.from, textMessage.from) &&
			Objects.equals(this.serviceType, textMessage.serviceType) &&
			Objects.equals(this.createdAt, textMessage.createdAt) &&
			Objects.equals(this.subject, textMessage.subject) &&
			Objects.equals(this.body, textMessage.body) &&
			Objects.equals(this.position, textMessage.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(textMessageId, informationObjectReferenceId, author, from, serviceType, createdAt, subject, body, position);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TextMessage {\n");

		sb.append("    textMessageId: ").append(toIndentedString(textMessageId)).append("\n");
		sb.append("    informationObjectReferenceId: ").append(toIndentedString(informationObjectReferenceId)).append("\n");
		sb.append("    author: ").append(toIndentedString(author)).append("\n");
		sb.append("    from: ").append(toIndentedString(from)).append("\n");
		sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
		sb.append("    body: ").append(toIndentedString(body)).append("\n");
		sb.append("    position: ").append(toIndentedString(position)).append("\n");
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
