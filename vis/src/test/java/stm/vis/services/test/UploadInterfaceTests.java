package stm.vis.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import stm.vis.TestApplication;
import stm.vis.data.ResponseObject;
import stm.vis.data.StatusCode;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.route.Route;
import stm.vis.data.textMessage.TextMessage;
import stm.vis.exception.MessageValidationException;
import stm.vis.model.Identity;
import stm.vis.model.Schema;
import stm.vis.model.UploadedMessage;
import stm.vis.service.MessageParser;
import stm.vis.service.MessageValidator;
import stm.vis.service.SchemaService;
import stm.vis.service.UploadedMessageService;
import stm.vis.service.VISInternalInterface;
import stm.vis.service.VISUploadInterface;
import stm.vis.service.impl.VISUpload;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class UploadInterfaceTests {

	@Autowired
	private TestHelper helper;

	@Mock
	private MessageParser parser;

	@Mock
	private MessageValidator validator;

	@Mock
	private SchemaService schemaService;

	@Mock
	private UploadedMessageService uploadedMessageService;

	@Mock
	private VISInternalInterface internalService;

	@InjectMocks
	private VISUploadInterface service = new VISUpload();

	@Test
	public void testUploadVoyagePlan() throws Exception {
		when(this.parser.getRouteFromMessage(any(STMMessage.class))).thenReturn(this.helper.getDefaultRoute());
		when(this.parser.getMessageFromRoute(any(Route.class))).thenReturn(this.helper.getDefaultSTMMessage());
		when(this.uploadedMessageService.saveUploadedMessage(any(Identity.class), any(STMMessage.class), any(URI.class))).thenReturn(this.helper.getDefaultUploadedMessage());

		ResponseObject response = this.service.uploadVoyagePlan(this.helper.getDefaultSourceIdentity(), this.helper.getDefaultSTMMessage(), "http://delivery.ack.endpoint", "http://callback.endpoint");
		assertNotNull(response);
		assertEquals(StatusCode.OK, response.getStatusCode());
	}

	@Test
	public void testUploadVoyagePlanWithError() throws Exception {
		doThrow(new MessageValidationException("message-validation-exception")).when(this.validator).validateMessage(any(STMMessage.class), any(Schema.class));

		ResponseObject response = this.service.uploadVoyagePlan(this.helper.getDefaultSourceIdentity(), this.helper.getDefaultSTMMessage(), "http://delivery.ack.endpoint", "http://callback.endpoint");
		assertNotNull(response);
		assertEquals(StatusCode.SCHEMA_NOK, response.getStatusCode());
	}

	@Test
	public void testUploadTextMessage() throws Exception {
		when(this.parser.getMessageFromTextMessage(any(TextMessage.class))).thenReturn(this.helper.getDefaultSTMMessage());
		when(this.uploadedMessageService.saveUploadedMessage(any(Identity.class), any(STMMessage.class), any(URI.class))).thenReturn(this.helper.getDefaultUploadedMessage());

		ResponseObject response = this.service.uploadTextMessage(this.helper.getDefaultSourceIdentity(), this.helper.getDefaultTextMessageAsJSON(), "http://delivery.ack.endpoint");
		assertNotNull(response);
		assertEquals(StatusCode.OK, response.getStatusCode());
	}

	@Test
	public void testUploadTextMessageWithError() throws Exception {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.TXTMSG);
		message.setData("mock-textMessage-data".getBytes());
		UploadedMessage uploadedMessage = new UploadedMessage();
		uploadedMessage.setId(1L);

		when(this.parser.getMessageFromTextMessage(any(TextMessage.class))).thenThrow(new MessageValidationException("exception-message"));

		ResponseObject response = this.service.uploadTextMessage(this.helper.getDefaultSourceIdentity(), this.helper.getDefaultTextMessageAsJSON(), "http://delivery.ack.endpoint");
		assertNotNull(response);
		assertEquals(StatusCode.SCHEMA_NOK, response.getStatusCode());
	}

	@Test
	public void testUploadPolygon() throws Exception {
		// TODO Implement test
	}

	@Test
	public void testUploadPolygonWithError() throws Exception {
		// TODO Implement test
	}

}
