package com.om1cael.models;

import java.util.List;

public record Weather(
        WeatherMain main,
        List<WeatherDescription> weather,
        Wind wind
) { }
