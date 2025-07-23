package com.rubensrangel.health_traceability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HealthTraceabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthTraceabilityApplication.class, args);
	}

}
