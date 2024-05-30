package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.GetHttp;
import com.northcoders.demospringbootapp.GetSun;
import com.northcoders.demospringbootapp.model.CountrySearch;
import com.northcoders.demospringbootapp.model.Person;
import com.northcoders.demospringbootapp.model.RiseSetList;
import com.northcoders.demospringbootapp.model.SunRiseSunSetTime;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
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
    public List<CountrySearch> getCountry(@RequestParam String city)throws URISyntaxException, IOException, InterruptedException {

        return GetHttp.getRequest(city);
    }

    @GetMapping("/sunRiseSunSet")
    public SunRiseSunSetTime getSunriseSunset(@RequestParam String city)throws URISyntaxException, IOException, InterruptedException {

        List<CountrySearch> country = GetHttp.getRequest(city);
        double latitude = country.get(0).lat();
        double longitude = country.get(0).lgn();
        return GetSun.getSunReport(latitude, longitude).results();
    }
}
