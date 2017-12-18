package com.example.svilenstrahilov.weatherapp.retrofit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("premium/v1/weather.ashx?")
    Call<JsonObject> response(@Query("key") String api_key, @Query("q") String city, @Query("format") String format);
}
