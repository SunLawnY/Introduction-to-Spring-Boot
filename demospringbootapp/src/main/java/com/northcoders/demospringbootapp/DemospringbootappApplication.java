package com.northcoders.demospringbootapp;
import com.northcoders.demospringbootapp.controller.DemoController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class DemospringbootappApplication {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//		SpringApplication.run(DemospringbootappApplication.class, args);

		DemoController demo = new DemoController();
		demo.tellTheTime();
	}

}
