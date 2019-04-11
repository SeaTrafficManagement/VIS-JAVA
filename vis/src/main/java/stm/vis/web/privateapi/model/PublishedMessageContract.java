package stm.vis.web.privateapi.model;

import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains published messages from STM Module (e.g. routes in RTZ)
 */
@ApiModel(description = "Contains published messages from STM Module (e.g. routes in RTZ)")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-08-31T17:12:17.402Z")

public class PublishedMessageContract {
	@JsonProperty("Message")
	private String message = null;

	@JsonProperty("MessageID")
	private String messageID = null;

	@JsonProperty("MessageLastUpdateTime")
	private DateTime messageLastUpdateTime = null;

	@JsonProperty("MessageStatus")
  private Integer messageStatus = null;

	@JsonProperty("MessageType")
  private String messageType = null;

	@JsonProperty("MessageValidFrom")
	private DateTime messageValidFrom = null;

	@JsonProperty("MessageValidTo")
	private DateTime messageValidTo = null;

	@JsonProperty("PublishTime")
	private DateTime publishTime = null;

	public PublishedMessageContract message(String message) {
		this.message = message;
		return this;
	}

	/**
   * The actual message in raw format
	* @return message
	**/
  @ApiModelProperty(value = "The actual message in raw format")


	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PublishedMessageContract messageID(String messageID) {
		this.messageID = messageID;
		return this;
	}

	/**
   * Identity of the message (extracted from the message). In case of voyage plan  it's the UVID.
	* @return messageID
	**/
  @ApiModelProperty(value = "Identity of the message (extracted from the message). In case of voyage plan  it's the UVID.")


	public String getMessageID() {
		return this.messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public PublishedMessageContract messageLastUpdateTime(DateTime messageLastUpdateTime) {
		this.messageLastUpdateTime = messageLastUpdateTime;
		return this;
	}

	/**
   * Time of update of the message (extracted from the message)
	* @return messageLastUpdateTime
	**/
  @ApiModelProperty(value = "Time of update of the message (extracted from the message)")

  @Valid

	public DateTime getMessageLastUpdateTime() {
		return this.messageLastUpdateTime;
	}

	public void setMessageLastUpdateTime(DateTime messageLastUpdateTime) {
		this.messageLastUpdateTime = messageLastUpdateTime;
	}

  public PublishedMessageContract messageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
		return this;
	}

	/**
   * Status on the message (extracted or derived from the message). In case of  voyage plan it's the routeStatus.
	* @return messageStatus
	**/
  @ApiModelProperty(value = "Status on the message (extracted or derived from the message). In case of  voyage plan it's the routeStatus.")


  public Integer getMessageStatus() {
    return messageStatus;
	}

  public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}

  public PublishedMessageContract messageType(String messageType) {
		this.messageType = messageType;
		return this;
	}

	/**
   * Type of message (enumeration)
	* @return messageType
	**/
  @ApiModelProperty(value = "Type of message (enumeration)")


  public String getMessageType() {
    return messageType;
	}

  public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public PublishedMessageContract messageValidFrom(DateTime messageValidFrom) {
		this.messageValidFrom = messageValidFrom;
		return this;
	}

	/**
   * 
	* @return messageValidFrom
	**/
	@ApiModelProperty(value = "")

  @Valid

	public DateTime getMessageValidFrom() {
		return this.messageValidFrom;
	}

	public void setMessageValidFrom(DateTime messageValidFrom) {
		this.messageValidFrom = messageValidFrom;
	}

	public PublishedMessageContract messageValidTo(DateTime messageValidTo) {
		this.messageValidTo = messageValidTo;
		return this;
	}

	/**
   * 
	* @return messageValidTo
	**/
	@ApiModelProperty(value = "")

  @Valid

	public DateTime getMessageValidTo() {
		return this.messageValidTo;
	}

	public void setMessageValidTo(DateTime messageValidTo) {
		this.messageValidTo = messageValidTo;
	}

	public PublishedMessageContract publishTime(DateTime publishTime) {
		this.publishTime = publishTime;
		return this;
	}

	/**
   * Publish time to VIS (set by VIS when received)
	* @return publishTime
	**/
  @ApiModelProperty(value = "Publish time to VIS (set by VIS when received)")

  @Valid

	public DateTime getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(DateTime publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		PublishedMessageContract publishedMessageContract = (PublishedMessageContract) o;
		return Objects.equals(this.message, publishedMessageContract.message) &&
			Objects.equals(this.messageID, publishedMessageContract.messageID) &&
			Objects.equals(this.messageLastUpdateTime, publishedMessageContract.messageLastUpdateTime) &&
			Objects.equals(this.messageStatus, publishedMessageContract.messageStatus) &&
			Objects.equals(this.messageType, publishedMessageContract.messageType) &&
			Objects.equals(this.messageValidFrom, publishedMessageContract.messageValidFrom) &&
			Objects.equals(this.messageValidTo, publishedMessageContract.messageValidTo) &&
			Objects.equals(this.publishTime, publishedMessageContract.publishTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.message, this.messageID, this.messageLastUpdateTime, this.messageStatus, this.messageType, this.messageValidFrom, this.messageValidTo, this.publishTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PublishedMessageContract {\n");

		sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
		sb.append("    messageID: ").append(this.toIndentedString(this.messageID)).append("\n");
		sb.append("    messageLastUpdateTime: ").append(this.toIndentedString(this.messageLastUpdateTime)).append("\n");
		sb.append("    messageStatus: ").append(this.toIndentedString(this.messageStatus)).append("\n");
		sb.append("    messageType: ").append(this.toIndentedString(this.messageType)).append("\n");
		sb.append("    messageValidFrom: ").append(this.toIndentedString(this.messageValidFrom)).append("\n");
		sb.append("    messageValidTo: ").append(this.toIndentedString(this.messageValidTo)).append("\n");
		sb.append("    publishTime: ").append(this.toIndentedString(this.publishTime)).append("\n");
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
