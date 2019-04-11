package STMMessage.RTZ;


/**
 * RTZ files contain a number of waypoints, followed with auxiliary schedules.
 *        You can add your own elements to the extension section of the RTZ
 * document.
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class route {

	/**
	 * 
	 *            You can add extend RTZ by adding your own elements from another
	 * schema
	 *            here.
	 *          
	 */
	public Extensions extensions;
	/**
	 * 
	 *            Generic route information.
	 *          
	 */
	public RouteInfo routeInfo;
	/**
	 * 
	 *            Optional list of schedules.
	 *          
	 */
	public Schedules schedules;
	/**
	 * 
	 *            A list of waypoints.
	 *          
	 */
	public Waypoints waypoints;
	/**
	 * 
	 *          Format version (currently "1.0").
	 *        
	 */
	public string version;
	public Schedules m_Schedules;
	public Waypoints m_Waypoints;
	public RouteInfo m_RouteInfo;

	public route(){

	}

	public void finalize() throws Throwable {

	}
}//end route