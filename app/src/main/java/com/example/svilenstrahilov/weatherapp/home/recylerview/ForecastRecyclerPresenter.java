package com.example.svilenstrahilov.weatherapp.home.recylerview;

import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;
import com.example.svilenstrahilov.weatherapp.utils.DateConverter;

import java.text.ParseException;
import java.util.List;

public class ForecastRecyclerPresenter {
    private List<FutureDayForecast> futureDayForecasts;

    public ForecastRecyclerPresenter(List<FutureDayForecast> futureDayForecasts) {
        this.futureDayForecasts = futureDayForecasts;
    }

    void onBindForecastRowViewAtPosition(int position, ForecastRecyclerRowView rowView) {
        FutureDayForecast futureDayForecast = futureDayForecasts.get(position);
        rowView.setTemperature(futureDayForecast.getMaxTempCelsius());
        try {
            rowView.setWeekday(DateConverter.getWeekday(futureDayForecast.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    int getForecastRowsCount() {
        return futureDayForecasts.size();
    }
}
