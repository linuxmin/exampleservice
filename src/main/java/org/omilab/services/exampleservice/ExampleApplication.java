package org.omilab.services.exampleservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableJpaRepositories
public class ExampleApplication {

	public static void main(String[] args) {
	        SpringApplication.run(ExampleApplication.class, args);
	}

}
