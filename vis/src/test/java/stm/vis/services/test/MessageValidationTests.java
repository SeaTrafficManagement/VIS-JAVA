package stm.vis.services.test;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import stm.vis.TestApplication;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.STMMessage;
import stm.vis.model.Schema;
import stm.vis.service.MessageValidator;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class MessageValidationTests {

	private static final String SCHEMAS_RTZ_XSD = "schemas/rtz_format_1_1_29032017.xsd";
	private static final String SCHEMAS_RTZ_STM_EXTENSIONS = "schemas/stm_extensions_29032017.xsd";
	private static final String SCHEMAS_TEXT_MESSAGE_XSD = "schemas/textMessageSchema_1_33.xsd";
	private static final String SCHEMAS_AREA_XSD = "schemas/S1241.xsd";
	private static final String SCHEMAS_AREA_GML_BASE = "schemas/s100gmlbase.xsd";
	private static final String SCHEMAS_AREA_GML_PROFILE = "schemas/S100_gmlProfile.xsd";
	private static final String SCHEMAS_AREA_GML_PROFILE_LEVELS = "schemas/S100_gmlProfileLevels.xsd";

	@Autowired
	private MessageValidator validator;

	@Test
	public void testValidateRoute() throws Exception {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.RTZ);
		message.setData(this.getBytes("rtz_route_stm.xml"));
		
		this.validator.validateMessage(message, this.getRtzSchema());
	}

	@Test
	public void testValidateTextMessage() throws Exception {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.TXTMSG);
		message.setData(this.getBytes("TXT1_3.xml"));
		Schema schema = new Schema();
		schema.setSchema(this.getBytes(SCHEMAS_TEXT_MESSAGE_XSD));
		this.validator.validateMessage(message, schema);
	}

	@Test
	public void testValidateArea() throws Exception {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.S124);
		message.setData(this.getBytes("DK_034_17.xml"));
		this.validator.validateMessage(message, this.getAreaSchema());

		message.setData(this.getBytes("ES_030_17.xml"));
		this.validator.validateMessage(message, this.getAreaSchema());

		message.setData(this.getBytes("RU_057_17.xml"));
		this.validator.validateMessage(message, this.getAreaSchema());

		message.setData(this.getBytes("RU_060_17_sector.xml"));
		this.validator.validateMessage(message, this.getAreaSchema());

		message.setData(this.getBytes("SE_037_16.xml"));
		this.validator.validateMessage(message, this.getAreaSchema());

		message.setData(this.getBytes("SE_045_17.xml"));
		this.validator.validateMessage(message, this.getAreaSchema());
	}

	private byte[] getBytes(String fileName) throws IOException {
		Resource resource = new ClassPathResource(fileName);
		return FileCopyUtils.copyToByteArray(resource.getInputStream());
	}

	private Schema getRtzSchema() throws IOException {
		Schema stmExtensionsSchema = new Schema();
		stmExtensionsSchema.setSchema(this.getBytes(SCHEMAS_RTZ_STM_EXTENSIONS));

		Schema schema = new Schema();
		schema.setSchema(this.getBytes(SCHEMAS_RTZ_XSD));
		schema.setRelatedSchemas(new ArrayList<>());
		schema.getRelatedSchemas().add(stmExtensionsSchema);
		return schema;
	}

	private Schema getAreaSchema() throws IOException {
		Schema gmlProfileSchema = new Schema();
		gmlProfileSchema.setSchema(this.getBytes(SCHEMAS_AREA_GML_PROFILE));
		Schema gmlProfileLevelsSchema = new Schema();
		gmlProfileLevelsSchema.setSchema(this.getBytes(SCHEMAS_AREA_GML_PROFILE_LEVELS));
		Schema gmlBaseSchema = new Schema();
		gmlBaseSchema.setSchema(this.getBytes(SCHEMAS_AREA_GML_BASE));

		Schema schema = new Schema();
		schema.setSchema(this.getBytes(SCHEMAS_AREA_XSD));
		schema.setRelatedSchemas(new ArrayList<>());
		schema.getRelatedSchemas().add(gmlProfileSchema);
		schema.getRelatedSchemas().add(gmlProfileLevelsSchema);
		schema.getRelatedSchemas().add(gmlBaseSchema);
		return schema;
	}
}
