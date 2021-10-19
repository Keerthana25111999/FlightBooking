package com.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;

@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.project"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiEndPointInfo());
	}
	public ApiInfo apiEndPointInfo()
	{
		return new ApiInfoBuilder().title("Flight Booking")
				.description("Airline API")
				.contact(new Contact("Project", "https://project.com", "keerthanarathi25@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("0.0.1-SNAPSHOT")
				.build();
	}
	

}

