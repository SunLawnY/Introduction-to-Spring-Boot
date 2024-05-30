package com.northcoders.demospringbootapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.demospringbootapp.model.CountrySearch;
import com.northcoders.demospringbootapp.model.ResultList;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class GetHttp {
    public static List<CountrySearch> getRequest(String countryName) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://geocoding-api.open-meteo.com/v1/search?name=" + countryName))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        ResultList result =  mapper.readValue(response.body(), ResultList.class);
        return Arrays.asList(result.results());
    }
}
