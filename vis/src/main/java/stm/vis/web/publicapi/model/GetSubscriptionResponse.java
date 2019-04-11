package stm.vis.web.publicapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DataId object containing the UVID in URN format
 */
@ApiModel(description = "DataId object containing the UVID in URN format")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-01T09:18:32.002Z")

public class GetSubscriptionResponse   {
  @JsonProperty("DataId")
  private String dataId = null;

  public GetSubscriptionResponse dataId(String dataId) {
    this.dataId = dataId;
    return this;
  }

   /**
   * Unique identity (UVID) of a voyageplan
   * @return dataId
  **/
  @ApiModelProperty(value = "Unique identity (UVID) of a voyageplan")


  public String getDataId() {
    return dataId;
  }

  public void setDataId(String dataId) {
    this.dataId = dataId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSubscriptionResponse getSubscriptionResponse = (GetSubscriptionResponse) o;
    return Objects.equals(this.dataId, getSubscriptionResponse.dataId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSubscriptionResponse {\n");
    
    sb.append("    dataId: ").append(toIndentedString(dataId)).append("\n");
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

