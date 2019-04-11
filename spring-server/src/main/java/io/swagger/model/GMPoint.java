package io.swagger.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * GMPoint
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

public class GMPoint {
	private Long id = null;

	private LatitudeType lat = null;

	private LongitudeType lon = null;

	public GMPoint id(Long id) {
		this.id = id;
		return this;
	}

	/**
	* Get id
	* @return id
	**/
	@ApiModelProperty(required = true, value = "")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GMPoint lat(LatitudeType lat) {
		this.lat = lat;
		return this;
	}

	/**
	* Get lat
	* @return lat
	**/
	@ApiModelProperty(value = "")
	public LatitudeType getLat() {
		return lat;
	}

	public void setLat(LatitudeType lat) {
		this.lat = lat;
	}

	public GMPoint lon(LongitudeType lon) {
		this.lon = lon;
		return this;
	}

	/**
	* Get lon
	* @return lon
	**/
	@ApiModelProperty(value = "")
	public LongitudeType getLon() {
		return lon;
	}

	public void setLon(LongitudeType lon) {
		this.lon = lon;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GMPoint gMPoint = (GMPoint) o;
		return Objects.equals(this.id, gMPoint.id) &&
			Objects.equals(this.lat, gMPoint.lat) &&
			Objects.equals(this.lon, gMPoint.lon);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lat, lon);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GMPoint {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
		sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
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
