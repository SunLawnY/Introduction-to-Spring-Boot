package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String getLocation()
}
