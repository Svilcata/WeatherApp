package com.example.svilenstrahilov.weatherapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface FutureDayForecastDao {
    @Query("SELECT * FROM future_conditions")
    List<FutureDayForecast> getFutureForecast();

    @Query("SELECT * FROM future_conditions WHERE id =:id")
    FutureDayForecast getFFbyId(String id);

    @Insert(onConflict = REPLACE)
    void addFutureForecast(FutureDayForecast futureDayForecast);

    @Delete
    void deleteFutureForecast(FutureDayForecast futureDayForecast);
}
