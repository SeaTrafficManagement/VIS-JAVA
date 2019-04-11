package stm.vis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "event_type")
public class EventType {

	/**
	 * Type of event (enumeration)
	 */
	@Id
	@TableGenerator(name = "EVENT_TYPE_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "EVENT_TYPE_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "EVENT_TYPE_ID_GEN")
	@Column(name = "id")
	private Integer eventType;

	/**
	 * Name on event type
	 */
	@Column(name = "name")
	private String eventTypeName;

	/**
	 * Description of the event type
	 */
	@Column(name = "description")
	private String eventTypeDescription;

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public String getEventTypeName() {
		return eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	public String getEventTypeDescription() {
		return eventTypeDescription;
	}

	public void setEventTypeDescription(String eventTypeDescription) {
		this.eventTypeDescription = eventTypeDescription;
	}

}
