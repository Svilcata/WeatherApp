package com.example.svilenstrahilov.weatherapp.home;

import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

public interface HomeMvpView {
    void showProgress();

    void removeProgress();

    void loadData(ResponseObj responseObj);
}
