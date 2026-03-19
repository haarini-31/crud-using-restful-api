package com.example.SimplestCRUDExample;

import com.example.SimplestCRUDExample.service.CpeLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimplestCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplestCrudExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CpeLoader loader) {
		return args -> {
			loader.loadJson();
		};
	}
}