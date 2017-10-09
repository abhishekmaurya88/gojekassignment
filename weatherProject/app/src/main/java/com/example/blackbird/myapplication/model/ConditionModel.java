package com.example.blackbird.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by blackbird on 7/10/17.
 */

public class ConditionModel implements Serializable{

    @SerializedName("text")
    @Expose
    private String weatherCondition;

    @SerializedName("icon")
    @Expose
    private String weatherIcon;

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public ConditionModel(String weatherCondition, String weatherIcon) {
        this.weatherCondition = weatherCondition;
        this.weatherIcon = weatherIcon;
    }
}
