package com.example.svilenstrahilov.weatherapp.home;

import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

public interface HomeMvpPresenter {
    ResponseObj callApi(String city, int number_of_days);

    void attachView(HomeMvpView homeMvpView, Service service);

    void detachView();

    void initializeData(CurrentConditionRepository currentConditionRepository, FutureForecastRepository futureForecastRepository);

    void saveData(CurrentConditionRepository currentConditionRepository, FutureForecastRepository futureForecastRepository);
}
