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
        new AddCurrentConditionAsync(currentConditionDao).execute(item);
    }

    @Override
    public void updateItem(CurrentCondition item) {

    }

    @Override
    public void removeItemById(String id) {

    }

    @Override
    public AsyncTask<String, Void, CurrentCondition> getItemById(String id, AsyncResponseCC asyncResponseCC) {
        return new GetCurrentConditionAsync(currentConditionDao, asyncResponseCC).execute(id);
    }

    private static class GetCurrentConditionAsync extends AsyncTask<String, Void, CurrentCondition> {
        AsyncResponseCC delegate = null;
        private CurrentConditionDao currentConditionDao;

        public GetCurrentConditionAsync(CurrentConditionDao currentConditionDao, AsyncResponseCC delegate) {
            this.currentConditionDao = currentConditionDao;
            this.delegate = delegate;
        }

        @Override
        protected CurrentCondition doInBackground(String... strings) {
            return currentConditionDao.getCCById(strings[0]);
        }

        @Override
        protected void onPostExecute(CurrentCondition currentCondition) {
            delegate.processFinish(currentCondition);
        }
    }

    private static class AddCurrentConditionAsync extends AsyncTask<CurrentCondition, Void, Void> {
        private CurrentConditionDao currentConditionDao;

        AddCurrentConditionAsync(CurrentConditionDao currentConditionDao) {
            this.currentConditionDao = currentConditionDao;
        }

        @Override
        protected Void doInBackground(CurrentCondition... currentConditions) {
            currentConditionDao.addCurrentCondition(currentConditions[0]);
            return null;
        }
    }
}
