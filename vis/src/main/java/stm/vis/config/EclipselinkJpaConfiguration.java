package stm.vis.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableAutoConfiguration
public class EclipselinkJpaConfiguration extends JpaBaseConfiguration {

	protected EclipselinkJpaConfiguration(DataSource dataSource, JpaProperties properties, ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider) {
		super(dataSource, properties, jtaTransactionManagerProvider);
	}

	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
		adapter.setShowSql(true);
		return adapter;
	}

	@Override
	protected Map<String, Object> getVendorProperties() {
		HashMap<String, Object> map = new HashMap<String, Object>();

		// XXX Uncomment to generate database on startup
		map.put("eclipselink.deploy-on-startup", "true");
		map.put("eclipselink.ddl-generation", "create-tables");
		map.put("eclipselink.ddl-generation.output-mode", "both");

		map.put("eclipselink.weaving", "static");
		map.put("eclipselink.weaving.lazy", "true");
		map.put("eclipselink.weaving.internal", "true");

		map.put("eclipselink.logging.level", "FINE");

		return map;
	}

}
