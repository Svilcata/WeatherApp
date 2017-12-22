package com.example.svilenstrahilov.weatherapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.svilenstrahilov.weatherapp.R;
import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<FutureDayForecast> futureDayForecasts;

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.weekDay) TextView weekDay;
        @BindView(R.id.weekDayDegrees)TextView weekDayDegrees;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    HomeAdapter(List<FutureDayForecast> futureDayForecasts) {
        this.futureDayForecasts = futureDayForecasts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        FutureDayForecast futureDayForecast = futureDayForecasts.get(position);
        holder.weekDayDegrees.setText(futureDayForecast.getMaxTempCelsius() + "\u00b0");

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date myDate = simpleDateFormat.parse(futureDayForecast.getDate());
            simpleDateFormat.applyPattern("EEEE");
            String weekDay = simpleDateFormat.format(myDate);
            holder.weekDay.setText(weekDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return futureDayForecasts.size();
    }


}
