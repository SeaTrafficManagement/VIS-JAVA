package stm.vis.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stm.vis.data.area.DatasetType;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.route.Route;
import stm.vis.data.textMessage.TextMessage;
import stm.vis.exception.MessageParseException;
import stm.vis.exception.MessageValidationException;
import stm.vis.service.MessageParser;
import stm.vis.service.MessageValidator;
import stm.vis.service.SchemaService;

@Service
public class MessageParserImpl implements MessageParser {

	@Autowired
	private MessageValidator validator;

	@Autowired
	private SchemaService schemaService;

	@Override
	public Route getRouteFromMessage(byte[] data) throws MessageParseException {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.RTZ);
		message.setData(data);
		return this.getRouteFromMessage(message);
	}

	@Override
	public Route getRouteFromMessage(STMMessage message) throws MessageParseException {
		try {
			JAXBContext jc = JAXBContext.newInstance(Route.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object object = unmarshaller.unmarshal(new ByteArrayInputStream(message.getData()));
			return (Route) JAXBIntrospector.getValue(object);
		} catch (JAXBException e) {
			throw new MessageParseException("Error parsing message to Route: " + e.getMessage(), e);
		}
	}

	@Override
	public TextMessage getTextMessageFromMessage(byte[] data) throws MessageParseException {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.TXTMSG);
		message.setData(data);
		return this.getTextMessageFromMessage(message);
	}

	@Override
	public TextMessage getTextMessageFromMessage(STMMessage message) throws MessageParseException {
		try {
			JAXBContext jc = JAXBContext.newInstance(TextMessage.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object object = unmarshaller.unmarshal(new ByteArrayInputStream(message.getData()));
			return (TextMessage) JAXBIntrospector.getValue(object);
		} catch (JAXBException e) {
			throw new MessageParseException("Error parsing message to TextMessage: " + e.getMessage(), e);
		}
	}

	@Override
	public DatasetType getPolygonFromMessage(byte[] data) throws MessageParseException {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.S124);
		message.setData(data);
		return this.getPolygonFromMessage(message);
	}

	@Override
	public DatasetType getPolygonFromMessage(STMMessage message) throws MessageParseException {
		try {
			JAXBContext jc = JAXBContext.newInstance(DatasetType.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object object = unmarshaller.unmarshal(new ByteArrayInputStream(message.getData()));
			return (DatasetType) JAXBIntrospector.getValue(object);
		} catch (JAXBException e) {
			throw new MessageParseException("Error parsing message to Polygon: " + e.getMessage(), e);
		}
	}

	@Override
	public STMMessage getMessageFromRoute(Route voyagePlan) throws MessageParseException, MessageValidationException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		STMMessage message = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(Route.class);
			JAXBElement<Route> element = (new stm.vis.data.route.ObjectFactory()).createRoute(voyagePlan);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(element, os);

			message = new STMMessage();
			message.setMessageType(MessageType.RTZ);
			message.setData(os.toByteArray());

			this.validator.validateMessage(message, this.schemaService.getRouteSchema());
		} catch (JAXBException e) {
			throw new MessageParseException("Error marshalling voyage plan: " + e.getMessage(), e);
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public STMMessage getMessageFromTextMessage(TextMessage textMessage) throws MessageParseException, MessageValidationException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		STMMessage message = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(TextMessage.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(textMessage, os);

			message = new STMMessage();
			message.setMessageType(MessageType.TXTMSG);
			message.setData(os.toByteArray());

			this.validator.validateMessage(message, this.schemaService.getTextMessageSchema());
		} catch (JAXBException e) {
			throw new MessageParseException("Error marshalling text message: " + e.getMessage(), e);
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public STMMessage getMessageFromPolygon(DatasetType polygon) throws MessageParseException, MessageValidationException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		STMMessage message = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(DatasetType.class);
			JAXBElement<DatasetType> element = (new stm.vis.data.area.ObjectFactory()).createDataSet(polygon);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(element, os);

			message = new STMMessage();
			message.setMessageType(MessageType.S124);
			message.setData(os.toByteArray());

			this.validator.validateMessage(message, this.schemaService.getPolygonSchema());
		} catch (JAXBException e) {
			throw new MessageParseException("Error marshalling polygon: " + e.getMessage(), e);
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

}
