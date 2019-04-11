package stm.vis.service;

import stm.vis.data.GetVPResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.data.messages.RouteStatus;
import stm.vis.exception.VISException;

public interface VISGetInterface {

	/**
	 * Returns active voyage plans according to parameters that the requester is authorized to. The response can contain 0 or more (0..*) voyage plans, but only 0 or one (0..1) voyage plan with same UVID.
	 * An active voyage is a voyage plan with routeStatus not equal 8.
	 * Will return the latest published voyage plan with routeStatus not equal 8,for each UVID (vesselVoyage). If two or more voyage plans have routeStatus=7, only the latest published voyage plan for each ship shall be returned.
	 * If not authorized, a message will be returned and a message will be sent on private side as a authorization request.
	 * Also returns “Last known time” with interaction on private side. The intention is to give a consumer a possibility to assess validity of given voyage plan(s) if the e.g. ship is offline.
	 * 
	 * @param sourceIdentity
	 * @param uvid
	 * @param routeStatus
	 * @return the voyage plan
	 */
	GetVPResponseObject getVoyagePlans(SourceIdentity sourceIdentity, String uvid, RouteStatus routeStatus) throws VISException;

}
