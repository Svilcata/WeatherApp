package com.example.svilenstrahilov.weatherapp.retrofit;

import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("premium/v1/weather.ashx?")
    Observable<ResponseObj> response(@Query("key") String api_key, @Query("q") String city, @Query("format") String format, @Query("num_of_days") int num_of_days);
}
