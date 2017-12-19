package com.example.svilenstrahilov.weatherapp.data;

import com.example.svilenstrahilov.weatherapp.repository.AppDatabase;
import com.example.svilenstrahilov.weatherapp.repository.WeatherDataSource;

import java.util.List;

import javax.inject.Inject;

public class LocalFutureDayForecastData implements WeatherDataSource<FutureDayForecast> {
    private AppDatabase appDatabase;

    @Inject
    public LocalFutureDayForecastData(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public void addItem(FutureDayForecast item) {

    }

    @Override
    public void addItems(List<FutureDayForecast> items) {

    }

    @Override
    public void updateItem(FutureDayForecast item) {

    }

    @Override
    public void updateItems(List<FutureDayForecast> items) {

    }

    @Override
    public void removeItemById(String id) {

    }

    @Override
    public List<FutureDayForecast> getItems() {
        return null;
    }

    @Override
    public FutureDayForecast getItemById(String id) {
        return null;
    }
}
