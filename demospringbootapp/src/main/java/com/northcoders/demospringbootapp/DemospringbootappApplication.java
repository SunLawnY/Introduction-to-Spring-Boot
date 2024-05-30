package com.northcoders.demospringbootapp;

import com.northcoders.demospringbootapp.controller.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

@SpringBootApplication
public class DemospringbootappApplication {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//		SpringApplication.run(DemospringbootappApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose a city:");
		String cityChosen = scanner.nextLine();

		DemoController demoController = new DemoController();
		int length = demoController.getSunriseSunset(cityChosen).toString().length();
		System.out.println(demoController.getSunriseSunset(cityChosen).toString().substring(18, length - 1));
	}

}
