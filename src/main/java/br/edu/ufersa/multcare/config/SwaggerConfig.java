package br.edu.ufersa.multcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket exameApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.edu.ufersa.multcare"))
			//	.paths(regex("/api.*"))
				.build();
		//		.apiInfo(metaInfo());
	}

//	private Predicate<String> regex(String string) {
		// TODO Auto-generated method stub
	//	return null;
	//}
	
	
}