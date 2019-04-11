package stm.vis.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import stm.vis.TestApplication;
import stm.vis.model.Connection.ConnectionStatus;
import stm.vis.model.LogEvent;
import stm.vis.repository.ConnectionRepository;
import stm.vis.service.VISInternalInterface;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class InternalServicesTests {

	@Autowired
	private VISInternalInterface internalServices;

	@Autowired
	private ConnectionRepository connectionRepository;

	@Test
	public void testLogEvent() {
		LogEvent event = this.internalServices.logEvent("service-instance-id", "external-org-id", "external-entity-id", 1, 1, "event-parameters", 1, "event-data");
		assertNotNull(event);
		assertEquals("service-instance-id", event.getServiceInstanceId());
		assertEquals("external-org-id", event.getExternalOrgId());
		assertEquals("external-entity-id", event.getExternalEntityId());
		assertEquals(1, event.getEventNumber().getEventNumber().intValue());
		assertEquals(1, event.getEventType().getEventType().intValue());
		assertEquals("event-parameters", event.getEventParameters());
		assertEquals(1, event.getEventDataType().getEventDataType().intValue());
		assertEquals("event-data", event.getEventData());
	}

	@Test
	public void testConnectionStatus() {
		long initialCount = this.connectionRepository.count();

		this.internalServices.updateConnectionStatus("component-1", ConnectionStatus.UNKNOWN);
		assertEquals(initialCount + 1, this.connectionRepository.count());
		this.internalServices.updateConnectionStatus("component-1", ConnectionStatus.CONNECTED);
		assertEquals(initialCount + 1, this.connectionRepository.count());
		this.internalServices.updateConnectionStatus("component-2", ConnectionStatus.UNCONNECTED);
		assertEquals(initialCount + 2, this.connectionRepository.count());
		this.internalServices.updateConnectionStatus("component-1", ConnectionStatus.UNCONNECTED);
		assertEquals(initialCount + 2, this.connectionRepository.count());
	}

}
