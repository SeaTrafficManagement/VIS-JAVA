package stm.vis.services.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

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
import stm.vis.exception.AuthorizationException;
import stm.vis.model.Identity;
import stm.vis.service.AclService;
import stm.vis.service.PublishedMessagesService;
import stm.vis.service.SubscriptionService;
import stm.vis.service.VISInternalInterface;
import stm.vis.service.VISSubscriptionInterface;
import stm.vis.service.impl.VISSubscription;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class SubscriptionTests {

	@Autowired
	private TestHelper helper;

	@Mock
	private VISInternalInterface internalService;

	@Mock
	private AclService aclService;

	@Mock
	private SubscriptionService subscriptionService;

	@Mock
	private PublishedMessagesService publishedMessagesService;;

	@InjectMocks
	private VISSubscriptionInterface vis = new VISSubscription();

	@Test
	public void testSubscribeToVoyagePlan() throws Exception {
		when(this.publishedMessagesService.findAllActiveVoyagePlans()).thenReturn(Collections.singletonList(this.helper.getDefaultPublishedMessage()));
		
		ResponseObject response = this.vis.subscribeToVoyagePlan(this.helper.getDefaultSourceIdentity(), null, this.helper.getDefaultURI().toString());
		assertEquals(StatusCode.OK, response.getStatusCode());
	}

	@Test
	public void testSubscribeToVoyagePlanById() throws Exception {
		ResponseObject response = this.vis.subscribeToVoyagePlan(this.helper.getDefaultSourceIdentity(), "uvid-1", this.helper.getDefaultURI().toString());
		assertEquals(StatusCode.OK, response.getStatusCode());
	}

	@Test
	public void testSubscribeToVoyagePlanNotAuthorized() throws Exception {
		doThrow(new AuthorizationException("not-authorized")).when(this.aclService).checkAuthorization(any(Identity.class), any(String.class));

		ResponseObject response = this.vis.subscribeToVoyagePlan(this.helper.getDefaultSourceIdentity(), "uvid-1", this.helper.getDefaultURI().toString());
		assertEquals(StatusCode.NOT_AUTHORIZED, response.getStatusCode());
	}

	@Test
	public void testRemoveVoyagePlanSubscription() {
		ResponseObject response = this.vis.removeVoyagePlanSubscription(this.helper.getDefaultSourceIdentity(), null, this.helper.getDefaultURI().toString());
		assertEquals(StatusCode.OK, response.getStatusCode());
	}

}
