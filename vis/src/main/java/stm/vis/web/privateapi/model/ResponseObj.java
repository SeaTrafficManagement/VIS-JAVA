package stm.vis.web.privateapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseObj
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-10T10:34:20.466Z")

public class ResponseObj   {
  @JsonProperty("dataId")
  private String dataId = null;

  public ResponseObj dataId(String dataId) {
    this.dataId = dataId;
    return this;
  }

   /**
   * Gets or Sets DataId
   * @return dataId
  **/
  @ApiModelProperty(value = "Gets or Sets DataId")


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
    ResponseObj responseObj = (ResponseObj) o;
    return Objects.equals(this.dataId, responseObj.dataId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseObj {\n");
    
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

