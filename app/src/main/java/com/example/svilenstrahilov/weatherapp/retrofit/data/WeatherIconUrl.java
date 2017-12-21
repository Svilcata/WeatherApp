package com.example.svilenstrahilov.weatherapp.retrofit.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherIconUrl {
    @SerializedName("value")
    @Expose
    private String weatherIconUrl;

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(String weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }
}
