package com.example.svilenstrahilov.weatherapp.home;

import android.util.Log;

import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

public class HomePresenter implements HomeMvpPresenter {
    private HomeMvpView mHomeMvpView;
    private Service mService;

    HomePresenter(HomeMvpView homeMvpView, Service service) {
        this.mHomeMvpView = homeMvpView;
        this.mService = service;
    }

    @Override
    public ResponseObj callApi(String city, int number_of_days) {
        mService.getResponseFromApi(city, number_of_days, new Service.GetCallback() {
            @Override
            public ResponseObj onSuccess(ResponseObj responseObj) {
                mHomeMvpView.removeProgress();
                mHomeMvpView.updateViews(responseObj);
                return responseObj;
            }

            @Override
            public void onError(String error) {
                Log.e("LOG", error);
            }
        });
        return null;
    }

    @Override
    public void attachView(HomeMvpView view, Service service) {
        this.mHomeMvpView = view;
        this.mService = service;
    }

    @Override
    public void detachView() {
        this.mHomeMvpView = null;
    }
}
