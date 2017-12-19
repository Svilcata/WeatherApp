package com.example.svilenstrahilov.weatherapp.retrofit;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("premium/v1/weather.ashx?")
    Observable<JsonObject> response(@Query("key") String api_key, @Query("q") String city, @Query("format") String format, @Query("num_of_days") int num_of_days);
}
