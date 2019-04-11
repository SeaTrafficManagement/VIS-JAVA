package stm.vis.data.messages;

/**
 * 
 * @author aheredia
 *
 */
public enum RouteStatus {

	ORIGINAL(1), PLANNED_FOR_VOYAGE(2), OPTIMIZED(3), CROSS_CHECKED(4), SAFETY_CHECKED(5), APPROVED(6), USED_FOR_MONITORING(7), INACTIVE(8);

	private int value;

	private RouteStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public static RouteStatus fromValue(String value) {
		RouteStatus routeStatus = null;
		try {
			int intValue = Integer.parseInt(value);
			routeStatus = fromValue(intValue);
		} catch (NumberFormatException e) {
			// IGNORE
		}
		return routeStatus;
	}

	public static RouteStatus fromValue(int value) {
		RouteStatus routeStatus = null;
		try {
			for (RouteStatus status : RouteStatus.values()) {
				if (status.getValue() == value) {
					routeStatus = status;
					break;
				}
			}
		} catch (NumberFormatException e) {
			// IGNORE
		}
		return routeStatus;
	}
}
