package stm.vis.service;

import stm.vis.data.SourceIdentity;
import stm.vis.exception.VISException;
import stm.vis.web.publicapi.model.DeliveryAck;

public interface AcknowledgementService {

	void acknowledgementReceived(DeliveryAck deliveryAck, SourceIdentity identity) throws VISException;

}
