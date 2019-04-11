package stm.vis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "event_data_type")
public class EventDataType {

	/**
	 * Type of event data (enumeration)
	 */
	@Id
	@TableGenerator(name = "EVENT_DATA_TYPE_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "EVENT_DATA_TYPE_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "EVENT_DATA_TYPE_ID_GEN")
	@Column(name = "id")
	private Integer eventDataType;

	/**
	 * Name on event data type
	 */
	@Column(name = "name")
	private String eventDataTypeName;

	/**
	 * Description of the event data type
	 */
	@Column(name = "description")
	private String eventDataTypeDescription;

	public Integer getEventDataType() {
		return eventDataType;
	}

	public void setEventDataType(Integer eventDataType) {
		this.eventDataType = eventDataType;
	}

	public String getEventDataTypeName() {
		return eventDataTypeName;
	}

	public void setEventDataTypeName(String eventDataTypeName) {
		this.eventDataTypeName = eventDataTypeName;
	}

	public String getEventDataTypeDescription() {
		return eventDataTypeDescription;
	}

	public void setEventDataTypeDescription(String eventDataTypeDescription) {
		this.eventDataTypeDescription = eventDataTypeDescription;
	}

}
