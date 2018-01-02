package com.example.svilenstrahilov.weatherapp.home;

import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.svilenstrahilov.weatherapp.home.inputdialog.InputDialog;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

public class HomePresenter implements HomeMvpPresenter {


    private HomeMvpView mHomeMvpView;
    private Service mService;
    private ResponseObj responseObject;

    HomePresenter(HomeMvpView homeMvpView, Service service) {
        this.mHomeMvpView = homeMvpView;
        this.mService = service;
        updateResponseObjFromDB();
    }

    private void updateResponseObjFromDB() {

    }

    @Override
    public ResponseObj callApi(String city, int number_of_days) {
        mHomeMvpView.showProgress();
        mService.getResponseFromApi(city, number_of_days, new Service.GetCallback() {
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
    public void attachView(HomeMvpView view, Service service) {
        this.mHomeMvpView = view;
        this.mService = service;
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
    public void attachDialog(FragmentManager supportFragmentManager) {
        InputDialog inputDialog = new InputDialog();
        inputDialog.show(supportFragmentManager, "InputDialog");
    }
}
