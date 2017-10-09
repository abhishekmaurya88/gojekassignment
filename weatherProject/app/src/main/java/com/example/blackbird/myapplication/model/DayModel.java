package com.example.blackbird.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by blackbird on 7/10/17.
 */

public class DayModel implements Serializable {

    @SerializedName("avgtemp_c")
    @Expose
    private double averageTemperature;

    @SerializedName("condition")
    @Expose
    private ConditionModel conditionModel;

    @SerializedName("feelslike_c")
    @Expose
    private double feelLikeTemp;

    @SerializedName("wind_dir")
    @Expose
    private String windDirection;

    @SerializedName("maxtemp_c")
    @Expose
    private double maxTemperature;

    @SerializedName("mintemp_c")
    @Expose
    private double minTemperature;

    @SerializedName("maxwind_kph")
    @Expose
    private double windSpeed;

    @SerializedName("time_epoch")
    @Expose
    private long timeDay;

    @SerializedName("avghumidity")
    @Expose
    private int avgHumidity;

    @SerializedName("uv")
    @Expose
    private double uvIndex;



    public long getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(long timeDay) {
        this.timeDay = timeDay;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
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

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public ConditionModel getConditionModel() {
        return conditionModel;
    }

    public void setConditionModel(ConditionModel conditionModel) {
        this.conditionModel = conditionModel;
    }


    public int getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(int avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }



    public DayModel(double averageTemperature, ConditionModel conditionModel, double feelLikeTemp, String windDirection, double maxTemperature,
                    double minTemperature, double windSpeed, long timeDay, int avgHumidity, double uvIndex) {

        this.averageTemperature = averageTemperature;
        this.conditionModel = conditionModel;
        this.feelLikeTemp = feelLikeTemp;
        this.windDirection = windDirection;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.windSpeed = windSpeed;
        this.timeDay = timeDay;
        this.avgHumidity = avgHumidity;
        this.uvIndex = uvIndex;
    }
}
