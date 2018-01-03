package com.example.svilenstrahilov.weatherapp.home.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.svilenstrahilov.weatherapp.R;

public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastRecyclerViewHolder> {
    private ForecastRecyclerPresenter presenter;

    public ForecastRecyclerAdapter(ForecastRecyclerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ForecastRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForecastRecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ForecastRecyclerViewHolder holder, int position) {
        presenter.onBindForecastRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getForecastRowsCount();
    }
}
