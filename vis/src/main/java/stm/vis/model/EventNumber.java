package stm.vis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "event_number")
public class EventNumber {

	/**
	 * Number of event (enumeration)
	 */
	@Id
	@TableGenerator(name = "EVENT_NUMBER_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "EVENT_NUMBER_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "EVENT_NUMBER_ID_GEN")
	@Column(name = "id")
	private Integer eventNumber;

	/**
	 * Name on event, in case of a service it should represent a method request and response.
	 */
	@Column(name = "name")
	private String eventNumberName;

	/**
	 * Description of the event
	 */
	@Column(name = "description")
	private String eventNumberDescription;

	public Integer getEventNumber() {
		return eventNumber;
	}

	public void setEventNumber(Integer eventNumber) {
		this.eventNumber = eventNumber;
	}

	public String getEventNumberName() {
		return eventNumberName;
	}

	public void setEventNumberName(String eventNumberName) {
		this.eventNumberName = eventNumberName;
	}

	public String getEventNumberDescription() {
		return eventNumberDescription;
	}

	public void setEventNumberDescription(String eventNumberDescription) {
		this.eventNumberDescription = eventNumberDescription;
	}

}
