package STMMessage.RTZ;


/**
 * User defined schedule parameters.
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:02
 */
public class Manual {

	/**
	 * 
	 *            You can add extend RTZ by adding your own elements
	 *            from another schema here.
	 *          
	 */
	public Extensions extensions;
	/**
	 * 
	 *            Manual schedule leg definition.
	 *          
	 */
	public ScheduleElement sheduleElement;
	public ScheduleElement m_ScheduleElement;

	public Manual(){

	}

	public void finalize() throws Throwable {

	}
}//end Manual