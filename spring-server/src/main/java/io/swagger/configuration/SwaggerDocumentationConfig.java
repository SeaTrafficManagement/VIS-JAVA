package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

@Configuration
public class SwaggerDocumentationConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("STM Voyage Information Service STM Onboard API")
			.description("Voyage Information Service API facing STM Onboard systems exposing interfaces to vessels")
			.license("SMA")
			.licenseUrl("http://opensource.org")
			.termsOfServiceUrl("http://sjofartsverket.se")
			.version("1.0.0")
			.contact(new Contact("", "", "per.lofbom@sjofartsverket.se"))
			.build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
			.build()
			.directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
			.directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
			.apiInfo(apiInfo());
	}

}
