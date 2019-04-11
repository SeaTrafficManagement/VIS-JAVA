package STMMessage.RTZ;


/**
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class ScheduleElement {

	/**
	 * 
	 *          Absolute fuel saving after optimization.
	 *        
	 */
	public decimal absFuelSace;
	/**
	 * Current direction in degrees.
	 */
	public CourseType currentDirection;
	/**
	 * Current speed in knots.
	 */
	public SpeedType currentSpeed;
	/**
	 * 
	 *          UTC estimated arrival time in ISO 8601 format.
	 *        
	 */
	public dateTime eta;
	/**
	 * 
	 *          Describes the uncertainty of the predicted ETA after optimization.
	 *        
	 */
	public time etaWindowAfter;
	/**
	 * 
	 *          Describes the uncertainty of the predicted ETA after optimization.
	 *        
	 */
	public time etaWindowBefore;
	/**
	 * 
	 *          UTC estimated departure time in ISO 8601 format.
	 *        
	 */
	public dateTime etd;
	/**
	 * 
	 *          Describes the uncertainty of the predicted ETD after optimization.
	 *        
	 */
	public time etdWindowAfter;
	/**
	 * 
	 *          Describes the uncertainty of the predicted ETD after optimization.
	 *        
	 */
	public time etdWindowBefore;
	/**
	 * 
	 *            You can add extend RTZ by adding your own elements from another
	 * schema
	 *            here.
	 *          
	 */
	public Extensions extensions;
	/**
	 * Predicted fuel consumption on leg.
	 */
	public decimal fuel;
	public string Note;
	/**
	 * Advised Engine Pitch.
	 */
	public integer pitch;
	/**
	 * 
	 *          Relative fuel saving after optimization in percent.
	 *        
	 */
	public decimal relFuelSave;
	/**
	 * Advised Engine RPM.
	 */
	public nonNegativeInteger rpm;
	/**
	 * True speed in knots.
	 */
	public SpeedType speed;
	/**
	 * 
	 *         Describes the uncertainty of the predicted speed after optimization in
	 * knots.
	 *        
	 */
	public decimal speedWindow;
	/**
	 * Stay time on WP.
	 */
	public time stay;
	/**
	 * Total speed loss.
	 */
	public SpeedType totalLoss;
	/**
	 * Speed loss caused by wave.
	 */
	public SpeedType waveLoss;
	/**
	 * Unique waypoint identifier.
	 */
	public nonNegativeInteger waypointId;
	/**
	 * True wind direction in degrees.
	 */
	public CourseType windDirection;
	/**
	 * Speed loss caused by wind in knots.
	 */
	public SpeedType windLoss;
	/**
	 * True wind speed in metres per second.
	 */
	public SpeedType windSpeed;

	public ScheduleElement(){

	}

	public void finalize() throws Throwable {

	}
}//end ScheduleElement