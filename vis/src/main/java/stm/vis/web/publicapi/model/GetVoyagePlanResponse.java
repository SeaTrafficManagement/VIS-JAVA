package stm.vis.web.publicapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response object from GET voyagePlans. Can contain 0 or several (0..*) voyage plans
 */
@ApiModel(description = "Response object from GET voyagePlans. Can contain 0 or several (0..*) voyage plans")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-01T09:18:32.002Z")

public class GetVoyagePlanResponse   {
  @JsonProperty("lastInteractionTime")
  private DateTime lastInteractionTime = null;

  @JsonProperty("voyagePlans")
  private List<VoyagePlan> voyagePlans = null;

  public GetVoyagePlanResponse lastInteractionTime(DateTime lastInteractionTime) {
    this.lastInteractionTime = lastInteractionTime;
    return this;
  }

   /**
   * Last interaction time with private application. Can indicate the current connectivity on private side of VIS
   * @return lastInteractionTime
  **/
  @ApiModelProperty(value = "Last interaction time with private application. Can indicate the current connectivity on private side of VIS")

  @Valid

  public DateTime getLastInteractionTime() {
    return lastInteractionTime;
  }

  public void setLastInteractionTime(DateTime lastInteractionTime) {
    this.lastInteractionTime = lastInteractionTime;
  }

  public GetVoyagePlanResponse voyagePlans(List<VoyagePlan> voyagePlans) {
    this.voyagePlans = voyagePlans;
    return this;
  }

  public GetVoyagePlanResponse addVoyagePlansItem(VoyagePlan voyagePlansItem) {
    if (this.voyagePlans == null) {
      this.voyagePlans = new ArrayList<VoyagePlan>();
    }
    this.voyagePlans.add(voyagePlansItem);
    return this;
  }

   /**
   * Array of voyage plans in RTZ XML format
   * @return voyagePlans
  **/
  @ApiModelProperty(value = "Array of voyage plans in RTZ XML format")

  @Valid

  public List<VoyagePlan> getVoyagePlans() {
    return voyagePlans;
  }

  public void setVoyagePlans(List<VoyagePlan> voyagePlans) {
    this.voyagePlans = voyagePlans;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetVoyagePlanResponse getVoyagePlanResponse = (GetVoyagePlanResponse) o;
    return Objects.equals(this.lastInteractionTime, getVoyagePlanResponse.lastInteractionTime) &&
        Objects.equals(this.voyagePlans, getVoyagePlanResponse.voyagePlans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastInteractionTime, voyagePlans);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetVoyagePlanResponse {\n");
    
    sb.append("    lastInteractionTime: ").append(toIndentedString(lastInteractionTime)).append("\n");
    sb.append("    voyagePlans: ").append(toIndentedString(voyagePlans)).append("\n");
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

