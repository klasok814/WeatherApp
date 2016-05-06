package com.androidaplication.bubu.pogoda.data;

/**
 * Created by Klaudia on 2016-05-06.
 */
public class Hourly {
    private Long mTime;
    private String mSummary;
    private String mIcon;
    private String mTemperature;

    public Hourly() {}

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

    public String getTemperature() {
        return mTemperature;
    }

    public void setTemperature(String temperature) {
        mTemperature = temperature;
    }
}
