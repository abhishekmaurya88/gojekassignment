package com.example.blackbird.myapplication.api;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;

import com.example.blackbird.myapplication.api.retrofit.RetrofitCallback;
import com.example.blackbird.myapplication.api.retrofit.RetrofitSingleton;
import com.example.blackbird.myapplication.common.Constants;
import com.example.blackbird.myapplication.model.ApiError;

/**
 * Created by blackbird on 7/10/17.
 */


public class WeatherApi extends Constants{

    public static abstract class Callback<T> {
        public abstract void onSuccess(T response);

        public abstract void onError(ApiError error);

        public void onComplete() {
        }
    }

    private Context context;

    private static WeatherApi mInstance;

    private WeatherApi(Context context) {
        this.context = context;
    }

    private WeatherApi() {
    }

    public static synchronized WeatherApi getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new WeatherApi(application.getApplicationContext());
        }
        return mInstance;
    }

    public static synchronized WeatherApi getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new WeatherApi(context);
        }
        return mInstance;
    }

    public void weatherApiCall(String cityName, final RetrofitCallback callback) {

        RetrofitSingleton.getInstance(context).weatherApiData(API_KEY, cityName, 5).enqueue(callback);
    }

}
