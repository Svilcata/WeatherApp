package com.example.svilenstrahilov.weatherapp.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.svilenstrahilov.weatherapp.R;
import com.example.svilenstrahilov.weatherapp.dagger.AppModule;
import com.example.svilenstrahilov.weatherapp.dagger.DaggerAppComponent;
import com.example.svilenstrahilov.weatherapp.dagger.NetworkModule;
import com.example.svilenstrahilov.weatherapp.dagger.RoomModule;
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeMvpView {
    @Inject
    CurrentConditionRepository currentConditionRepository;

    @Inject
    FutureForecastRepository futureForecastRepository;

    @Inject
    Service service;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File cacheFile = new File(getCacheDir(), "response");
        DaggerAppComponent.builder().appModule(new AppModule(getApplication())).networkModule(new NetworkModule(cacheFile)).roomModule(new RoomModule(getApplication())).build().inject(this);

        progressBar = findViewById(R.id.progress);

        HomePresenter presenter = new HomePresenter(this, service);
        presenter.callApi();


//        currentConditionRepository.addItem(new CurrentCondition("123", "321", "12443", "asdas.wads.sd", "snowy"));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void removeProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loadData(JsonObject jsonObject) {
        Log.e("LOG", jsonObject.toString());
        JsonElement jsonElement = jsonObject.get("data");
        Log.e("LOG", jsonElement.toString());
    }
}
