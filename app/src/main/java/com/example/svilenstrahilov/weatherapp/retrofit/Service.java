package com.example.svilenstrahilov.weatherapp.retrofit;

import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Service {
    private final ApiInterface apiInterface;


    public Service(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void getResponseFromApi(String city, int number_of_days, final GetCallback callback) {
        apiInterface.response("ae3d24f1ab404816957121710171812", city, "json", number_of_days).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseObj>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseObj responseObj) {
                callback.onSuccess(responseObj);

            }

            @Override
            public void onError(Throwable e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        });
    }

    public interface GetCallback {
        ResponseObj onSuccess(ResponseObj responseObj);

        void onError(String error);
    }
}
