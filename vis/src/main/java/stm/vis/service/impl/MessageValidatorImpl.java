package stm.vis.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.STMMessage;
import stm.vis.exception.MessageValidationException;
import stm.vis.model.Schema;
import stm.vis.service.MessageValidator;

@Service
public class MessageValidatorImpl implements MessageValidator {

	@Override
	public void validateMessage(STMMessage message, Schema schema) throws MessageValidationException {
		if (schema == null) {
			throw new MessageValidationException("No schema provided");
		}

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			javax.xml.validation.Schema validationSchema = factory.newSchema(this.getSources(schema, message.getMessageType() != MessageType.RTZ));
			Validator validator = validationSchema.newValidator();
			validator.validate(new StreamSource(new ByteArrayInputStream(message.getData())));
		} catch (IOException | SAXException e) {
			throw new MessageValidationException(e.getMessage(), e);
		}
	}

	private Source[] getSources(Schema schema, boolean relatedFirst) {
		ArrayList<Source> sources = new ArrayList<>();
		if (schema.getRelatedSchemas() != null && relatedFirst) {
			for (Schema relatedSchema : schema.getRelatedSchemas()) {
				sources.add(new StreamSource(new ByteArrayInputStream(relatedSchema.getSchema())));
			}
		}
		sources.add(new StreamSource(new ByteArrayInputStream(schema.getSchema())));
		if (schema.getRelatedSchemas() != null && !relatedFirst) {
			for (Schema relatedSchema : schema.getRelatedSchemas()) {
				sources.add(new StreamSource(new ByteArrayInputStream(relatedSchema.getSchema())));
			}
		}
		return sources.toArray(new Source[sources.size()]);
	}

}
