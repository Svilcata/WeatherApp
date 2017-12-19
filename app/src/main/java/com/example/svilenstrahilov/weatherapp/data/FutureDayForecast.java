package com.example.svilenstrahilov.weatherapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "future_conditions")
public class FutureDayForecast {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "maxTempC")
    private String maxTempCelsius;
    @ColumnInfo(name = "minTempC")
    private String minTempCelsius;
    @ColumnInfo(name = "maxTempF")
    private String maxTempFahrenheit;
    @ColumnInfo(name = "minTempF")
    private String minTempFahrenheit;

    public FutureDayForecast(String maxTempCelsius, String minTempCelsius, String maxTempFahrenheit, String minTempFahrenheit) {
        this.maxTempCelsius = maxTempCelsius;
        this.minTempCelsius = minTempCelsius;
        this.maxTempFahrenheit = maxTempFahrenheit;
        this.minTempFahrenheit = minTempFahrenheit;
    }

    public String getMaxTempCelsius() {
        return maxTempCelsius;
    }

    public void setMaxTempCelsius(String maxTempCelsius) {
        this.maxTempCelsius = maxTempCelsius;
    }

    public String getMinTempCelsius() {
        return minTempCelsius;
    }

    public void setMinTempCelsius(String minTempCelsius) {
        this.minTempCelsius = minTempCelsius;
    }

    public String getMaxTempFahrenheit() {
        return maxTempFahrenheit;
    }

    public void setMaxTempFahrenheit(String maxTempFahrenheit) {
        this.maxTempFahrenheit = maxTempFahrenheit;
    }

    public String getMinTempFahrenheit() {
        return minTempFahrenheit;
    }

    public void setMinTempFahrenheit(String minTempFahrenheit) {
        this.minTempFahrenheit = minTempFahrenheit;
    }
}
