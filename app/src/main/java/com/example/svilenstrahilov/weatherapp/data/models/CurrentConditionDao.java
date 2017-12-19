package com.example.svilenstrahilov.weatherapp.data.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CurrentConditionDao {
    @Query("SELECT * FROM current_condition WHERE id = :id")
    CurrentCondition getCCById(String id);

    @Insert(onConflict = REPLACE)
    void addCurrentCondition(CurrentCondition condition);

    @Delete
    void deleteCondition(CurrentCondition condition);
}
