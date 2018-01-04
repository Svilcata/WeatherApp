package com.example.svilenstrahilov.weatherapp.home.inputdialog;

public class InputDialogPresenter implements InputDialogMvpPresenter {
    private InputDialogMvpView inputDialogMvpView;

    InputDialogPresenter(InputDialogMvpView inputDialogMvpView) {
        this.inputDialogMvpView = inputDialogMvpView;
    }

    @Override
    public void attachDialog(InputDialogMvpView inputDialogMvpView) {
        this.inputDialogMvpView = inputDialogMvpView;
    }

    @Override
    public void detachDialog() {
        this.inputDialogMvpView = null;
    }

    @Override
    public void getBackUserInput(String cityName, int daysForecast) {
        inputDialogMvpView.submitButtonClicked(cityName, daysForecast);
    }
}
