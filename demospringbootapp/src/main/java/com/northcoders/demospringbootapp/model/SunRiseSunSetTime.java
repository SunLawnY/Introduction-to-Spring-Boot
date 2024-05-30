package com.northcoders.demospringbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SunRiseSunSetTime(
        String sunrise,
        String sunset
){
}
