package com.example.svilenstrahilov.weatherapp.dagger;

import android.support.annotation.NonNull;

import com.example.svilenstrahilov.weatherapp.retrofit.ApiInterface;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private File cacheFile;
    private static String BASE_URL = "http://api.worldweatheronline.com/";

    public NetworkModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @NonNull
    @Provides
    @Singleton
    private Retrofit provideCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024); //10mb
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();


        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    private ApiInterface provideApiService() {
        return provideCall().create(ApiInterface.class);
    }

    @Provides
    @Singleton
    public Service provideService() {
        return new Service(provideApiService());
    }
}
