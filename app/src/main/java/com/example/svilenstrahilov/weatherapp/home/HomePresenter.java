package com.example.svilenstrahilov.weatherapp.home;

import android.util.Log;

import com.example.svilenstrahilov.weatherapp.data.models.CurrentCondition;
import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.Data;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

import java.util.Collections;
import java.util.List;

public class HomePresenter implements HomeMvpPresenter {
    private HomeMvpView mHomeMvpView;
    private ResponseObj responseObject;
    private Boolean isFutureForecastLoaded = false;
    private Boolean isCurrentConditionLoaded = false;

    HomePresenter(HomeMvpView homeMvpView) {
        this.mHomeMvpView = homeMvpView;
    }

    @Override
    public ResponseObj callApi(Service service, String city, int number_of_days, final CurrentConditionRepository currentConditionRepository, final FutureForecastRepository futureForecastRepository) {
        mHomeMvpView.showProgress();
        service.getResponseFromApi(city, number_of_days, new Service.GetCallback() {
            @Override
            public ResponseObj onSuccess(ResponseObj responseObj) {
                mHomeMvpView.removeProgress();
                responseObject = responseObj;
                updateViews(responseObj);
                saveData(currentConditionRepository, futureForecastRepository);
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
    public void attachView(HomeMvpView homeMvpView) {
        this.mHomeMvpView = homeMvpView;
        updateViews(responseObject);
    }

    private void updateViews(ResponseObj responseObj) {
        if (mHomeMvpView != null) {
            mHomeMvpView.updateViews(responseObj);
        }
    }

    @Override
    public void detachView() {
        this.mHomeMvpView = null;
    }

    @Override
    public void initializeData(CurrentConditionRepository currentConditionRepository, FutureForecastRepository futureForecastRepository) {
        mHomeMvpView.showProgress();
        responseObject = new ResponseObj();
        responseObject.setData(new Data());

        futureForecastRepository.getItems(new FutureForecastRepository.AsyncResponseFF() {
            @Override
            public void processFinish(List<FutureDayForecast> futureDayForecastList) {
                responseObject.getData().setFutureDayForecasts(futureDayForecastList);
                isFutureForecastLoaded = true;
                onFinished();
            }
        });
        currentConditionRepository.getItemById("0", new CurrentConditionRepository.AsyncResponseCC() {
            @Override
            public void processFinish(CurrentCondition currentCondition) {
                responseObject.getData().setCurrentCondition(Collections.singletonList(currentCondition));
                isCurrentConditionLoaded = true;
                onFinished();
            }
        });
    }

    private void onFinished() {
        if (isCurrentConditionLoaded && isFutureForecastLoaded) {
            mHomeMvpView.removeProgress();
            updateViews(responseObject);
        }
    }

    @Override
    public void saveData(CurrentConditionRepository currentConditionRepository, FutureForecastRepository futureForecastRepository) {
        currentConditionRepository.addItem(responseObject.getData().getCurrentCondition().get(0));
        futureForecastRepository.addItems(responseObject.getData().getFutureDayForecasts());
    }
}
