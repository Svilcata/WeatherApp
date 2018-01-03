package com.example.svilenstrahilov.weatherapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    public static String getWeekday(String inputDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date myDate = simpleDateFormat.parse(inputDate);
        simpleDateFormat.applyPattern("EEEE");
        return simpleDateFormat.format(myDate);
    }
}
