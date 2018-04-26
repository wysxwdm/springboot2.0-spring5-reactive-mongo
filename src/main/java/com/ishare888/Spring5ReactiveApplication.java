package com.ishare888;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class Spring5ReactiveApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Spring5ReactiveApplication.class, args);
	}

}
