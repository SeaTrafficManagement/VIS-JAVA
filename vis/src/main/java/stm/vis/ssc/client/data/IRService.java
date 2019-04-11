package stm.vis.ssc.client.data;

import java.util.Date;
import java.util.List;

public class IRService {
	private VISOrganization owner;
	private Date createdAt;
	private Date updatedAt;
	private String mrn;
	private String permissions;
	private String name;
	private String certDomainName;
	private List<Certificate> certificates;

	public VISOrganization getOwner() {
		return this.owner;
	}

	public void setOwner(VISOrganization owner) {
		this.owner = owner;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getMrn() {
		return this.mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public String getPermissions() {
		return this.permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertDomainName() {
		return this.certDomainName;
	}

	public void setCertDomainName(String certDomainName) {
		this.certDomainName = certDomainName;
	}

	public List<Certificate> getCertificates() {
		return this.certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

}
