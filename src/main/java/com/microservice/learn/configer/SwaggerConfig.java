package com.microservice.learn.configer;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// http://localhost:8080/swagger-ui.html
	
	@Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    ApiInfo apiInfo() {
        return new ApiInfo(
                "TEST MONGODB",
                "Online Testing MongoDB Application at DARA.",
                "DARA Course",
                "Terms of service",
                new Contact("DARA", "www.dara.com", "dara@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
    
}
