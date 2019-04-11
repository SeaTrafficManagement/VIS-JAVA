package stm.vis.web.privateapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * MessageEnvelope
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-10T12:58:37.496Z")

public class MessageEnvelope {
	@JsonProperty("numberOfMessages")
	private Integer numberOfMessages = null;

	@JsonProperty("remainingNumberOfMessages")
	private Integer remainingNumberOfMessages = null;

	@JsonProperty("message")
	private List<Message> message = new ArrayList<Message>();

	public MessageEnvelope numberOfMessages(Integer numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
		return this;
	}

	/**
   * Gets or Sets NumberOfMessages
	* @return numberOfMessages
	**/
  @ApiModelProperty(value = "Gets or Sets NumberOfMessages")


	public Integer getNumberOfMessages() {
		return this.numberOfMessages;
	}

	public void setNumberOfMessages(Integer numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}

	public MessageEnvelope remainingNumberOfMessages(Integer remainingNumberOfMessages) {
		this.remainingNumberOfMessages = remainingNumberOfMessages;
		return this;
	}

	/**
	* Get remainingNumberOfMessages
	* @return remainingNumberOfMessages
	**/
  @ApiModelProperty(value = "Gets or Sets RemainingNumberOfMessages")


	public Integer getRemainingNumberOfMessages() {
		return this.remainingNumberOfMessages;
	}

	public void setRemainingNumberOfMessages(Integer remainingNumberOfMessages) {
		this.remainingNumberOfMessages = remainingNumberOfMessages;
	}

	public MessageEnvelope message(List<Message> message) {
		this.message = message;
		return this;
	}

	public MessageEnvelope addMessageItem(Message messageItem) {
		this.message.add(messageItem);
		return this;
	}

	/**
   * Gets or Sets Message
	* @return message
	**/
  @ApiModelProperty(value = "Gets or Sets Message")

  @Valid

	public List<Message> getMessage() {
		return this.message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		MessageEnvelope messageEnvelope = (MessageEnvelope) o;
		return Objects.equals(this.numberOfMessages, messageEnvelope.numberOfMessages) &&
			Objects.equals(this.remainingNumberOfMessages, messageEnvelope.remainingNumberOfMessages) &&
			Objects.equals(this.message, messageEnvelope.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.numberOfMessages, this.remainingNumberOfMessages, this.message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MessageEnvelope {\n");

		sb.append("    numberOfMessages: ").append(this.toIndentedString(this.numberOfMessages)).append("\n");
		sb.append("    remainingNumberOfMessages: ").append(this.toIndentedString(this.remainingNumberOfMessages)).append("\n");
		sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
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
