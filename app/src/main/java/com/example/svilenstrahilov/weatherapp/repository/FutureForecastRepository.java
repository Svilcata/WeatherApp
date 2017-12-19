package com.example.svilenstrahilov.weatherapp.repository;

import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;

import java.util.List;

public interface FutureForecastRepository {

    void addItems(List<FutureDayForecast> items);

    void updateItems(List<FutureDayForecast> items);

    void removeItemById(String id);

    List<FutureDayForecast> getItems();

}
