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
import com.example.blackbird.myapplication.model.HourModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by blackbird on 8/10/17.
 */

public class HourlyTemperatureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<HourModel> dayModels;
    private Context context;
    private LayoutInflater inflater;

    public HourlyTemperatureAdapter(Context context,ArrayList<HourModel> dayModels) {

        this.dayModels = dayModels;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.item_weather_hourly, parent, false);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int listPosition) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Picasso.with(context).load(dayModels.get(listPosition).getConditionModel().getWeatherIcon().replace("//", "http://")).
                placeholder(R.drawable.icon_default).into(myViewHolder.imgWeather);
        myViewHolder.txtTemperature.setText("" + dayModels.get(listPosition).getTemperature() + (char) 0x00B0);
        myViewHolder.txtTime.setText(new CommonUtils().returnTime(dayModels.get(listPosition).getTime()));
    }

    @Override
    public int getItemCount() {
        return dayModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        @Nullable
        ImageView imgWeather;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.txt_temperature)
        TextView txtTemperature;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
