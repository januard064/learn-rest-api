package com.springboot.learnrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
public class LearnRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnRestApiApplication.class, args);
	}

}
