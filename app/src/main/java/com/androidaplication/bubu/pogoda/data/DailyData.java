package com.androidaplication.bubu.pogoda.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Klaudia on 2016-05-06.
 */
public class DailyData {
    @SerializedName("time")private Long mTime;
    @SerializedName("summary")private String mSummary;
    @SerializedName("icon")private String mIcon;

    @SerializedName("sunriseTime")private Long mSunriseTime;
    @SerializedName("sunsetTime")private Long mSunsetTime;
    @SerializedName("moonPhase")private double mMoonPhase;
    @SerializedName("temperatureMin")private double mTemperatureMin;
    @SerializedName("temperatureMax")private double mTemperatureMax;

    public DailyData() {}

    public Long getTime() {
        return mTime;
    }

    public void setTime(Long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public Long getSunriseTime() {
        return mSunriseTime;
    }

    public void setSunriseTime(Long sunriseTime) {
        mSunriseTime = sunriseTime;
    }

    public Long getSunsetTime() {
        return mSunsetTime;
    }

    public void setSunsetTime(Long sunsetTime) {
        mSunsetTime = sunsetTime;
    }

    public double getMoonPhase() {
        return mMoonPhase;
    }

    public void setMoonPhase(double moonPhase) {
        mMoonPhase = moonPhase;
    }

    public double getTemperatureMin() {
        return mTemperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        mTemperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return mTemperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }
}
