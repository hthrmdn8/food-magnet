package com.github.foodmagnet.models.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.foodmagnet.models.Restaurant;
import com.github.foodmagnet.models.data.jsonparsing.Json;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestaurantData {

    public static Restaurant returnRestaurantData() throws IOException, InterruptedException {

        final String POSTS_API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=38.627003%2C-90.199402&radius=2000&type=restaurant&fields=name%2Cplace_id&key=AIzaSyCxeEL1XB9sj-BAJrzUICxQ34A3valuafg";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode node = Json.parse(response.body());
        JsonNode results = node.get("results");
        Restaurant restaurant = Json.fromJson(results.get(0), Restaurant.class);

        return restaurant;
    }

}
