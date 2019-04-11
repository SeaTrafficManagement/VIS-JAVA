package stm.vis.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Code 200 + <Voyage Plan in RTZ>
 * Code 20x + message="No voyage plan published"
 * Code 20x + message="Identity <requesterIdentity> is not authorized"
 * @author aheredia
 */
public class GetVPResponseObject {

	/**
	 * Status code (20x, 40x)
	 */
	private StatusCode code;

	/**
	 * Last interaction time with ship or ship representative
	 */
	private Date lastInteractionTime;

	/**
	 * Message e.g. error text
	 */
	private String subject;

	/**
	 * The voyage plan message in RTZ format (xml)s
	 */
	private List<String> routeMessages = new ArrayList<>();

	public StatusCode getCode() {
		return this.code;
	}

	public void setCode(StatusCode code) {
		this.code = code;
	}

	public Date getLastInteractionTime() {
		return this.lastInteractionTime;
	}

	public void setLastInteractionTime(Date lastInteractionTime) {
		this.lastInteractionTime = lastInteractionTime;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getRouteMessages() {
		return routeMessages;
	}
	
	public void setRouteMessages(List<String> routeMessages) {
		this.routeMessages = routeMessages;
	}
	
}
