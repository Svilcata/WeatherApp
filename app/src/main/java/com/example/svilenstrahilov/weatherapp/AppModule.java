package com.example.svilenstrahilov.weatherapp;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    Application providesApplication() {
        return mApplication;
    }
}
