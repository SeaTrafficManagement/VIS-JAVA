package stm.vis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * ACL objects for each information/data object.
 * @author aheredia
 */
@Entity
@Table(name = "aclobject")
public class ACLObject {

	/**
	 * Unique internal ID
	 */
	@Id
	@TableGenerator(name = "ACLOBJECT_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ACLOBJECT_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ACLOBJECT_ID_GEN")
	@Column(name = "id")
	private Long id;

	/**
	 * Reference to data related to the ACL object
	 */
	@Column(name = "message_id", unique = true)
	private String message;

	/**
	 * Identities that have access to the information object
	 */
	@ManyToMany
	@JoinTable(name = "aclobject_identity", joinColumns = @JoinColumn(name = "aclobject_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "identity_id", referencedColumnName = "id"))
	private List<Identity> identities = new ArrayList<>();

	/**
	 * Time of last update
	 */
	@Column(name = "")
	private Date lastUpdateTime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Identity> getIdentities() {
		return this.identities;
	}

	public void setIdentities(List<Identity> identities) {
		this.identities = identities;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
