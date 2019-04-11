package stm.vis.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doThrow;
// import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Collections;

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
import stm.vis.data.messages.Messages;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.route.Route;
import stm.vis.exception.MessageParseException;
import stm.vis.exception.MessageValidationException;
import stm.vis.model.Identity;
import stm.vis.model.Schema;
import stm.vis.model.UploadedMessage;
import stm.vis.service.AclService;
import stm.vis.service.AsyncService;
import stm.vis.service.MessageParser;
import stm.vis.service.MessageValidator;
import stm.vis.service.PublishedMessagesService;
import stm.vis.service.SchemaService;
import stm.vis.service.SubscriptionService;
import stm.vis.service.UploadedMessageService;
import stm.vis.service.VISInternalInterface;
import stm.vis.service.VISPrivateInterface;
import stm.vis.service.impl.VISPrivate;
import stm.vis.ssc.client.SscClientHelper;
import stm.vis.web.privateapi.model.Message;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class PrivateInterfaceTests {

	@Autowired
	private TestHelper helper;

	@Mock
	private VISInternalInterface internalService;

	@Mock
	private UploadedMessageService uploadedMessageService;

	@Mock
	private AclService aclService;

	@Mock
	private SchemaService schemaService;

	@Mock
	private MessageValidator messageValidator;

	@Mock
	private MessageParser parser;

	@Mock
	private PublishedMessagesService publishedMessageService;

	@Mock
	private SubscriptionService subscriptionService;

	@Mock
	private SscClientHelper sscClient;

	@Mock
	private AsyncService asyncService;

	@InjectMocks
	private VISPrivateInterface vis = new VISPrivate();

	@Test
	public void testGetMessage() {
		UploadedMessage uploadedMessage = this.helper.getDefaultUploadedMessage();

		when(this.uploadedMessageService.getUploadedMessages(any(Integer.class))).thenReturn(Collections.singletonList(uploadedMessage));
		when(this.uploadedMessageService.getRemainingNumberOfMessages()).thenReturn(5);
		when(this.uploadedMessageService.updateMessageFetched(any(UploadedMessage.class), any(Date.class))).thenReturn(uploadedMessage);

		Messages messages = this.vis.getMessages(1);
		assertNotNull(messages);
		assertEquals(1, messages.getNumberOfMessages());
		assertEquals(5, messages.getRemainingNumberOfMessages());
		assertEquals(1, messages.getMessages().size());

		stm.vis.data.messages.VISMessage message = messages.getMessages().get(0);
		assertEquals(uploadedMessage.getId().toString(), message.getId());
		assertEquals(uploadedMessage.getFrom(), message.getFrom());
		assertEquals(uploadedMessage.getReceiveTime(), message.getReceivedAt());
		assertEquals(uploadedMessage.getMessageType(), message.getMessageType());
		assertEquals(new String(uploadedMessage.getMessage()), new String(message.getMessage()));
	}

	@Test
	public void testPublishMessage() throws Exception {
		Message message = this.helper.getDefaultMessage();

		when(this.publishedMessageService.saveRouteMessage(any(String.class), any(Route.class), any(Schema.class))).thenReturn(this.helper.getDefaultPublishedMessage());
		when(this.parser.getRouteFromMessage(any(STMMessage.class))).thenReturn(this.helper.getDefaultRoute());

		ResponseObject response = this.vis.publishMessage(message.getId(), MessageType.RTZ.name(), message.getStmMessage().getMessage());
		assertNotNull(response);
		assertEquals(StatusCode.OK, response.getStatusCode());
	}

	@Test
	public void testPublishMessageErrorMessageValidation() throws Exception {
		Message message = this.helper.getDefaultMessage();

		doThrow(new MessageValidationException("message-validation-exception")).when(this.messageValidator).validateMessage(any(STMMessage.class), any(Schema.class));

		ResponseObject response = this.vis.publishMessage(message.getId(), MessageType.RTZ.name(), message.getStmMessage().getMessage());
		assertNotNull(response);
		assertEquals(StatusCode.SCHEMA_NOK, response.getStatusCode());
	}

	@Test
	public void testPublishMessageErrorMessageParse() throws Exception {
		Message message = this.helper.getDefaultMessage();

		when(this.parser.getRouteFromMessage(any(STMMessage.class))).thenThrow(new MessageParseException("message-parse-exception"));

		ResponseObject response = this.vis.publishMessage(message.getId(), MessageType.RTZ.name(), message.getStmMessage().getMessage());
		assertNotNull(response);
		assertEquals(StatusCode.SCHEMA_NOK, response.getStatusCode());
	}

	@Test
	public void testAuthorizeIdentities() {
		when(this.aclService.createACL(any(String.class), anyListOf(Identity.class))).thenReturn(this.helper.getDefaultAclObject());

		ResponseObject response = this.vis.authorizeIdentities(Collections.singletonList(this.helper.getDefaultIdentity()), "data-id");
		assertNotNull(response);
		assertEquals(StatusCode.OK, response.getStatusCode());
	}

}
