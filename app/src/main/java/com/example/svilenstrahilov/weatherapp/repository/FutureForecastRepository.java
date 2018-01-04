package com.example.svilenstrahilov.weatherapp.repository;

import android.os.AsyncTask;

import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;

import java.util.List;

public interface FutureForecastRepository {

    void addItems(List<FutureDayForecast> items);

    void updateItems(List<FutureDayForecast> items);

    void removeItemById(String id);

    AsyncTask<Void, Void, List<FutureDayForecast>> getItems(AsyncResponseFF asyncResponseFF);

    interface AsyncResponseFF {
        void processFinish(List<FutureDayForecast> futureDayForecastList);
    }

}
