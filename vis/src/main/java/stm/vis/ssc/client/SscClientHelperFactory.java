package stm.vis.ssc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Seaswim connector helper's factory.
 * It creates the helper's instance based on the "vis.config.ssc.interface" property: 
 * if the client is configured to use the SOAP private API, it returns a {@link SscClientSoapHelper}; 
 * otherwise, it returns a {@link SscClientRestHelper}. 
 * @author aheredia
 *
 */
@Component
public class SscClientHelperFactory {
	private static final String SSC_INTERFACE_SOAP = "SOAP";
	private static final String SSC_INTERFACE_REST = "REST";

	@Value("${vis.config.ssc.interface}")
	private String sscInterface = SscClientHelperFactory.SSC_INTERFACE_REST;

	@Autowired
	private ApplicationContext applicationContext;

	public SscClientHelper newInstance() {
		SscClientHelper instance = null;
		switch (this.sscInterface.toUpperCase()) {
			case SSC_INTERFACE_SOAP:
				throw new RuntimeException("SOAP version for SSC client not available");
			default:
				instance = this.applicationContext.getBean(SscClientRestHelper.class);
		}
		return instance;
	}

}
