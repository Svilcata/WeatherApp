package com.example.svilenstrahilov.weatherapp.home;

import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

public interface HomeMvpPresenter {
    ResponseObj callApi(String city, int number_of_days);
}
