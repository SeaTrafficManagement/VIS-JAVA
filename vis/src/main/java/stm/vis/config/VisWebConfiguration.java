package stm.vis.config;

import javax.servlet.Filter;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VisWebConfiguration {

	@Value("${vis.config.privateApi.port}")
	private int privateApiPort;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addAdditionalTomcatConnectors(this.createPrivateAPIConnector());
		return tomcat;
	}

	private Connector createPrivateAPIConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		connector.setScheme("http");
		connector.setSecure(false);
		connector.setPort(this.privateApiPort);
		protocol.setSSLEnabled(false);
		return connector;
	}

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(this.secureCallByPortFilter());
		registration.addUrlPatterns("/*");
		registration.setName("secureCallByPortFilter");
		registration.setOrder(1);
		return registration;
	}

	@Bean(name = "secureCallByPortFilter")
	public Filter secureCallByPortFilter() {
		return new SecureCallByPortFilter();
	}

/*
 * From http://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-servlet-containers.html#howto-enable-multiple-connectors-in-tomcat	
 * 
	private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			File keystore = new ClassPathResource("keystore").getFile();
			File truststore = new ClassPathResource("keystore").getFile();
			connector.setScheme("https");
			connector.setSecure(true);
			connector.setPort(8443);
			protocol.setSSLEnabled(true);
			protocol.setKeystoreFile(keystore.getAbsolutePath());
			protocol.setKeystorePass("changeit");
			protocol.setTruststoreFile(truststore.getAbsolutePath());
			protocol.setTruststorePass("changeit");
			protocol.setKeyAlias("apitester");
			return connector;
		} catch (IOException ex) {
			throw new IllegalStateException("can't access keystore: [" + "keystore"
				+ "] or truststore: [" + "keystore" + "]", ex);
		}
	}
*
*/
}
