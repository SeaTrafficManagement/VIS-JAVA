package stm.vis.web.publicapi.model;

import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Acknowledgement message that incoming (uploaded) message has been delivered to consumer
 */
@ApiModel(description = "Acknowledgement message that incoming (uploaded) message has been delivered to consumer")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-01T09:18:32.002Z")

public class DeliveryAck {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("referenceId")
	private String referenceId = null;

	@JsonProperty("timeOfDelivery")
	private DateTime timeOfDelivery = null;

	@JsonProperty("fromId")
	private String fromId = null;

	@JsonProperty("fromName")
	private String fromName = null;

	@JsonProperty("toId")
	private String toId = null;

	@JsonProperty("toName")
	private String toName = null;

	@JsonProperty("ackResult")
	private String ackResult = null;

	public DeliveryAck id(String id) {
		this.id = id;
		return this;
	}

	/**
   * Acknowledgement ID
	* @return id
	**/
  @ApiModelProperty(value = "Acknowledgement ID")


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DeliveryAck referenceId(String referenceId) {
		this.referenceId = referenceId;
		return this;
	}

	/**
   * Reference ID such as a UVID, TXT id or area message id
	* @return referenceId
	**/
  @ApiModelProperty(value = "Reference ID such as a UVID, TXT id or area message id")


	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public DeliveryAck timeOfDelivery(DateTime timeOfDelivery) {
		this.timeOfDelivery = timeOfDelivery;
		return this;
	}

	/**
   * Time of Delivery of message to consumer
	* @return timeOfDelivery
	**/
  @ApiModelProperty(value = "Time of Delivery of message to consumer")

  @Valid

	public DateTime getTimeOfDelivery() {
		return timeOfDelivery;
	}

	public void setTimeOfDelivery(DateTime timeOfDelivery) {
		this.timeOfDelivery = timeOfDelivery;
	}

	public DeliveryAck fromId(String fromId) {
		this.fromId = fromId;
		return this;
	}

	/**
   * Identity O (organisation) of the message sender in MRN format
	* @return fromId
	**/
  @ApiModelProperty(value = "Identity O (organisation) of the message sender in MRN format")


	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public DeliveryAck fromName(String fromName) {
		this.fromName = fromName;
		return this;
	}

	/**
   * \"Identity O (organisation) of the message sender in full name
	* @return fromName
	**/
  @ApiModelProperty(value = "\"Identity O (organisation) of the message sender in full name")


	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public DeliveryAck toId(String toId) {
		this.toId = toId;
		return this;
	}

	/**
   * Identity O (organisation) of the message receiver in MRN format
	* @return toId
	**/
  @ApiModelProperty(value = "Identity O (organisation) of the message receiver in MRN format")


	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public DeliveryAck toName(String toName) {
		this.toName = toName;
		return this;
	}

	/**
   * IIdentity O (organisation) of the message receiver in full name
	* @return toName
	**/
  @ApiModelProperty(value = "IIdentity O (organisation) of the message receiver in full name")


	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public DeliveryAck ackResult(String ackResult) {
		this.ackResult = ackResult;
		return this;
	}

	/**
   * Descriptive acknowledgement message
	* @return ackResult
	**/
  @ApiModelProperty(value = "Descriptive acknowledgement message")


	public String getAckResult() {
		return ackResult;
	}

	public void setAckResult(String ackResult) {
		this.ackResult = ackResult;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DeliveryAck deliveryAck = (DeliveryAck) o;
		return Objects.equals(this.id, deliveryAck.id) &&
			Objects.equals(this.referenceId, deliveryAck.referenceId) &&
			Objects.equals(this.timeOfDelivery, deliveryAck.timeOfDelivery) &&
			Objects.equals(this.fromId, deliveryAck.fromId) &&
			Objects.equals(this.fromName, deliveryAck.fromName) &&
			Objects.equals(this.toId, deliveryAck.toId) &&
			Objects.equals(this.toName, deliveryAck.toName) &&
			Objects.equals(this.ackResult, deliveryAck.ackResult);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, referenceId, timeOfDelivery, fromId, fromName, toId, toName, ackResult);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DeliveryAck {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
		sb.append("    timeOfDelivery: ").append(toIndentedString(timeOfDelivery)).append("\n");
		sb.append("    fromId: ").append(toIndentedString(fromId)).append("\n");
		sb.append("    fromName: ").append(toIndentedString(fromName)).append("\n");
		sb.append("    toId: ").append(toIndentedString(toId)).append("\n");
		sb.append("    toName: ").append(toIndentedString(toName)).append("\n");
		sb.append("    ackResult: ").append(toIndentedString(ackResult)).append("\n");
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
