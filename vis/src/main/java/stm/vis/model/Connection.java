package stm.vis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "connection_status")
public class Connection {

	public enum ConnectionStatus {
		UNKNOWN, UNCONNECTED, CONNECTED;
	}

	/**
	 * Name on component (e.g. STM Module)
	 */
	@Id
	@Column(name = "component")
	private String component;

	/**
	 * Date and time for last interaction with STM Module.
	 */
	@Column(name = "last_interaction")
	private Date lastInteraction;

	/**
	 * Known status on connection to STM Module (ship or ship representative) -1=Unknown 0=Not connected 1=Connected
	 */
	@Column(name = "connection_status")
	@Enumerated(EnumType.STRING)
	private ConnectionStatus connectionStatus;

	public String getComponent() {
		return this.component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Date getLastInteraction() {
		return this.lastInteraction;
	}

	public void setLastInteraction(Date lastInteraction) {
		this.lastInteraction = lastInteraction;
	}

	public ConnectionStatus getConnectionStatus() {
		return this.connectionStatus;
	}

	public void setConnectionStatus(ConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

}
