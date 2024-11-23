package com.om1cael;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.om1cael.models.Weather;
import com.om1cael.models.WeatherMain;

import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class JSONHandler {
    private URI apiEndpoint;
    private String apiID = System.getenv("OPENWEATHER_API");

    public JSONHandler(String city) {
        if (apiID.isEmpty() || apiID.isBlank()) {
            throw new IllegalStateException("API is not set.");
        }

        this.apiEndpoint = URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + apiID);
    }

    public CompletableFuture<Weather> getJsonResponse() {
        return this.getAPI().thenApply(response -> {
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
            return gson.fromJson(jsonObject, Weather.class);
        }).exceptionally(ex -> {
            System.out.println("Could not parse the weather data.");
            return null;
        });
    }

    private CompletableFuture<String> getAPI() {
        try(HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(this.apiEndpoint)
                    .GET()
                    .build();

            CompletableFuture<HttpResponse<String>> futureResponse = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
            return futureResponse.thenApply(response -> {
                if(response.statusCode() != 200) {
                    throw new RuntimeException("API returned an error status.");
                }

                return response.body();
            });
        } catch (UncheckedIOException e) {
            throw new RuntimeException("Could not create the httpClient: " + e.getMessage());
        }
    }
}
