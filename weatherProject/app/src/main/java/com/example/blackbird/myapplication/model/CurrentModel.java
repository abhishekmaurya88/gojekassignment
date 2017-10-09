package com.example.blackbird.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by blackbird on 7/10/17.
 */

public class CurrentModel implements Serializable{

    @SerializedName("last_updated_epoch")
    @Expose
    private long lastUpdate;

    @SerializedName("temp_c")
    @Expose
    private double currentTemperature;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("cloud")
    @Expose
    private int cloud;

    @SerializedName("condition")
    @Expose
    private ConditionModel conditionModel;

    @SerializedName("feelslike_c")
    @Expose
    private double feelLikeTemp;

    @SerializedName("wind_dir")
    @Expose
    private String windDirection;

    @SerializedName("wind_kph")
    @Expose
    private double windSpeed;

    @SerializedName("vis_km")
    @Expose
    private double visibilty;

    @SerializedName("precip_in")
    @Expose
    private double precipitation;

    @SerializedName("pressure_in")
    @Expose
    private double pressure;

    public double getVisibilty() {
        return visibilty;
    }

    public void setVisibilty(double visibilty) {
        this.visibilty = visibilty;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getFeelLikeTemp() {
        return feelLikeTemp;
    }

    public void setFeelLikeTemp(double feelLikeTemp) {
        this.feelLikeTemp = feelLikeTemp;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public ConditionModel getConditionModel() {
        return conditionModel;
    }

    public void setConditionModel(ConditionModel conditionModel) {
        this.conditionModel = conditionModel;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
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

    public CurrentModel(long lastUpdate, double currentTemperature, int humidity, int cloud, ConditionModel conditionModel,
                        double feelLikeTemp, String windDirection, double windSpeed, double visibilty, double precipitation, double pressure) {
        this.lastUpdate = lastUpdate;
        this.currentTemperature = currentTemperature;
        this.humidity = humidity;
        this.cloud = cloud;
        this.conditionModel = conditionModel;
        this.feelLikeTemp = feelLikeTemp;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.visibilty = visibilty;
        this.precipitation = precipitation;
        this.pressure = pressure;
    }
}
