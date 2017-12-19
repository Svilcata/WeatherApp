package com.example.svilenstrahilov.weatherapp.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.svilenstrahilov.weatherapp.data.CurrentConditionDataSource;
import com.example.svilenstrahilov.weatherapp.data.FutureDayForecastDataSource;
import com.example.svilenstrahilov.weatherapp.data.models.CurrentConditionDao;
import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecastDao;
import com.example.svilenstrahilov.weatherapp.repository.db.AppDatabase;
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    private AppDatabase appDatabase;

    public RoomModule(Application application) {
        appDatabase = Room.databaseBuilder(application, AppDatabase.class, "weather_db").build();
    }

    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        return appDatabase;
    }

    @Singleton
    @Provides
    CurrentConditionDao providesCcDao(AppDatabase appDatabase) {
        return appDatabase.getCurrentConditionDao();
    }

    @Singleton
    @Provides
    FutureDayForecastDao providesFfDao(AppDatabase appDatabase) {
        return appDatabase.getFutureDayForecastDao();
    }

    @Singleton
    @Provides
    CurrentConditionRepository CurrentCondition(CurrentConditionDao conditionDao) {
        return new CurrentConditionDataSource(conditionDao);
    }

    @Singleton
    @Provides
    FutureForecastRepository FutureForecast(FutureDayForecastDao futureDayForecastDao) {
        return new FutureDayForecastDataSource(futureDayForecastDao);
    }
}
