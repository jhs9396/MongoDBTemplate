package net.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.project.demo.services.MongoDBService;

@SpringBootApplication
public class MongoDbTemplateApplication implements CommandLineRunner {

	@Autowired
	MongoDBService service;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDbTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.test();
	}
}
