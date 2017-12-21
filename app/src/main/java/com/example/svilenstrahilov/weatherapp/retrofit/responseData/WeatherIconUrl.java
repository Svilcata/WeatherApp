package com.example.svilenstrahilov.weatherapp.retrofit.responseData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherIconUrl {
    @SerializedName("value")
    @Expose
    private String weatherIconUrl;

    public WeatherIconUrl(String weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }
}
