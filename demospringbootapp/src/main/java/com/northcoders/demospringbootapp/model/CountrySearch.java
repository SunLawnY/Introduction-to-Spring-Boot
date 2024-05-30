package com.northcoders.demospringbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountrySearch(
        @JsonProperty("name")
        String name,
        @JsonProperty("latitude")
        double lat,
        @JsonProperty("longitude")
        double lgn) {
}
