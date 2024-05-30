package com.northcoders.demospringbootapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultList(CountrySearch[] results) {
}
