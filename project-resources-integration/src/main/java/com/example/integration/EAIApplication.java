package com.example.integration;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EAIApplication extends RouteBuilder {
	private static final transient Logger LOG = LoggerFactory.getLogger(EAIApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EAIApplication.class, args);
	}


	@Override
	public void configure() throws Exception {
		from("cxf:bean:employeeEndpoint")
		.to("EmployeeProcessor");
	}
}
