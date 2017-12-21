package com.example.svilenstrahilov.weatherapp.data;

import android.os.AsyncTask;

import com.example.svilenstrahilov.weatherapp.data.models.CurrentCondition;
import com.example.svilenstrahilov.weatherapp.data.models.dao.CurrentConditionDao;
import com.example.svilenstrahilov.weatherapp.repository.CurrentConditionRepository;

import javax.inject.Inject;

public class CurrentConditionDataSource implements CurrentConditionRepository {
    private CurrentConditionDao currentConditionDao;

    @Inject
    public CurrentConditionDataSource(CurrentConditionDao conditionDao) {
        this.currentConditionDao = conditionDao;
    }

    @Override
    public void addItem(CurrentCondition item) {
        new addCCAsync(currentConditionDao).execute(item);
    }

    @Override
    public void updateItem(CurrentCondition item) {

    }

    @Override
    public void removeItemById(String id) {

    }

    @Override
    public CurrentCondition getItemById(String id) {
        return null;
    }

    //    private static class getCCAsync extends AsyncTask<String, Void, CurrentCondition> {
//        private AppDatabase appDatabase;
//
//        getCCAsync(AppDatabase appDatabase) {
//            this.appDatabase = appDatabase;
//        }
//
//        @Override
//        protected CurrentCondition doInBackground(String... strings) {
//            return appDatabase.getCurrentConditionDao().getCCById(strings[0]);
//        }
//    }
//
//    private static class removeCCAsync extends AsyncTask<String, Void, Void> {
//        private AppDatabase appDatabase;
//
//        removeCCAsync(AppDatabase appDatabase) {
//            this.appDatabase = appDatabase;
//        }
//
//
//        @Override
//        protected Void doInBackground(String... strings) {
//            appDatabase.getCurrentConditionDao().deleteCondition(appDatabase.getCurrentConditionDao().getCCById(strings[0]));
//            return null;
//        }
//    }
//
    private static class addCCAsync extends AsyncTask<CurrentCondition, Void, Void> {
        private CurrentConditionDao currentConditionDao;

        public addCCAsync(CurrentConditionDao currentConditionDao) {
            this.currentConditionDao = currentConditionDao;
        }

        @Override
        protected Void doInBackground(CurrentCondition... currentConditions) {
            currentConditionDao.addCurrentCondition(currentConditions[0]);
            return null;
        }
    }
}
