package com.example.svilenstrahilov.weatherapp.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;
import com.example.svilenstrahilov.weatherapp.repository.FutureForecastRepository;
import com.example.svilenstrahilov.weatherapp.retrofit.Service;
import com.example.svilenstrahilov.weatherapp.retrofit.responseData.ResponseObj;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeMvpView, UserInputFragment.UserInputListener {
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

    private HomeAdapter homeAdapter;
    HomeMvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        File cacheFile = new File(getCacheDir(), "response");

        DaggerAppComponent.builder().appModule(new AppModule(getApplication())).networkModule(new NetworkModule(cacheFile)).roomModule(new RoomModule(getApplication())).build().inject(this);

        RecyclerView recyclerViewFutureForecast = findViewById(R.id.future_forecast);

        homeAdapter = new HomeAdapter(futureDayForecastList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewFutureForecast.setLayoutManager(mLayoutManager);
        recyclerViewFutureForecast.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFutureForecast.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerViewFutureForecast.setAdapter(homeAdapter);

        attachPresenter();
    }

    private void attachPresenter() {
        presenter = (HomeMvpPresenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new HomePresenter(this, service);
            presenter.callApi("Sofia", 5);
        }
        presenter.attachView(this, service);
    }

    @Override
    public void showProgress() {

    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    public void removeProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateViews(ResponseObj responseObj) {
        currentLocation.setText(responseObj.getData().getRequest().get(0).getQuery());
        currentDegrees.setText(responseObj.getData().getCurrentCondition().get(0).getTempCelsius() + "\u00b0");
        observation_time.setText(responseObj.getData().getCurrentCondition().get(0).getObservationTime());
        Picasso.with(this).load(responseObj.getData().getCurrentCondition().get(0).getWeatherIconUrl().get(0).getWeatherIconUrl()).into(weatherIcon);
        futureDayForecastList.addAll(responseObj.getData().getFutureDayForecasts());
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void getBackUserInput(String city, int days) {
        presenter.callApi(city, days);
    }
}
