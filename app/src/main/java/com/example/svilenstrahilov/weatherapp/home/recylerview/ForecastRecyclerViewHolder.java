package com.example.svilenstrahilov.weatherapp.home.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.svilenstrahilov.weatherapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastRecyclerViewHolder extends RecyclerView.ViewHolder implements ForecastRecyclerRowView {
    @BindView(R.id.weekDay) TextView weekDay;
    @BindView(R.id.weekDayDegrees) TextView weekDayDegrees;

    ForecastRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setWeekday(String weekday) {
        weekDay.setText(weekday);
    }

    @Override
    public void setTemperature(String temperature) {
        weekDayDegrees.setText(temperature + "\u00b0");
    }
}
