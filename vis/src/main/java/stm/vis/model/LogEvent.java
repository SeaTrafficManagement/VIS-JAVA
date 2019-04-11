package stm.vis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Contains event log for evaluation of STM
 * 
 * @author aheredia
 *
 */
@Entity
@Table(name = "log_event")
public class LogEvent {

	/**
	 * Unique internal id
	 */
	@Id
	@TableGenerator(name = "LOGEVENT_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "LOGEVENT_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "LOGEVENT_ID_GEN")
	@Column(name = "uid")
	private Long uid;

	/**
	 *  Timestamp of log, DateTime in UTC (e.g. 2017-03-29T11:33:00Z)
	 */
	@Column(name = "time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	/**
	 *  ID of the service instance generating the log in MRN format
	 */
	@Column(name = "service_instance_id")
	private String serviceInstanceId;

	/**
	 * Organisation ID for the external/opposite service instance (not my own ID)
	 */
	@Column(name = "externa_org_id")
	private String externalOrgId;

	/**
	 * Entity ID of the external/opposite service instance (not my own ID)
	 */
	@Column(name = "external_entity_id")
	private String externalEntityId;

	/**
	 * Eventnumber according to list.
	 */
	@ManyToOne
	@JoinColumn(name = "event_number")
	private EventNumber eventNumber;

	/**
	 * Type of event according to list
	 */
	@ManyToOne
	@JoinColumn(name = "event_type")
	private EventType eventType;

	/**
	 * Attached parameters to the event in pair key:value or text/xml
	 */
	@Column(name = "event_parameters")
	private String eventParameters;

	/**
	 * Type of event data stored according to list
	 */
	@ManyToOne
	@JoinColumn(name = "event_data_type")
	private EventDataType eventDataType;

	/**
	 * Attached pay load data to the event according to eventDataType
	 */
	@Column(name = "event_data")
	private String eventData;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getServiceInstanceId() {
		return serviceInstanceId;
	}

	public void setServiceInstanceId(String serviceInstanceId) {
		this.serviceInstanceId = serviceInstanceId;
	}

	public String getExternalOrgId() {
		return externalOrgId;
	}

	public void setExternalOrgId(String externalOrgId) {
		this.externalOrgId = externalOrgId;
	}

	public String getExternalEntityId() {
		return externalEntityId;
	}

	public void setExternalEntityId(String externalEntityId) {
		this.externalEntityId = externalEntityId;
	}

	public EventNumber getEventNumber() {
		return eventNumber;
	}

	public void setEventNumber(EventNumber eventNumber) {
		this.eventNumber = eventNumber;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public String getEventParameters() {
		return eventParameters;
	}

	public void setEventParameters(String eventParameters) {
		this.eventParameters = eventParameters;
	}

	public EventDataType getEventDataType() {
		return eventDataType;
	}

	public void setEventDataType(EventDataType eventDataType) {
		this.eventDataType = eventDataType;
	}

	public String getEventData() {
		return eventData;
	}

	public void setEventData(String eventData) {
		this.eventData = eventData;
	}

}
