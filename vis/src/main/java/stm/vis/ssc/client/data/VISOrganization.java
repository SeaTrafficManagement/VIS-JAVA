package stm.vis.ssc.client.data;

import java.util.Date;
import java.util.List;

public class VISOrganization {

	private Date createdAt;
	private Date updatedAt;
	private String name;
	private String mrn;
	private String email;
	private String url;
	private String address;
	private String country;
	private String federationType;
	private List<Certificate> certificates;
	private List<Attribute> identityProviderAttributes;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMrn() {
		return this.mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getFederationType() {
		return federationType;
	}
	
	public void setFederationType(String federationType) {
		this.federationType = federationType;
	}

	public List<Certificate> getCertificates() {
		return this.certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public List<Attribute> getIdentityProviderAttributes() {
		return this.identityProviderAttributes;
	}

	public void setIdentityProviderAttributes(List<Attribute> identityProviderAttributes) {
		this.identityProviderAttributes = identityProviderAttributes;
	}

}
