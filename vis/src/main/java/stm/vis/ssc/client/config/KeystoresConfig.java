package stm.vis.ssc.client.config;

import java.security.KeyStore;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

/**
 * Configuration class.
 * Initializes seaswim connector's keystore and truststore.
 * Initializes the {@link SSLConnectionSocketFactory} used by the {@link HttpClient} to send https messages using 2-way authentication. 
 * @author aheredia
 *
 */
@Configuration
public class KeystoresConfig {

	@Autowired
	private ResourceLoader resourceLoader;

	@Value("${vis.config.security.key-store}")
	private String keystoreLocation;

	@Value("${vis.config.security.key-store-password}")
	private String keystorePassword;

	@Value("${vis.config.security.trust-store}")
	private String truststoreLocation;

	@Value("${vis.config.security.trust-store-password}")
	private String truststorePassword;

	@Value("${vis.config.security.key-password}")
	private String password;

	@Bean(name = "keyStore")
	public KeyStore keystore() {
		KeyStore keyStore = null;
		try {
			keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			keyStore.load(this.resourceLoader.getResource(this.keystoreLocation).getInputStream(), this.keystorePassword.toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyStore;
	}

	@Bean(name = "trustStore")
	public KeyStore trustStore() {
		KeyStore trustStore = null;
		try {
			trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(this.resourceLoader.getResource(this.truststoreLocation).getInputStream(), this.truststorePassword.toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trustStore;
	}

	@Bean
	public SSLConnectionSocketFactory socketFactory(KeyStore keyStore, KeyStore trustStore) {
		SSLConnectionSocketFactory socketFactory = null;
		try {
			socketFactory = new SSLConnectionSocketFactory(
				new SSLContextBuilder()
					.loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
					.loadKeyMaterial(keyStore, this.password.toCharArray()).build(),
				NoopHostnameVerifier.INSTANCE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return socketFactory;
	}

}
