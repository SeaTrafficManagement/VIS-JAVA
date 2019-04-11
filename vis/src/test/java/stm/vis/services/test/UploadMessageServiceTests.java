package stm.vis.services.test;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
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
import stm.vis.model.UploadedMessage;
import stm.vis.repository.UploadedMessageRepository;
import stm.vis.service.UploadedMessageService;
import stm.vis.service.impl.UploadedMessageServiceImpl;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class UploadMessageServiceTests {

	@Autowired
	private TestHelper helper;

	@Mock
	private UploadedMessageRepository repository;

	@InjectMocks
	private UploadedMessageService uploadedMessageService = new UploadedMessageServiceImpl();

	@Test
	public void testSaveUploadedMessage() throws Exception {
		when(this.repository.save(any(UploadedMessage.class))).then(returnsFirstArg());

		this.uploadedMessageService.saveUploadedMessage(this.helper.getDefaultIdentity(), this.helper.getDefaultSTMMessage(), null);
		this.uploadedMessageService.saveUploadedMessage(this.helper.getDefaultIdentity(), this.helper.getDefaultSTMMessage(), new URI("http://delivery.ack.endpoint"));
	}

}
