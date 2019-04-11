package STMMessage.RTZ;


/**
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:04
 */
public class Waypoint {

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
	 *          Unique waypoint identifier.
	 *        
	 */
	public nonNegativeInteger id;
	/**
	 * Leg attributes.
	 */
	public Leg leg;
	/**
	 * 
	 *          Waypoint name.
	 *        
	 */
	public string name;
	/**
	 * Geographic point.
	 */
	public GM_Point position;
	/**
	 * 
	 *          Turn radius in NM.
	 *        
	 */
	public RadiusType radius;
	/**
	 * 
	 *          Waypoint revision. Increased on every change.
	 *        
	 */
	public nonNegativeInteger revision;
	public Leg m_Leg;

	public Waypoint(){

	}

	public void finalize() throws Throwable {

	}
}//end Waypoint