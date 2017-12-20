package com.example.svilenstrahilov.weatherapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.svilenstrahilov.weatherapp.R;
import com.example.svilenstrahilov.weatherapp.data.models.FutureDayForecast;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    List<FutureDayForecast> futureDayForecasts;
    private Context context;

    public HomeAdapter(Context context, List<FutureDayForecast> futureDayForecasts, Context context1) {
        this.futureDayForecasts = futureDayForecasts;
        this.context = context1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return futureDayForecasts.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView weekDay, weekDayDegrees;

        ViewHolder(View itemView) {
            super(itemView);
            weekDay = itemView.findViewById(R.id.weekDay);
            weekDayDegrees = itemView.findViewById(R.id.weekDayDegrees);
        }
    }
}
