package com.example.blackbird.myapplication.mainModule.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.blackbird.myapplication.R;
import com.example.blackbird.myapplication.api.response.BaseResponse;
import com.example.blackbird.myapplication.common.CommonUtils;
import com.example.blackbird.myapplication.common.Constants;
import com.example.blackbird.myapplication.mainModule.adapter.ForecastAdapter;
import com.example.blackbird.myapplication.mainModule.adapter.GridAdapter;
import com.example.blackbird.myapplication.mainModule.adapter.HourlyTemperatureAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by blackbird on 8/10/17.
 */

public class ContentFragment extends Fragment {

    private Unbinder unbinder;
    private Activity activity;

    @BindView(R.id.txt_temp)
    TextView txtTemp;

    @BindView(R.id.txt_city)
    TextView txtCity;

    @BindView(R.id.txt_date)
    TextView txtDate;

    @BindView(R.id.txt_weather_condition)
    TextView txtWeatherCondition;

    @BindView(R.id.img_weather_icon)
    ImageView imgWeatherIcon;

    @BindView(R.id.rv_weather_hourly_items)
    public RecyclerView rvWeatherHourlyItem;

    @BindView(R.id.rv_weather_items)
    public RecyclerView rvWeatherItem;

    @BindView(R.id.rv_forecast_item)
    public RecyclerView rvForecastItem;

    @BindView(R.id.rlt_layout_content)
    RelativeLayout rltLayoutContent;

    private BaseResponse baseResponse;
    private GridAdapter gridAdapter;
    private GridLayoutManager gridLayoutManager;
    private ForecastAdapter forecastAdapter;
    private HourlyTemperatureAdapter hourlyTemperatureAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);
        unbinder = ButterKnife.bind(this, view);
        activity = getActivity();
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            baseResponse = (BaseResponse) bundle.getSerializable(Constants.OBJECT);
            animateView(rltLayoutContent);
            setTopData();
        }
        return view;
    }


    private void setTopData() {

        txtCity.setText(baseResponse.getLocation().getLocationName());
        txtTemp.setText("" + baseResponse.getCurrent().getCurrentTemperature() + (char) 0x00B0);
        txtWeatherCondition.setText(baseResponse.getCurrent().getConditionModel().getWeatherCondition());
        txtDate.setText(new CommonUtils().returnDate(baseResponse.getCurrent().getLastUpdate()));
        Picasso.with(activity).load(baseResponse.getCurrent().getConditionModel().getWeatherIcon().replace("//", "http://")).into(imgWeatherIcon);

    }

    private void setListData(){
        setWeatherDetailsAdapter();
        setHourlyAdapter();
        setForecastAdapter();
    }

    private void setWeatherDetailsAdapter() {

        gridAdapter = new GridAdapter(activity, baseResponse);
        gridLayoutManager = new GridLayoutManager(activity, 2);
        rvWeatherItem.setLayoutManager(gridLayoutManager);
        rvWeatherItem.setAdapter(gridAdapter);
        rvWeatherItem.setNestedScrollingEnabled(false);
    }

    private void setForecastAdapter() {

        forecastAdapter = new ForecastAdapter(activity, baseResponse.getForecastModel().getForecastDayModels());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);

        rvForecastItem.setLayoutManager(linearLayoutManager);
        rvForecastItem.setAdapter(forecastAdapter);
        rvForecastItem.setNestedScrollingEnabled(false);
    }

    private void setHourlyAdapter() {

        hourlyTemperatureAdapter = new HourlyTemperatureAdapter(activity, baseResponse.getForecastModel().
                getForecastDayModels().get(0).getHourModels());
        LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);

        rvWeatherHourlyItem.setLayoutManager(linearLayoutManagerHorizontal);
        rvWeatherHourlyItem.setAdapter(hourlyTemperatureAdapter);
        rvWeatherHourlyItem.setNestedScrollingEnabled(false);
    }

    public static ContentFragment newInstance(BaseResponse baseResponse) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constants.OBJECT, baseResponse);
        fragment.setArguments(args);
        return fragment;
    }

    private void animateView(final View view) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.VISIBLE);
                Animation animation = new TranslateAnimation(0,0, 100, view.getHeight());
                animation.setDuration(1000);
                animation.setFillAfter(true);
                view.startAnimation(animation);


                setListData();
            }
        }, 200);

    }

}
