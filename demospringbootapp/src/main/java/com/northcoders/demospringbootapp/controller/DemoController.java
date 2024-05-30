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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    public void tellTheTime() throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a city:");
        String cityChosen = scanner.nextLine();
        String formattedCityName = cityChosen.replaceAll(" ", "%20");

        SunRiseSunSetTime result = getSunriseSunset(formattedCityName);
        scanner.close();
        String sunRise = result.sunrise();
        String sunSet = result.sunset();
        System.out.printf("%s\nSunrise: %s Sunset: %s", cityChosen, sunRise, sunSet);


//        int length = getSunriseSunset(cityChosen).toString().length();
//        System.out.println(getSunriseSunset(cityChosen).toString().substring(18, length - 1));
    }
}
