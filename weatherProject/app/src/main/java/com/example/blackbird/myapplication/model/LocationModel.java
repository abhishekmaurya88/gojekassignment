package com.example.blackbird.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by blackbird on 7/10/17.
 */

public class LocationModel implements Serializable{

    @SerializedName("name")
    @Expose
    private String locationName;
    @SerializedName("region")
    @Expose
    private String locationRegion;
    @SerializedName("localtime_epoch")
    @Expose
    private long localTime;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationRegion() {
        return locationRegion;
    }

    public void setLocationRegion(String locationRegion) {
        this.locationRegion = locationRegion;
    }

    public long getLocalTime() {
        return localTime;
    }

    public void setLocalTime(long localTime) {
        this.localTime = localTime;
    }

    public LocationModel(String locationName, String locationRegion, long localTime) {
        this.locationName = locationName;
        this.locationRegion = locationRegion;
        this.localTime = localTime;
    }
}
