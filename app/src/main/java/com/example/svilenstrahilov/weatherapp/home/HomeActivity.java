package com.example.svilenstrahilov.weatherapp.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.svilenstrahilov.weatherapp.R;

public class HomeActivity extends AppCompatActivity implements HomeMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
