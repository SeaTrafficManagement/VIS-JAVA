package STMMessage.RTZ;


/**
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class RouteInfo {

	/**
	 * 
	 *            You can add extend RTZ by adding your own elements from another
	 * schema
	 *            here.
	 *          
	 */
	public Extensions extensions;
	/**
	 * Route is optimized to meet KPI.
	 */
	public string optimizationMethod;
	/**
	 * The author of route.
	 */
	public string routeAuthor;
	/**
	 * 
	 *          Cause of route change, originator and reason.
	 *        
	 */
	public SpeedType routeChangesHistory;
	/**
	 * The name of the route.
	 */
	public string routeName;
	/**
	 * Status of route.
	 */
	public string routeStatus;
	/**
	 * 
	 *          Start of validity period in ISO 8601 format.
	 *        
	 */
	public dateTime validityPeriodStart;
	/**
	 * 
	 *          Stop of validity period in ISO 8601 format.
	 *        
	 */
	public dateTime validityPeriodStop;
	/**
	 * Cargo of ship in tons.
	 */
	public nonNegativeInteger vesselCargo;
	/**
	 * Displacement of ship in tons.
	 */
	public nonNegativeInteger vesselDisplacement;
	/**
	 * Metacentric height in metres.
	 */
	public LengthType vesselGM;
	/**
	 * IMO number of ship.
	 */
	public nonNegativeInteger vesselIMO;
	/**
	 * 
	 *          Max roll angle of ship allowed in degrees.
	 *        
	 */
	public nonNegativeInteger vesselMaxRoll;
	/**
	 * 
	 *          Ship significant wave height limit in metres.
	 *        
	 */
	public LengthType vesselMaxWave;
	/**
	 * 
	 *          Max wind speed limit of ship in metres per second.
	 *        
	 */
	public decimal vesselMaxWind;
	/**
	 * MMSI of ship.
	 */
	public nonNegativeInteger vesselMMSI;
	/**
	 * The name of ship.
	 */
	public string vesselName;
	/**
	 * 
	 *          Preferred service speed window maximum in knots.
	 *        
	 */
	public SpeedType vesselServiceMax;
	/**
	 * 
	 *          Preferred service speed window minimum in knots.
	 *        
	 */
	public SpeedType vesselServiceMin;
	/**
	 * Max speed of ship in knots.
	 */
	public SpeedType vesselSpeedMax;
	/**
	 * Number of the voyage.
	 */
	public string vesselVoyage;

	public RouteInfo(){

	}

	public void finalize() throws Throwable {

	}
}//end RouteInfo