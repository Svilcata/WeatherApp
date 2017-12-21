package com.example.svilenstrahilov.weatherapp.retrofit.responseData;

import com.example.svilenstrahilov.weatherapp.data.models.CurrentCondition;
import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("request")
    @Expose
    private List<Request> request;
    @SerializedName("current_condition")
    @Expose
    private List<CurrentCondition> currentCondition = null;
    @SerializedName("weather")
    @Expose
    private List<FutureDayForecast> futureDayForecasts = null;

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<CurrentCondition> getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(List<CurrentCondition> currentCondition) {
        this.currentCondition = currentCondition;
    }

    public List<FutureDayForecast> getFutureDayForecasts() {
        return futureDayForecasts;
    }

    public void setFutureDayForecasts(List<FutureDayForecast> futureDayForecasts) {
        this.futureDayForecasts = futureDayForecasts;
    }
}
