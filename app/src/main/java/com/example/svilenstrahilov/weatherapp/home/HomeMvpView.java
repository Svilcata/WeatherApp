package com.example.svilenstrahilov.weatherapp.home;

import com.google.gson.JsonObject;

public interface HomeMvpView {
    void showProgress();

    void removeProgress();

    void loadData(JsonObject jsonObject);
}
