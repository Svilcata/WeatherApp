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
            new AddFutureForecastAsync(futureDayForecastDao).execute(fdf);
        }
    }

    @Override
    public void updateItems(List<FutureDayForecast> items) {

    }

    @Override
    public void removeItemById(String id) {

    }

    @Override
    public AsyncTask<Void, Void, List<FutureDayForecast>> getItems(AsyncResponseFF asyncResponseFF) {
        return new GetFutureForecastsAsync(futureDayForecastDao, asyncResponseFF).execute();
    }

    private static class AddFutureForecastAsync extends AsyncTask<FutureDayForecast, Void, Void> {
        private FutureDayForecastDao futureDayForecastDao;

        AddFutureForecastAsync(FutureDayForecastDao futureDayForecastDao) {
            this.futureDayForecastDao = futureDayForecastDao;
        }

        @Override
        protected Void doInBackground(FutureDayForecast... futureDayForecasts) {
            futureDayForecastDao.addFutureForecast(futureDayForecasts[0]);
            return null;
        }
    }

    private static class GetFutureForecastsAsync extends AsyncTask<Void, Void, List<FutureDayForecast>> {
        AsyncResponseFF delegate = null;
        private FutureDayForecastDao futureDayForecastDao;

        GetFutureForecastsAsync(FutureDayForecastDao futureDayForecastDao, AsyncResponseFF delegate) {
            this.futureDayForecastDao = futureDayForecastDao;
            this.delegate = delegate;
        }

        @Override
        protected List<FutureDayForecast> doInBackground(Void... voids) {
            return futureDayForecastDao.getFutureForecast();
        }

        @Override
        protected void onPostExecute(List<FutureDayForecast> futureDayForecastList) {
            delegate.processFinish(futureDayForecastList);
        }
    }
}
