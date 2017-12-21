package com.example.svilenstrahilov.weatherapp.data.models.converters;

import android.arch.persistence.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class WeatherDescrConverter {
    @TypeConverter
    public static List<String> toList(String value) {
        List<String> list = Arrays.asList(value.split("\\s*,\\s*"));
        return list;
    }

    @TypeConverter
    public String toString(List<String> weatherDesc) {
        String value = "";
        for (String weather : weatherDesc)
            value += weather + ",";
        return value;
    }
}
