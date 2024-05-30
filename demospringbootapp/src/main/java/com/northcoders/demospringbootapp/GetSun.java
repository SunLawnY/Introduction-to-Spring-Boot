package com.northcoders.demospringbootapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.demospringbootapp.model.CountrySearch;
import com.northcoders.demospringbootapp.model.ResultList;
import com.northcoders.demospringbootapp.model.RiseSetList;
import com.northcoders.demospringbootapp.model.SunRiseSunSetTime;

import java.io.DataOutput;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class GetSun {
    public static SunRiseSunSetTime getSunReport(double lat, double lgn) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.sunrisesunset.io/json?lat=" + lat + "&lng=" + lgn))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(response.body());
        SunRiseSunSetTime result = mapper.readValue(response.body(), SunRiseSunSetTime.class);
        System.out.println(result);
        return result;
    }
}
