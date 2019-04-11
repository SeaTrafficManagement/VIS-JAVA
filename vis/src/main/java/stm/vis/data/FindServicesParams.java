package stm.vis.data;

import java.util.ArrayList;
import java.util.List;

public class FindServicesParams {

	private FindServicesFilter filter;
	private Long page;
	private Long pageSize;

	public FindServicesFilter getFilter() {
		return this.filter;
	}

	public void setFilter(FindServicesFilter filter) {
		this.filter = filter;
	}

	public Long getPage() {
		return this.page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public static class FindServicesFilter {
		private FindServicesFilterCoverageArea coverageArea;
		private String unLoCode;
		private List<String> serviceProviderIds = new ArrayList<String>();
		private String serviceDesignId;
		private String serviceInstanceId;
		private String mmsi;
		private String imo;
		private String serviceType;
		private String serviceStatus;
		private List<String> keyWords;
		private String freeText;

		public FindServicesFilterCoverageArea getCoverageArea() {
			return this.coverageArea;
		}

		public void setCoverageArea(FindServicesFilterCoverageArea coverageArea) {
			this.coverageArea = coverageArea;
		}

		public String getUnLoCode() {
			return this.unLoCode;
		}

		public void setUnLoCode(String unLoCode) {
			this.unLoCode = unLoCode;
		}

		public List<String> getServiceProviderIds() {
			return this.serviceProviderIds;
		}

		public void setServiceProviderIds(List<String> serviceProviderIds) {
			this.serviceProviderIds = serviceProviderIds;
		}

		public String getServiceDesignId() {
			return this.serviceDesignId;
		}

		public void setServiceDesignId(String serviceDesignId) {
			this.serviceDesignId = serviceDesignId;
		}

		public String getServiceInstanceId() {
			return this.serviceInstanceId;
		}

		public void setServiceInstanceId(String serviceInstanceId) {
			this.serviceInstanceId = serviceInstanceId;
		}

		public String getMmsi() {
			return this.mmsi;
		}

		public void setMmsi(String mmsi) {
			this.mmsi = mmsi;
		}

		public String getImo() {
			return this.imo;
		}

		public void setImo(String imo) {
			this.imo = imo;
		}

		public String getServiceType() {
			return this.serviceType;
		}

		public void setServiceType(String serviceType) {
			this.serviceType = serviceType;
		}

		public String getServiceStatus() {
			return this.serviceStatus;
		}

		public void setServiceStatus(String serviceStatus) {
			this.serviceStatus = serviceStatus;
		}

		public List<String> getKeyWords() {
			return keyWords;
		}
		
		public void setKeyWords(List<String> keyWords) {
			this.keyWords = keyWords;
		}
		
		public String getFreeText() {
			return this.freeText;
		}

		public void setFreeText(String freeText) {
			this.freeText = freeText;
		}

		public static class FindServicesFilterCoverageArea {
			private String coverageType = null;
			private String value = null;

			public String getCoverageType() {
				return this.coverageType;
			}

			public void setCoverageType(String coverageType) {
				this.coverageType = coverageType;
			}

			public String getValue() {
				return this.value;
			}

			public void setValue(String value) {
				this.value = value;
			}

		}

	}

}
