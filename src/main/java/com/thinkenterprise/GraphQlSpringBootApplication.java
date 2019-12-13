package com.thinkenterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thinkenterprise.flightservice.EnableSampleLibraryModule;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@SpringBootApplication
@EnableSampleLibraryModule
public class GraphQlSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GraphQlSpringBootApplication.class, args);
	}
}
