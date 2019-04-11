package stm.vis.ssc.client.data;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class FindServicesRequestObj {
	@JsonProperty("filter")
	private FindServicesRequestObjFilter filter = null;

	@JsonProperty("page")
	private Long page = null;

	@JsonProperty("pageSize")
	private Long pageSize = null;

	public FindServicesRequestObj filter(FindServicesRequestObjFilter filter) {
		this.filter = filter;
		return this;
	}

	/**
	* Get filter
	* @return filter
	**/
	@ApiModelProperty(value = "")

  @Valid

	public FindServicesRequestObjFilter getFilter() {
		return this.filter;
	}

	public void setFilter(FindServicesRequestObjFilter filter) {
		this.filter = filter;
	}

	public FindServicesRequestObj page(Long page) {
		this.page = page;
		return this;
	}

	/**
	* Get page
	* @return page
	**/
	@ApiModelProperty(value = "")
	public Long getPage() {
		return this.page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public FindServicesRequestObj pageSize(Long pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	/**
	* Get pageSize
	* @return pageSize
	**/
	@ApiModelProperty(value = "")
	public Long getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		FindServicesRequestObj findServicesRequestObj = (FindServicesRequestObj) o;
		return Objects.equals(this.filter, findServicesRequestObj.filter) &&
			Objects.equals(this.page, findServicesRequestObj.page) &&
			Objects.equals(this.pageSize, findServicesRequestObj.pageSize);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.filter, this.page, this.pageSize);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FindServicesRequestObj {\n");

		sb.append("    filter: ").append(this.toIndentedString(this.filter)).append("\n");
		sb.append("    page: ").append(this.toIndentedString(this.page)).append("\n");
		sb.append("    pageSize: ").append(this.toIndentedString(this.pageSize)).append("\n");
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
