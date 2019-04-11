package stm.vis.service;

import stm.vis.data.area.DatasetType;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.route.Route;
import stm.vis.data.textMessage.TextMessage;
import stm.vis.exception.MessageParseException;
import stm.vis.exception.MessageValidationException;

public interface MessageParser {

	Route getRouteFromMessage(byte[] data) throws MessageParseException;

	Route getRouteFromMessage(STMMessage message) throws MessageParseException;

	TextMessage getTextMessageFromMessage(byte[] data) throws MessageParseException;

	TextMessage getTextMessageFromMessage(STMMessage message) throws MessageParseException;

	DatasetType getPolygonFromMessage(byte[] data) throws MessageParseException;

	DatasetType getPolygonFromMessage(STMMessage message) throws MessageParseException;

	STMMessage getMessageFromRoute(Route voyagePlan) throws MessageParseException, MessageValidationException;

	STMMessage getMessageFromTextMessage(TextMessage textMessage) throws MessageParseException, MessageValidationException;

	STMMessage getMessageFromPolygon(DatasetType area) throws MessageParseException, MessageValidationException;

}
