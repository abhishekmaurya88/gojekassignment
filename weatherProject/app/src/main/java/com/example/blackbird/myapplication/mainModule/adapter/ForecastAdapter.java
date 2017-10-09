package com.example.blackbird.myapplication.mainModule.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blackbird.myapplication.R;
import com.example.blackbird.myapplication.common.CommonUtils;
import com.example.blackbird.myapplication.model.ForecastModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by blackbird on 7/10/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ForecastModel.ForecastDayModel> forecastDayModels;
    private Context context;
    private LayoutInflater inflater;

    public ForecastAdapter(Context context,ArrayList<ForecastModel.ForecastDayModel> forecastDayModels) {

        this.forecastDayModels = forecastDayModels;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.item_weather_list, parent, false);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int listPosition) {

        listPosition++;
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Picasso.with(context).load(forecastDayModels.get(listPosition).getDayModel().getConditionModel().
                getWeatherIcon().replace("//", "http://")).into(myViewHolder.imgWeather);
        myViewHolder.txtTemperature.setText("" + forecastDayModels.get(listPosition).getDayModel().getMaxTemperature() + (char) 0x00B0
        + "/" + forecastDayModels.get(listPosition).getDayModel().getMinTemperature() + (char) 0x00B0);
        myViewHolder.txtWeatherCondition.setText(forecastDayModels.get(listPosition).getDayModel().getConditionModel().getWeatherCondition());
        myViewHolder.txtDay.setText(new CommonUtils().returnDay(forecastDayModels.get(listPosition).getDate()));
    }

    @Override
    public int getItemCount() {
        return forecastDayModels.size()-1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        @Nullable
        ImageView imgWeather;
        @BindView(R.id.txt_day)
        TextView txtDay;
        @BindView(R.id.txt_temperature)
        TextView txtTemperature;
        @BindView(R.id.txt_weather_condition)
        TextView txtWeatherCondition;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
