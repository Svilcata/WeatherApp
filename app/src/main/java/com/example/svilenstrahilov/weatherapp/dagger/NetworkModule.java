package com.example.svilenstrahilov.weatherapp.dagger;

import android.support.annotation.NonNull;

import com.example.svilenstrahilov.weatherapp.retrofit.ApiInterface;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    public NetworkModule() {
    }

    @NonNull
    @Provides
    @Singleton
    public Retrofit provideCall() {
        String BASE_URL = "http://api.worldweatheronline.com/";
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ApiInterface provideApiService() {
        return provideCall().create(ApiInterface.class);
    }

    @Provides
    @Singleton
    public Service provideService() {
        return new Service(provideApiService());
    }
}
