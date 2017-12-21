package com.example.svilenstrahilov.weatherapp.data.models.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.svilenstrahilov.weatherapp.retrofit.data.WeatherIconUrl;

import java.util.ArrayList;
import java.util.List;

public class WeatherIconUrlConverter {
    @TypeConverter
    public static List<WeatherIconUrl> toList(String value) {
        List<WeatherIconUrl> weatherIconUrls = new ArrayList<>();
        weatherIconUrls.add(new WeatherIconUrl(value));
        return weatherIconUrls;
    }

    @TypeConverter
    public static String toString(List<WeatherIconUrl> weatherIconUrls) {
        StringBuilder value = new StringBuilder();
        for (WeatherIconUrl weatherIconUrl :
                weatherIconUrls) {
            value.append(weatherIconUrl.getWeatherIconUrl()).append(",");
        }
        return value.toString();
    }
}
