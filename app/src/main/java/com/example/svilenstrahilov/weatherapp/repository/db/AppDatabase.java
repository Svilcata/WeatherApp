package com.example.svilenstrahilov.weatherapp.repository.db;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.example.svilenstrahilov.weatherapp.data.models.CurrentCondition;
import com.example.svilenstrahilov.weatherapp.data.models.dao.CurrentConditionDao;
import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;
import com.example.svilenstrahilov.weatherapp.data.models.dao.FutureDayForecastDao;

@Database(entities = {CurrentCondition.class, FutureDayForecast.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CurrentConditionDao getCurrentConditionDao();

    public abstract FutureDayForecastDao getFutureDayForecastDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
