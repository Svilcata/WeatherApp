package com.example.svilenstrahilov.weatherapp.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.svilenstrahilov.weatherapp.data.models.converters.WeatherDescrConverter;
import com.example.svilenstrahilov.weatherapp.data.models.converters.WeatherIconUrlConverter;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.WeatherDesc;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.WeatherIconUrl;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "current_condition")
public class CurrentCondition {
    @PrimaryKey
    public int id;

    @SerializedName("observation_time")
    @Expose
    @ColumnInfo(name = "observationTime")
    private String observationTime;

    @SerializedName("temp_C")
    @Expose
    @ColumnInfo(name = "tempC")
    private String tempCelsius;

    @SerializedName("temp_F")
    @Expose
    @ColumnInfo(name = "tempF")
    private String tempFahrenheit;

    @SerializedName("weatherIconUrl")
    @Expose
    @TypeConverters(WeatherIconUrlConverter.class)
    private List<WeatherIconUrl> weatherIconUrl;

    @SerializedName("weatherDesc")
    @Expose
    @ColumnInfo(name = "weatherDescription")
    @TypeConverters(WeatherDescrConverter.class)
    private List<WeatherDesc> weatherDescription;

    public CurrentCondition(String observationTime, String tempCelsius, String tempFahrenheit, List<WeatherIconUrl> weatherIconUrl, List<WeatherDesc> weatherDescription) {
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

    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public List<WeatherDesc> getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(List<WeatherDesc> weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
