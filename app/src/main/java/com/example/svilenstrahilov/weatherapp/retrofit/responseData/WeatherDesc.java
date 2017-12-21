package com.example.svilenstrahilov.weatherapp.retrofit.responseData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDesc {
    @SerializedName("value")
    @Expose
    private String weatherDesc;

    public WeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }
}
