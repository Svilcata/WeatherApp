package com.example.svilenstrahilov.weatherapp.home;

import android.util.Log;

import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

public class HomePresenter implements HomeMvpPresenter {
    private HomeMvpView mHomeMvpView;
    private ResponseObj responseObject;

    HomePresenter(HomeMvpView homeMvpView) {
        this.mHomeMvpView = homeMvpView;
    }

    @Override
    public ResponseObj callApi(Service service, String city, int number_of_days) {
        mHomeMvpView.showProgress();
        service.getResponseFromApi(city, number_of_days, new Service.GetCallback() {
            @Override
            public ResponseObj onSuccess(ResponseObj responseObj) {
                mHomeMvpView.removeProgress();
                responseObject = responseObj;
                updateViews(responseObj);
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
//        responseObject = new ResponseObj();
//        responseObject.setData(new Data(Collections.singletonList(currentConditionRepository.getItemById("0")), futureForecastRepository.getItems()));
    }

    @Override
    public void saveData(CurrentConditionRepository currentConditionRepository, FutureForecastRepository futureForecastRepository) {
        currentConditionRepository.addItem(responseObject.getData().getCurrentCondition().get(0));
        futureForecastRepository.addItems(responseObject.getData().getFutureDayForecasts());
    }
}
