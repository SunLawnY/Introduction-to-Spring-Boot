package com.northcoders.demospringbootapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.demospringbootapp.model.RiseSetList;
import com.northcoders.demospringbootapp.model.SunRiseSunSetTime;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSun {
    public static RiseSetList getSunReport(double lat, double lng) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.sunrisesunset.io/json?lat=" + lat + "&lng=" + lng))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(response.body());
        RiseSetList result = mapper.readValue(response.body(), RiseSetList.class);
        System.out.println(result);
        return result;
    }
}
