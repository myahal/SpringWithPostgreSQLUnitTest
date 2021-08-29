package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = "com.example")
@SpringBootApplication
public class RestSampleWithPsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSampleWithPsqlApplication.class, args);
	}

}
