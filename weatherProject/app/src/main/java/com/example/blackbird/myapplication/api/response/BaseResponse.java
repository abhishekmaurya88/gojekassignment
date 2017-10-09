package com.example.blackbird.myapplication.api.response;

import com.example.blackbird.myapplication.model.ApiError;
import com.example.blackbird.myapplication.model.CurrentModel;
import com.example.blackbird.myapplication.model.ForecastModel;
import com.example.blackbird.myapplication.model.LocationModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by blackbird on 7/10/17.
 */


public class BaseResponse implements Serializable{

    @SerializedName("location")
    @Expose
    private LocationModel location;

    @SerializedName("current")
    @Expose
    private CurrentModel current;

    @SerializedName("forecast")
    @Expose
    private ForecastModel forecastModel;

    @SerializedName("status")
    @Expose
    private String status;

    public CurrentModel getCurrent() {
        return current;
    }

    public void setCurrent(CurrentModel current) {
        this.current = current;
    }

    public ForecastModel getForecastModel() {
        return forecastModel;
    }

    public void setForecastModel(ForecastModel forecastModel) {
        this.forecastModel = forecastModel;
    }

    public LocationModel getLocation() {

        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BaseResponse(LocationModel location, CurrentModel current, ForecastModel forecastModel) {

        this.current = current;
        this.location = location;
        this.forecastModel = forecastModel;
    }

    public ApiError getError() {
        if(status!=null && status.equals("failure"))
        {
            ApiError error = new ApiError();
        }
        return null;
    }
}

