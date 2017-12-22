package com.example.svilenstrahilov.weatherapp.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "future_conditions")
public class FutureDayForecast {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("date")
    @Expose
    @ColumnInfo(name = "date")
    private String date;

    @SerializedName("maxtempC")
    @Expose
    @ColumnInfo(name = "maxTempC")
    private String maxTempCelsius;

    @SerializedName("mintempC")
    @Expose
    @ColumnInfo(name = "minTempC")
    private String minTempCelsius;

    @SerializedName("maxtempF")
    @Expose
    @ColumnInfo(name = "maxTempF")
    private String maxTempFahrenheit;

    @SerializedName("mintempF")
    @Expose
    @ColumnInfo(name = "minTempF")
    private String minTempFahrenheit;

    public FutureDayForecast(String date, String maxTempCelsius, String minTempCelsius, String maxTempFahrenheit, String minTempFahrenheit) {
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
