package STMMessage.RTZ;


/**
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:04
 */
public class Waypoints {

	/**
	 * Waypoint defaults.
	 */
	public DefaultWaypoint defaultWaypoint;
	/**
	 * 
	 *            You can add extend RTZ by adding your own elements from another
	 * schema
	 *            here.
	 *          
	 */
	public Extensions extensions;
	/**
	 * Waypoint details.
	 */
	public Waypoint waypoint;
	public DefaultWaypoint m_DefaultWaypoint;
	public Waypoint m_Waypoint;

	public Waypoints(){

	}

	public void finalize() throws Throwable {

	}
}//end Waypoints