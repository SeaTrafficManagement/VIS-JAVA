package stm.vis.web.publicapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A voyage plan in RTZ XML format
 */
@ApiModel(description = "A voyage plan in RTZ XML format")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-01T09:18:32.002Z")

public class VoyagePlan {
	@JsonProperty("route")
	private String route = null;

	public VoyagePlan route(String route) {
		this.route = route;
		return this;
	}

	/**
   * A voyage plan in RTZ v1.1STM. vesselVoyage and routeStatusEnum is required
	* @return route
	**/
  @ApiModelProperty(value = "A voyage plan in RTZ v1.1STM. vesselVoyage and routeStatusEnum is required")


	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VoyagePlan voyagePlan = (VoyagePlan) o;
		return Objects.equals(this.route, voyagePlan.route);
	}

	@Override
	public int hashCode() {
		return Objects.hash(route);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VoyagePlan {\n");

		sb.append("    route: ").append(toIndentedString(route)).append("\n");
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
