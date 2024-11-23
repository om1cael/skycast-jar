package com.om1cael;

import com.om1cael.models.Weather;
import com.om1cael.models.WeatherDescription;

public class Skycast {
    private String city;

    public Skycast(String city) {
        this.city = city;
        this.printWeather();
    }

    public void printWeather() {
        JSONHandler jsonHandler = new JSONHandler(this.city);
        jsonHandler.getJsonResponse().thenAccept(response -> {
            if(response != null) {
                System.out.println("Weather in " + this.city + ":");
                printMainWeather(response);
                printWeatherCondition(response);
            }
        }).exceptionally(ex -> {
            System.out.println("Could not fetch weather data for " + this.city + ".");
            return null;
        });
    }

    private void printMainWeather(Weather response) {
        System.out.println(" - Temperature: " + response.main().temperature() + "ºC");
        System.out.println(" - Feels like: " + response.main().feelsLike() + "ºC");
        System.out.println(" - Humidity: " + response.main().humidity() + "%");
        System.out.println(" - Wind speed: " + response.wind().speed() + " m/s");
    }

    private void printWeatherCondition(Weather response) {
        for(WeatherDescription weatherDescription : response.weather()) {
            System.out.println(" - Condition: " + weatherDescription.main());
            System.out.println(" - Condition Description: " + weatherDescription.description());
        }
    }
}
