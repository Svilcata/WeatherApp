package com.example.svilenstrahilov.weatherapp.home;

import android.util.Log;

import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.google.gson.JsonObject;

public class HomePresenter implements HomeMvpPresenter {
    private HomeMvpView mHomeMvpView;
    private Service mService;

    HomePresenter(HomeMvpView homeMvpView, Service service) {
        this.mHomeMvpView = homeMvpView;
        this.mService = service;
    }

    @Override
    public JsonObject callApi(String city, int number_of_days) {
        mService.getResponseFromApi(city, number_of_days, new Service.GetCallback() {
            @Override
            public JsonObject onSuccess(JsonObject jsonObject) {
                mHomeMvpView.removeProgress();
                mHomeMvpView.loadData(jsonObject);
                return jsonObject;
            }

            @Override
            public void onError(String error) {
                Log.e("LOG", error);
            }
        });
        return null;
    }
}
