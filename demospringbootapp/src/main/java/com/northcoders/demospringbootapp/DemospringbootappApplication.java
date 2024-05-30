package com.northcoders.demospringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class DemospringbootappApplication {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//		SpringApplication.run(DemospringbootappApplication.class, args);
		GetSun.getSunReport(53.95763, -1.08271);
	}

}
