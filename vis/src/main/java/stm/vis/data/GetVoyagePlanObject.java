package stm.vis.data;

import stm.vis.data.messages.RouteStatus;

public class GetVoyagePlanObject {
	private SourceIdentity sourceIdentity;
	private String uvid;
	private RouteStatus routeStatus;

	public SourceIdentity getSourceIdentity() {
		return this.sourceIdentity;
	}

	public void setSourceIdentity(SourceIdentity sourceIdentity) {
		this.sourceIdentity = sourceIdentity;
	}

	public String getUvid() {
		return this.uvid;
	}

	public void setUvid(String uvid) {
		this.uvid = uvid;
	}

	public RouteStatus getRouteStatus() {
		return this.routeStatus;
	}

	public void setRouteStatus(RouteStatus routeStatus) {
		this.routeStatus = routeStatus;
	}

}
