package STMMessage.RTZ;


/**
 * Schedule definition.
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class Schedule {

	/**
	 * 
	 *            Calculated schedules.
	 *          
	 */
	public Calculated calculated;
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
	 *          Schedule name.
	 *        
	 */
	public nonNegativeInteger id;
	/**
	 * 
	 *            Manual schedule values definition.
	 *          
	 */
	public Manual manual;
	/**
	 * 
	 *          Schedule name.
	 *        
	 */
	public string name;
	public Manual m_Manual;
	public Calculated m_Calculated;

	public Schedule(){

	}

	public void finalize() throws Throwable {

	}
}//end Schedule