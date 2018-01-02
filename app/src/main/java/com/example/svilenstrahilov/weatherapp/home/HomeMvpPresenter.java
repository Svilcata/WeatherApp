package com.example.svilenstrahilov.weatherapp.home;

import android.support.v4.app.FragmentManager;

import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

public interface HomeMvpPresenter {
    ResponseObj callApi(String city, int number_of_days);

    void attachView(HomeMvpView view, Service service);

    void detachView();

    void attachDialog(FragmentManager supportFragmentManager);
}
