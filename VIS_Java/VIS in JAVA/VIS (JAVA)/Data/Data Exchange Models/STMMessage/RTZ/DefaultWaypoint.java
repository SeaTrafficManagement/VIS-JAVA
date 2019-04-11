package STMMessage.RTZ;


/**
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:01
 */
public class DefaultWaypoint {

	/**
	 * 
	 *            You can add extend RTZ by adding your own elements from another
	 * schema
	 *            here.
	 *          
	 */
	public Extensions extensions;
	/**
	 * Leg attributes.
	 */
	public Leg leg;
	/**
	 * Turn radius in NM.
	 */
	public RadiusType radius;
	public Leg m_Leg;

	public DefaultWaypoint(){

	}

	public void finalize() throws Throwable {

	}
}//end DefaultWaypoint