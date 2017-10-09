package com.example.blackbird.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by blackbird on 9/10/17.
 */

public class AstroModel implements Serializable {

    @SerializedName("sunrise")
    private String sunrise;

    @SerializedName("sunset")
    private String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public AstroModel(String sunrise, String sunset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
