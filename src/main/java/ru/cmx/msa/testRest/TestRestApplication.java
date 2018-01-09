package ru.cmx.msa.testRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRestApplication {

	private static void config(){
		System.getProperties().put("server.port", 8080);
	}

	public static void main(String[] args) {
		config();
		SpringApplication.run(TestRestApplication.class, args);
	}
}
