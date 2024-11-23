package com.om1cael.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record WeatherMain(
        @SerializedName("temp") float temperature,
        @SerializedName("feels_like") float feelsLike,
        int humidity
) { }
