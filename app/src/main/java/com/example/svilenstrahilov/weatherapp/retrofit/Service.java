package com.example.svilenstrahilov.weatherapp.retrofit;

import com.google.gson.JsonObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Service {
    private final ApiInterface apiInterface;


    public Service(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void getResponseFromApi(final GetCallback callback) {
        apiInterface.response("ae3d24f1ab404816957121710171812", "Sofia", "json", 5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<JsonObject>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonObject jsonObject) {
                callback.onSuccess(jsonObject);

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
        JsonObject onSuccess(JsonObject jsonObject);

        void onError(String error);
    }
}
