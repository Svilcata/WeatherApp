package com.example.svilenstrahilov.weatherapp.data;

import android.os.AsyncTask;

import com.example.svilenstrahilov.weatherapp.repository.AppDatabase;
import com.example.svilenstrahilov.weatherapp.repository.WeatherDataSource;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

public class LocalCurrentConditionData implements WeatherDataSource<CurrentCondition> {
    private AppDatabase database;

    @Inject
    public LocalCurrentConditionData(AppDatabase appDatabase) {
        this.database = appDatabase;
    }

    @Override
    public void addItem(CurrentCondition item) {
        new addCCAsync(database).execute(item);
    }

    @Override
    public void addItems(List<CurrentCondition> items) {

    }

    @Override
    public void updateItem(CurrentCondition item) {

    }

    @Override
    public void updateItems(List<CurrentCondition> items) {

    }

    @Override
    public void removeItemById(String id) {
        new removeCCAsync(database).execute(id);
    }

    @Override
    public List<CurrentCondition> getItems() {
        return null;
    }

    @Override
    public CurrentCondition getItemById(String id) {
        try {
            return new getCCAsync(database).execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class getCCAsync extends AsyncTask<String, Void, CurrentCondition> {
        private AppDatabase appDatabase;

        getCCAsync(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected CurrentCondition doInBackground(String... strings) {
            return appDatabase.getCurrentConditionDao().getCCById(strings[0]);
        }
    }

    private static class removeCCAsync extends AsyncTask<String, Void, Void> {
        private AppDatabase appDatabase;

        removeCCAsync(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }


        @Override
        protected Void doInBackground(String... strings) {
            appDatabase.getCurrentConditionDao().deleteCondition(appDatabase.getCurrentConditionDao().getCCById(strings[0]));
            return null;
        }
    }

    private static class addCCAsync extends AsyncTask<CurrentCondition, Void, Void> {
        private AppDatabase appDatabase;

        addCCAsync(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(CurrentCondition... currentConditions) {
            appDatabase.getCurrentConditionDao().addCurrentCondition(currentConditions[0]);
            return null;
        }
    }
}
