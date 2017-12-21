package com.example.svilenstrahilov.weatherapp.home;

import com.google.gson.JsonObject;

public interface HomeMvpPresenter {
    JsonObject callApi(String city,int number_of_days);
}
