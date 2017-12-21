package com.example.svilenstrahilov.weatherapp.retrofit.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDesc {
    @SerializedName("value")
    @Expose
    private String weatherDesc;

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }
}
