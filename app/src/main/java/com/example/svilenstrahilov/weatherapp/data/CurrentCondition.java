package com.example.svilenstrahilov.weatherapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "current_condition")
public class CurrentCondition {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "observationTime")
    private String observationTime;
    @ColumnInfo(name = "tempC")
    private String tempCelsius;
    @ColumnInfo(name = "tempF")
    private String tempFahrenheit;
    @ColumnInfo(name = "weatherIconUrl")
    private String weatherIconUrl;
    @ColumnInfo(name = "weatherDescription")
    private String weatherDescription;

    public CurrentCondition(String observationTime, String tempCelsius, String tempFahrenheit, String weatherIconUrl, String weatherDescription) {
        this.observationTime = observationTime;
        this.tempCelsius = tempCelsius;
        this.tempFahrenheit = tempFahrenheit;
        this.weatherIconUrl = weatherIconUrl;
        this.weatherDescription = weatherDescription;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(String tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public String getTempFahrenheit() {
        return tempFahrenheit;
    }

    public void setTempFahrenheit(String tempFahrenheit) {
        this.tempFahrenheit = tempFahrenheit;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(String weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
