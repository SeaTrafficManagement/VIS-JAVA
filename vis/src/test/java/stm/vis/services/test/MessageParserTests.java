package stm.vis.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import stm.vis.TestApplication;
import stm.vis.data.area.DatasetType;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.RouteStatus;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.route.GMPoint;
import stm.vis.data.route.Route;
import stm.vis.data.route.RouteInfo;
import stm.vis.data.route.Waypoint;
import stm.vis.data.route.Waypoints;
import stm.vis.data.textMessage.TextMessage;
import stm.vis.service.MessageParser;
import stm.vis.service.MessageValidator;
import stm.vis.service.SchemaService;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class MessageParserTests {

	@Autowired
	private MessageParser parser;

	@Autowired
	private MessageValidator validator;

	@Autowired
	private SchemaService schemaService;

	@Autowired
	private TestHelper helper;

	@Test
	public void testRoute() throws Exception {
		STMMessage message = new STMMessage();
		message.setData(this.getBytes("rtz_route_stm.xml"));

		Route route = this.parser.getRouteFromMessage(message);
		assertNotNull(route);
		assertEquals("1.1", route.getVersion());
		assertEquals("AROUNDtheSKAGEN", route.getRouteInfo().getRouteName());
		assertEquals("Simon Ross", route.getRouteInfo().getRouteAuthor());
		assertEquals(RouteStatus.USED_FOR_MONITORING, RouteStatus.fromValue(route.getRouteInfo().getRouteStatus()));
		assertEquals("Pegasus", route.getRouteInfo().getVesselName());
		assertEquals("220348970", route.getRouteInfo().getVesselMMSI().toString());
		assertEquals("3798347", route.getRouteInfo().getVesselIMO().toString());
		assertEquals("urn:mrn:stm:voyage:id:acme:b6d7b492-ab3c-42f2-8afd-116c3d872f0c", route.getRouteInfo().getVesselVoyage());
		// TODO Add more asserts
	}

	@Test
	public void testGetRouteFromMessage() throws Exception {
		Date now = new Date();
		Route route = new Route();
		route.setVersion("1.1");
		route.setRouteInfo(new RouteInfo());
		route.getRouteInfo().setRouteAuthor("route-author");
		route.getRouteInfo().setRouteName("route-name");
		route.getRouteInfo().setRouteStatus(Integer.toString(RouteStatus.USED_FOR_MONITORING.getValue()));
		route.getRouteInfo().setVesselVoyage("uvid");
		route.getRouteInfo().setValidityPeriodStart(this.helper.fromDate(now));
		route.getRouteInfo().setValidityPeriodStop(this.helper.fromDate(now));
		route.setWaypoints(new Waypoints());
		route.getWaypoints().getWaypoint().add(this.getWayPoint(1));
		route.getWaypoints().getWaypoint().add(this.getWayPoint(2));

		STMMessage message = this.parser.getMessageFromRoute(route);
		assertNotNull(message);
		this.validator.validateMessage(message, this.schemaService.getRouteSchema());
		Route parsedRoute = this.parser.getRouteFromMessage(message);
		assertEquals("1.1", parsedRoute.getVersion());
		assertEquals("route-author", parsedRoute.getRouteInfo().getRouteAuthor());
		assertEquals("route-name", parsedRoute.getRouteInfo().getRouteName());
		assertEquals(RouteStatus.USED_FOR_MONITORING, RouteStatus.fromValue(Integer.parseInt(parsedRoute.getRouteInfo().getRouteStatus())));
		assertEquals("uvid", parsedRoute.getRouteInfo().getVesselVoyage());
		assertEquals(now, parsedRoute.getRouteInfo().getValidityPeriodStart().toGregorianCalendar().getTime());
		assertEquals(now, parsedRoute.getRouteInfo().getValidityPeriodStop().toGregorianCalendar().getTime());
		assertEquals(2, parsedRoute.getWaypoints().getWaypoint().size());
	}

	private Waypoint getWayPoint(int i) {
		Waypoint wayPoint = new Waypoint();
		wayPoint.setId(new BigInteger(Integer.toString(i)));
		GMPoint point = new GMPoint();
		point.setLat(new BigDecimal("0.12345"));
		point.setLon(new BigDecimal("0.12345"));
		wayPoint.setPosition(point);
		return wayPoint;
	}

	@Test
	public void testGetPolygonFromMessage() throws Exception {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.S124);
		message.setData(this.getBytes("DK_034_17.xml"));

		DatasetType polygon = this.parser.getPolygonFromMessage(message);
		assertNotNull(polygon);
		assertEquals("DK.034.17", polygon.getId());
		assertEquals("EPSG:4326", polygon.getBoundedBy().getEnvelope().getSrsName());
		assertEquals(5.0, polygon.getBoundedBy().getEnvelope().getLowerCorner().getValue().get(0), 0.00);
		assertEquals(50.0, polygon.getBoundedBy().getEnvelope().getLowerCorner().getValue().get(1), 0.00);
		assertEquals(45.0, polygon.getBoundedBy().getEnvelope().getUpperCorner().getValue().get(0), 0.00);
		assertEquals(65.0, polygon.getBoundedBy().getEnvelope().getUpperCorner().getValue().get(1), 0.00);
		// TODO Write more asserts
	}

	@Test
	public void testGetTextMessageFromMessage() throws Exception {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.TXTMSG);
		message.setData(this.getBytes("TXT1_3.xml"));

		TextMessage textMessage = this.parser.getTextMessageFromMessage(message);
		assertNotNull(message);
		assertEquals("urn:mrn:stm:txt:sma:20170510104400-1", textMessage.getTextMessageId());
		assertEquals("urn:mrn:stm:voyage:id:test:100", textMessage.getInformationObjectReferenceId());
		assertEquals("RTZ", textMessage.getInformationObjectReferenceType().value());
//		assertEquals("2017-05-01T01:00:00Z", textMessage.getValidityPeriodStart()); // TODO ASSERT Date 
//		assertEquals("2017-06-10T01:00:00Z", textMessage.getValidityPeriodStop()); // TODO ASSERT Date 
		assertEquals("urn:mrn:stm:user:sma:mikolo", textMessage.getAuthor());
		assertEquals("urn:mrn:stm:org:sma", textMessage.getFrom());
		assertEquals("SHIP-VIS", textMessage.getServiceType());
		// assertEquals("2017-05-10T01:00:00Z", textMessage.getCreatedAt()); // TODO ASSERT Date 
		assertEquals("Test message", textMessage.getSubject());
		assertEquals("Test message Hanöbukten", textMessage.getBody());
		assertNotNull(textMessage.getPosition());
		assertEquals("55.50668", textMessage.getPosition().getLat().toString());
		assertEquals("14.29825", textMessage.getPosition().getLon().toString());
		assertNotNull(textMessage.getArea());
		assertEquals("55.452 14.405 55.465 14.151 56.006 14.301 55.563 14.437 55.452 14.405", textMessage.getArea().getPolygon().getPosList());
		assertEquals("55.50668", textMessage.getArea().getCircle().getPosition().getLat().toString());
		assertEquals("14.29825", textMessage.getArea().getCircle().getPosition().getLon().toString());
		assertEquals(1, textMessage.getArea().getCircle().getRadius(), 0.0);
	}

	private byte[] getBytes(String fileName) throws IOException {
		Resource resource = new ClassPathResource(fileName);
		return FileCopyUtils.copyToByteArray(resource.getInputStream());
	}

}
