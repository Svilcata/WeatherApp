package com.example.svilenstrahilov.weatherapp.data;

import android.os.AsyncTask;

import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;
import com.example.svilenstrahilov.weatherapp.data.models.dao.FutureDayForecastDao;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;

import java.util.List;

import javax.inject.Inject;

public class FutureDayForecastDataSource implements FutureForecastRepository {
    private FutureDayForecastDao futureDayForecastDao;

    @Inject
    public FutureDayForecastDataSource(FutureDayForecastDao futureDayForecastDao) {
        this.futureDayForecastDao = futureDayForecastDao;
    }

    @Override
    public void addItems(List<FutureDayForecast> items) {
        for (FutureDayForecast fdf :
                items) {
            new addFCAsync(futureDayForecastDao).execute(fdf);
        }
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

    private static class addFCAsync extends AsyncTask<FutureDayForecast, Void, Void> {
        private FutureDayForecastDao futureDayForecastDao;

        public addFCAsync(FutureDayForecastDao futureDayForecastDao) {
            this.futureDayForecastDao = futureDayForecastDao;
        }

        @Override
        protected Void doInBackground(FutureDayForecast... futureDayForecasts) {
            futureDayForecastDao.addFutureForecast(futureDayForecasts[0]);
            return null;
        }
    }
}
