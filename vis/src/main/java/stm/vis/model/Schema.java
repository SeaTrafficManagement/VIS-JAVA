package stm.vis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Object for schemas
 * @author aheredia
 */
@Entity
@Table(name = "schema")
public class Schema {

	/**
	 * Id of the schema
	 */
	@Id
	@TableGenerator(name = "SCHEMA_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "SCHEMA_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SCHEMA_ID_GEN")
	@Column(name = "id")
	private Long id;

	/**
	 * Name of the schema
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Schema in XSD format
	 */
	@Column(name = "schema")
	@Lob
	private byte[] schema;

	@ManyToMany
	@JoinTable(name = "schema_schema", joinColumns = @JoinColumn(name = "schema_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "related_schema_id", referencedColumnName = "id") )
	private List<Schema> relatedSchemas;

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

	public byte[] getSchema() {
		return this.schema;
	}

	public void setSchema(byte[] schema) {
		this.schema = schema;
	}

	public List<Schema> getRelatedSchemas() {
		return this.relatedSchemas;
	}

	public void setRelatedSchemas(List<Schema> relatedSchemas) {
		this.relatedSchemas = relatedSchemas;
	}

}
