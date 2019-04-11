package stm.vis.ssc.client.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender.RemoveSoapHeadersInterceptor;

/**
 * Seaswim connector's client configuration.
 * Configures the SSC client, initializing {@link ClientHttpRequestFactory} used to create the {@link HttpClient} for https communcations.
 * @author aheredia
 *
 */
@Configuration
public class SscClientConfiguration {

	@Bean
	public HttpClient httpClient(SSLConnectionSocketFactory socketFactory) {
		try {
			HttpClient httpClient = HttpClients.custom()
				.setSSLSocketFactory(socketFactory)
				.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
				.addInterceptorFirst(new RemoveSoapHeadersInterceptor())
				.build();
			return httpClient;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	public HttpComponentsMessageSender httpComponentsMessageSender(HttpClient httpClient) {
		HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender(httpClient);
		return messageSender;
	}

	@Bean
	public ClientHttpRequestFactory requestFactory(HttpClient httpClient) {
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return requestFactory;
	}

}