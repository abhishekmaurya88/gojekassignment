package com.example.blackbird.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by blackbird on 7/10/17.
 */

public class ForecastModel implements Serializable {

    @SerializedName("forecastday")
    @Expose
    private ArrayList<ForecastDayModel> forecastDayModels;

    public ArrayList<ForecastDayModel> getForecastDayModels() {
        return forecastDayModels;
    }

    public void setForecastDayModels(ArrayList<ForecastDayModel> forecastDayModels) {
        this.forecastDayModels = forecastDayModels;
    }

    public ForecastModel(ArrayList<ForecastDayModel> forecastDayModels) {
        this.forecastDayModels = forecastDayModels;
    }

    public class ForecastDayModel implements Serializable{

        @SerializedName("date_epoch")
        @Expose
        private long date;

        @SerializedName("day")
        @Expose
        private DayModel dayModel;

        @SerializedName("hour")
        @Expose
        private ArrayList<HourModel> hourModels;

        @SerializedName("astro")
        @Expose
        private AstroModel astroModel;

        public AstroModel getAstroModel() {
            return astroModel;
        }

        public void setAstroModel(AstroModel astroModel) {
            this.astroModel = astroModel;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public DayModel getDayModel() {
            return dayModel;
        }

        public void setDayModel(DayModel dayModel) {
            this.dayModel = dayModel;
        }

        public ArrayList<HourModel> getHourModels() {
            return hourModels;
        }

        public void setHourModels(ArrayList<HourModel> hourModels) {
            this.hourModels = hourModels;
        }

        public ForecastDayModel(long date, DayModel dayModel, ArrayList<HourModel> hourModels, AstroModel astroModel) {
            this.date = date;
            this.dayModel = dayModel;
            this.hourModels = hourModels;
            this.astroModel = astroModel;
        }
    }
}
