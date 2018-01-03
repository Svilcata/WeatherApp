package com.example.svilenstrahilov.weatherapp.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.svilenstrahilov.weatherapp.R;
import com.example.svilenstrahilov.weatherapp.dagger.AppModule;
import com.example.svilenstrahilov.weatherapp.dagger.DaggerAppComponent;
import com.example.svilenstrahilov.weatherapp.dagger.NetworkModule;
import com.example.svilenstrahilov.weatherapp.dagger.RoomModule;
import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;
import com.example.svilenstrahilov.weatherapp.home.inputdialog.InputDialog;
import com.example.svilenstrahilov.weatherapp.home.recylerview.ForecastRecyclerAdapter;
import com.example.svilenstrahilov.weatherapp.home.recylerview.ForecastRecyclerPresenter;
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeMvpView, InputDialog.UserInputListener {
    @Inject
    CurrentConditionRepository currentConditionRepository;
    @Inject
    FutureForecastRepository futureForecastRepository;
    @Inject
    Service service;

    private List<FutureDayForecast> futureDayForecastList = new ArrayList<>();

    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.currentDegrees)
    TextView currentDegrees;
    @BindView(R.id.currentLocation)
    TextView currentLocation;
    @BindView(R.id.observation_time)
    TextView observation_time;
    @BindView(R.id.weatherIcon)
    ImageView weatherIcon;

    private ForecastRecyclerAdapter forecastRecyclerAdapter;
    HomeMvpPresenter homeMvpPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerAppComponent.builder().appModule(new AppModule(getApplication())).networkModule(new NetworkModule()).roomModule(new RoomModule(getApplication())).build().inject(this);

        RecyclerView recyclerViewFutureForecast = findViewById(R.id.future_forecast);
        ForecastRecyclerPresenter recyclerViewPresenter = new ForecastRecyclerPresenter(futureDayForecastList);
        forecastRecyclerAdapter = new ForecastRecyclerAdapter(recyclerViewPresenter);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewFutureForecast.setLayoutManager(mLayoutManager);
        recyclerViewFutureForecast.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFutureForecast.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerViewFutureForecast.setAdapter(forecastRecyclerAdapter);

        attachMainPresenter();
    }

    private void attachMainPresenter() {
        homeMvpPresenter = (HomeMvpPresenter) getLastCustomNonConfigurationInstance();
        if (homeMvpPresenter == null) {
            homeMvpPresenter = new HomePresenter(this, service);
//            try {
//                homeMvpPresenter.initData(currentConditionRepository, futureForecastRepository);
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//            }
        }
        homeMvpPresenter.attachView(this, service);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.input:
                attachDialog();
                return true;
            case R.id.saveData:
                saveData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveData() {
        homeMvpPresenter.saveDataToDB(currentConditionRepository, futureForecastRepository);
    }

    @Override
    protected void onDestroy() {
        homeMvpPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return homeMvpPresenter;
    }

    @Override
    public void removeProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void attachDialog() {
        homeMvpPresenter.attachDialog(getSupportFragmentManager());
    }

    @Override
    public void updateViews(ResponseObj responseObj) {
        try {
            currentLocation.setText(responseObj.getData().getRequest().get(0).getQuery());
            currentDegrees.setText(responseObj.getData().getCurrentCondition().get(0).getTempCelsius() + "\u00b0");
            observation_time.setText(responseObj.getData().getCurrentCondition().get(0).getObservationTime());
            Picasso.with(this).load(responseObj.getData().getCurrentCondition().get(0).getWeatherIconUrl().get(0).getWeatherIconUrl()).into(weatherIcon);
            futureDayForecastList.addAll(responseObj.getData().getFutureDayForecasts());
            forecastRecyclerAdapter.notifyDataSetChanged();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void inputListener(String cityName, int daysForecast) {
        homeMvpPresenter.callApi(cityName, daysForecast);
    }
}
