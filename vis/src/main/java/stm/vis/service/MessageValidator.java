package stm.vis.service;

import stm.vis.data.messages.STMMessage;
import stm.vis.exception.MessageValidationException;
import stm.vis.model.Schema;

public interface MessageValidator {

	void validateMessage(STMMessage message, Schema schema) throws MessageValidationException;

}
