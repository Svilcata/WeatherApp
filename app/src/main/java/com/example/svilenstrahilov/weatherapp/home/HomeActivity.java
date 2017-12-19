package com.example.svilenstrahilov.weatherapp.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.svilenstrahilov.weatherapp.R;
import com.example.svilenstrahilov.weatherapp.dagger.AppModule;
import com.example.svilenstrahilov.weatherapp.dagger.DaggerAppComponent;
import com.example.svilenstrahilov.weatherapp.dagger.RoomModule;
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeMvpView {
    @Inject
    CurrentConditionRepository currentConditionRepository;

    @Inject
    FutureForecastRepository futureForecastRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder().appModule(new AppModule(getApplication())).roomModule(new RoomModule(getApplication())).build().inject(this);

//        currentConditionRepository.addItem(new CurrentCondition("123", "321", "12443", "asdas.wads.sd", "snowy"));

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void removeProgress() {

    }
}
