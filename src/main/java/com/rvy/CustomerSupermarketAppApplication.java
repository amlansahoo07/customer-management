package com.rvy;

import static springfox.documentation.builders.PathSelectors.regex;

//import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.rvy")
@EntityScan()
@EnableJpaRepositories()
@EnableOpenApi
public class CustomerSupermarketAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSupermarketAppApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	  public Docket openApiPetStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("customer-supermarket-app")
	        .select()
	        .paths(notePaths())
	        .build();
	  }

	  private Predicate<String> notePaths() {
	    return regex(".*/v1/.*");
	  }

	 
}
