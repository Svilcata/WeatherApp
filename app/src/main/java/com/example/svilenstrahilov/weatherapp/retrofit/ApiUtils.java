package com.example.svilenstrahilov.weatherapp.retrofit;

public class ApiUtils {
    public ApiUtils() {
    }

    private static String BASE_URL = "http://api.worldweatheronline.com/";

    public static ApiInterface getAPIService() {
        return RetrofitController.getClient(BASE_URL).create(ApiInterface.class);
    }
}
