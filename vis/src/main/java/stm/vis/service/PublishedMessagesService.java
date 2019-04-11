package stm.vis.service;

import java.util.List;

import stm.vis.data.messages.RouteStatus;
import stm.vis.data.route.Route;
import stm.vis.model.Identity;
import stm.vis.model.PublishedMessage;
import stm.vis.model.Schema;

public interface PublishedMessagesService {

	PublishedMessage saveRouteMessage(String message, Route route, Schema schema);

	List<PublishedMessage> findVoyagePlans(String uvid, RouteStatus routeStatus, Identity identity);

	/**
	 * Returns the current active voyage plans in VIS.
	 * @return
	 */
	List<PublishedMessage> findAllActiveVoyagePlans();

	void removePublishedMessage(String dataId);

}
