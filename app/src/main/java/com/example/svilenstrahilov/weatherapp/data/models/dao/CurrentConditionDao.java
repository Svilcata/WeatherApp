package com.example.svilenstrahilov.weatherapp.data.models.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.example.svilenstrahilov.weatherapp.data.models.CurrentCondition;
import com.example.svilenstrahilov.weatherapp.data.models.converters.WeatherDescrConverter;
import com.example.svilenstrahilov.weatherapp.data.models.converters.WeatherIconUrlConverter;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters({WeatherIconUrlConverter.class, WeatherDescrConverter.class})
public interface CurrentConditionDao {
    @Query("SELECT * FROM current_condition WHERE id = :id")
    CurrentCondition getCCById(String id);

    @Insert(onConflict = REPLACE)
    void addCurrentCondition(CurrentCondition condition);

    @Delete
    void deleteCondition(CurrentCondition condition);
}
