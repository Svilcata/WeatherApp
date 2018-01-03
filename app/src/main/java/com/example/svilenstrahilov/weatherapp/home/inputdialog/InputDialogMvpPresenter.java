package com.example.svilenstrahilov.weatherapp.home.inputdialog;

public interface InputDialogMvpPresenter {
    void attachDialog(InputDialogMvpView inputDialogMvpView);

    void detachDialog();

    void getBackUserInput(String cityName, int daysForecast);
}
