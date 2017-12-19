package com.example.svilenstrahilov.weatherapp.repository;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.svilenstrahilov.weatherapp.data.CurrentCondition;
import com.example.svilenstrahilov.weatherapp.data.CurrentConditionDao;
import com.example.svilenstrahilov.weatherapp.data.FutureDayForecast;
import com.example.svilenstrahilov.weatherapp.data.FutureDayForecastDao;

@Database(entities = {CurrentCondition.class, FutureDayForecast.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract CurrentConditionDao getCurrentConditionDao();
    public abstract FutureDayForecastDao getFutureDayForecastDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "weather_db").build();
        }
        return INSTANCE;
    }

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
