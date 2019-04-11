package stm.vis.web.privateapi.model;

import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-08-31T17:12:17.402Z")

public class Message   {
  @JsonProperty("CallbackEndpoint")
  private String callbackEndpoint = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("receivedAt")
  private DateTime receivedAt = null;

  @JsonProperty("FromOrgId")
  private String fromOrgId = null;

  @JsonProperty("FromOrgName")
  private String fromOrgName = null;

  @JsonProperty("FromServiceId")
  private String fromServiceId = null;

  @JsonProperty("messageType")
  private String messageType = null;

  @JsonProperty("stmMessage")
  private StmMessage stmMessage = null;

  public Message callbackEndpoint(String callbackEndpoint) {
    this.callbackEndpoint = callbackEndpoint;
    return this;
  }

   /**
   * Gets or sets CallbackEndpoint
   * @return callbackEndpoint
  **/
  @ApiModelProperty(value = "Gets or sets CallbackEndpoint")


  public String getCallbackEndpoint() {
    return callbackEndpoint;
  }

  public void setCallbackEndpoint(String callbackEndpoint) {
    this.callbackEndpoint = callbackEndpoint;
  }

  public Message id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Gets or Sets Id
   * @return id
  **/
  @ApiModelProperty(value = "Gets or Sets Id")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Message receivedAt(DateTime receivedAt) {
    this.receivedAt = receivedAt;
    return this;
  }

   /**
   * Gets or Sets ReceivedAt
   * @return receivedAt
  **/
  @ApiModelProperty(value = "Gets or Sets ReceivedAt")

  @Valid

  public DateTime getReceivedAt() {
    return receivedAt;
  }

  public void setReceivedAt(DateTime receivedAt) {
    this.receivedAt = receivedAt;
  }

  public Message fromOrgId(String fromOrgId) {
    this.fromOrgId = fromOrgId;
    return this;
  }

   /**
   * Gets or Sets FromOrgId
   * @return fromOrgId
  **/
  @ApiModelProperty(value = "Gets or Sets FromOrgId")


  public String getFromOrgId() {
    return fromOrgId;
  }

  public void setFromOrgId(String fromOrgId) {
    this.fromOrgId = fromOrgId;
  }

  public Message fromOrgName(String fromOrgName) {
    this.fromOrgName = fromOrgName;
    return this;
  }

   /**
   * Gets or Sets FromOrgName
   * @return fromOrgName
  **/
  @ApiModelProperty(value = "Gets or Sets FromOrgName")


  public String getFromOrgName() {
    return fromOrgName;
  }

  public void setFromOrgName(String fromOrgName) {
    this.fromOrgName = fromOrgName;
  }

  public Message fromServiceId(String fromServiceId) {
    this.fromServiceId = fromServiceId;
    return this;
  }

   /**
   * Gets or Sets FromServiceId
   * @return fromServiceId
  **/
  @ApiModelProperty(value = "Gets or Sets FromServiceId")


  public String getFromServiceId() {
    return fromServiceId;
  }

  public void setFromServiceId(String fromServiceId) {
    this.fromServiceId = fromServiceId;
  }

  public Message messageType(String messageType) {
    this.messageType = messageType;
    return this;
  }

   /**
   * Gets or Sets MessageType
   * @return messageType
  **/
  @ApiModelProperty(value = "Gets or Sets MessageType")


  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  public Message stmMessage(StmMessage stmMessage) {
    this.stmMessage = stmMessage;
    return this;
  }

   /**
   * Gets or Sets StmMessage
   * @return stmMessage
  **/
  @ApiModelProperty(value = "Gets or Sets StmMessage")

  @Valid

  public StmMessage getStmMessage() {
    return stmMessage;
  }

  public void setStmMessage(StmMessage stmMessage) {
    this.stmMessage = stmMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Message message = (Message) o;
    return Objects.equals(this.callbackEndpoint, message.callbackEndpoint) &&
        Objects.equals(this.id, message.id) &&
        Objects.equals(this.receivedAt, message.receivedAt) &&
        Objects.equals(this.fromOrgId, message.fromOrgId) &&
        Objects.equals(this.fromOrgName, message.fromOrgName) &&
        Objects.equals(this.fromServiceId, message.fromServiceId) &&
        Objects.equals(this.messageType, message.messageType) &&
        Objects.equals(this.stmMessage, message.stmMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackEndpoint, id, receivedAt, fromOrgId, fromOrgName, fromServiceId, messageType, stmMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Message {\n");
    
    sb.append("    callbackEndpoint: ").append(toIndentedString(callbackEndpoint)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    receivedAt: ").append(toIndentedString(receivedAt)).append("\n");
    sb.append("    fromOrgId: ").append(toIndentedString(fromOrgId)).append("\n");
    sb.append("    fromOrgName: ").append(toIndentedString(fromOrgName)).append("\n");
    sb.append("    fromServiceId: ").append(toIndentedString(fromServiceId)).append("\n");
    sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
    sb.append("    stmMessage: ").append(toIndentedString(stmMessage)).append("\n");
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

