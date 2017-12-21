package com.example.svilenstrahilov.weatherapp.data.models.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.svilenstrahilov.weatherapp.retrofit.responseData.WeatherDesc;

import java.util.ArrayList;
import java.util.List;

public class WeatherDescrConverter {
    @TypeConverter
    public static List<WeatherDesc> toList(String value) {
        List<WeatherDesc> weatherDescList = new ArrayList<>();
        weatherDescList.add(new WeatherDesc(value));
        return weatherDescList;
    }

    @TypeConverter
    public static String toString(List<WeatherDesc> weatherDescs) {
        StringBuilder value = new StringBuilder();
        for (WeatherDesc weatherDesc :
                weatherDescs) {
            value.append(weatherDesc.getWeatherDesc()).append(",");
        }
        return value.toString();
    }
}
