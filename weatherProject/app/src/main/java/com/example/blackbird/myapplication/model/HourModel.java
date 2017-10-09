package com.example.blackbird.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by blackbird on 7/10/17.
 */

public class HourModel implements Serializable {

    @SerializedName("time_epoch")
    @Expose
    private long time;

    @SerializedName("temp_c")
    @Expose
    private double temperature;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("cloud")
    @Expose
    private int cloud;

    @SerializedName("condition")
    @Expose
    private ConditionModel conditionModel;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public ConditionModel getConditionModel() {
        return conditionModel;
    }

    public void setConditionModel(ConditionModel conditionModel) {
        this.conditionModel = conditionModel;
    }

    public HourModel(long time, double temperature, int humidity, int cloud, ConditionModel conditionModel) {
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.cloud = cloud;
        this.conditionModel = conditionModel;
    }
}
