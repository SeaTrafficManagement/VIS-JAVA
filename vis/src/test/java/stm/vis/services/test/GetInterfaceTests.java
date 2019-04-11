package stm.vis.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import stm.vis.TestApplication;
import stm.vis.service.AclService;
import stm.vis.service.MessageParser;
import stm.vis.service.PublishedMessagesService;
import stm.vis.service.VISGetInterface;
import stm.vis.service.VISInternalInterface;
import stm.vis.service.impl.VISGet;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class GetInterfaceTests {

	@Autowired
	private TestHelper helper;

	@Mock
	private VISInternalInterface internalService;

	@Mock
	private AclService aclService;

	@Mock
	private MessageParser parser;

	@Mock
	private PublishedMessagesService publishedMessageService;

	@InjectMocks
	private VISGetInterface vis = new VISGet();

	@Test
	public void testGetVoyagePlans() throws Exception {
		// TODO Implement test
		
	}
	
//	@Test
//	public void testGetVoyagePlan() throws Exception {
//		PublishedMessage publishedMessage = new PublishedMessage();
//		Route route = this.helper.getDefaultRoute();
//
//		when(this.publishedMessageService.findVoyagePlan(any(String.class), any(RouteStatus.class), any(Identity.class))).thenReturn(publishedMessage);
//		when(this.parser.getRouteFromMessage(any(byte[].class))).thenReturn(route);
//
//		GetVPResponseObject response = this.vis.getVoyagePlan(this.helper.getDefaultSourceIdentity());
//		assertEquals(StatusCode.OK, response.getCode());
//		assertSame(route, response.getVoyagePlan());
//	}
//
//	@Test
//	public void testGetVoyagePlanNotFound() throws Exception {
//		when(this.publishedMessageService.findVoyagePlan(any(String.class), any(RouteStatus.class), any(Identity.class))).thenReturn(null);
//
//		GetVPResponseObject response = this.vis.getVoyagePlan(this.helper.getDefaultSourceIdentity());
//		assertEquals(StatusCode.VP_NOT_FOUND, response.getCode());
//		assertNull(response.getVoyagePlan());
//	}

}
