package com.example.svilenstrahilov.weatherapp.dagger;

import android.app.Application;

import com.example.svilenstrahilov.weatherapp.data.models.dao.CurrentConditionDao;
import com.example.svilenstrahilov.weatherapp.data.models.dao.FutureDayForecastDao;
import com.example.svilenstrahilov.weatherapp.home.HomeActivity;
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(HomeActivity homeActivity);

    FutureDayForecastDao futureForecastDao();

    CurrentConditionDao currentConditionDao();

    CurrentConditionRepository currentConditionRepo();

    FutureForecastRepository futureForecastRepo();

    Application application();
}
