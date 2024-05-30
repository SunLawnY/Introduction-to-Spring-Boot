package com.northcoders.demospringbootapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.demospringbootapp.model.City;
import com.northcoders.demospringbootapp.model.Person;
import com.northcoders.demospringbootapp.model.Results;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/hello")
    public String getGreeting() {
        return "Hello there!";

    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return List.of(
                new Person("Bob", 30, "bob@bob.com", "London", "Pasta"),
                new Person("Luke", 24, "luke@bob.com", "Glasgow", "Pizza"),
                new Person("Elle", 75, "l@bob.com", "Manchester", "Ice cream")
                );
    }

    @GetMapping("/location")
    @ResponseBody
    public Results getLocation(@RequestParam("city") String city) throws JsonProcessingException {
        String Url = "https://geocoding-api.open-meteo.com/v1/search?name=" + city;
        HttpResponse<String> response;
        ObjectMapper mapper = new ObjectMapper();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(Url))
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return mapper.readValue(response.body(), Results.class);
    }
}
