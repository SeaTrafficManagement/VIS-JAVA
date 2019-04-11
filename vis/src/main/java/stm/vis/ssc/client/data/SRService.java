package stm.vis.ssc.client.data;

public class SRService {
	private String comment = null;
	private String endpointType = null;
	private String endpointUri = null;
	private ServiceDefinition instanceAsXml = null;
	private String instanceId = null;
	private String keywords = null;
	private String name = null;
	private String organizationId = null;
	private String status = null;
	private String unlocode = null;
	private String version = null;

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEndpointType() {
		return this.endpointType;
	}

	public void setEndpointType(String endpointType) {
		this.endpointType = endpointType;
	}

	public String getEndpointUri() {
		return this.endpointUri;
	}

	public void setEndpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
	}

	public ServiceDefinition getInstanceAsXml() {
		return this.instanceAsXml;
	}

	public void setInstanceAsXml(ServiceDefinition instanceAsXml) {
		this.instanceAsXml = instanceAsXml;
	}

	public String getInstanceId() {
		return this.instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnlocode() {
		return this.unlocode;
	}

	public void setUnlocode(String unlocode) {
		this.unlocode = unlocode;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public static class ServiceDefinition {
		private String comment = null;
		private String content = null;
		private String contentContentType = null;
		private Long id = null;
		private String name = null;

		public String getComment() {
			return this.comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getContent() {
			return this.content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getContentContentType() {
			return this.contentContentType;
		}

		public void setContentContentType(String contentContentType) {
			this.contentContentType = contentContentType;
		}

		public Long getId() {
			return this.id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
