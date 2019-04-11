package STMMessage.RTZ;


/**
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:02
 */
public class Leg {

	/**
	 * Static draught aft in metres.
	 */
	public LengthType draughtAft;
	/**
	 * Static draught forward in metres.
	 */
	public LengthType draughtForward;
	/**
	 * Minimum dynamic UKC on the leg.
	 */
	public LengthType dynamicUKC;
	/**
	 * Geometry type of leg.
	 */
	public GeometryType geometryType;
	/**
	 * Nice to know.
	 */
	public string legInfo;
	/**
	 * Notes regarding the ETD/ETA.
	 */
	public string legNote1;
	/**
	 * Local remarks.
	 */
	public string legNote2;
	/**
	 * Reporting information.
	 */
	public string legReport;
	/**
	 * Height of masthead.
	 */
	public LengthType masthead;
	/**
	 * Portside XTE in NM.
	 */
	public XtdType portsideXTD;
	/**
	 * Safety contour in metres.
	 */
	public LengthType safetyContour;
	/**
	 * Safety depth in metres.
	 */
	public LengthType safetyDepth;
	/**
	 * Highest allowed speed in knots.
	 */
	public SpeedType speedMax;
	/**
	 * Lowest cruising speed in knots.
	 */
	public SpeedType speedMin;
	/**
	 * Starboard XTE in NM.
	 */
	public XtdType starboardXTD;
	/**
	 * Minimum UKC on the leg.
	 */
	public LengthType staticUKC;

	public Leg(){

	}

	public void finalize() throws Throwable {

	}
}//end Leg