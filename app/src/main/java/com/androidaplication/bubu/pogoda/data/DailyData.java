package com.androidaplication.bubu.pogoda.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Klaudia on 2016-05-06.
 */
public class DailyData implements Parcelable{
    @SerializedName("time")private Long mTime;
    @SerializedName("summary")private String mSummary;
    @SerializedName("icon")private String mIcon;

    @SerializedName("sunriseTime")private Long mSunriseTime;
    @SerializedName("sunsetTime")private Long mSunsetTime;
    @SerializedName("moonPhase")private double mMoonPhase;
    @SerializedName("temperatureMin")private double mTemperatureMin;
    @SerializedName("temperatureMax")private double mTemperatureMax;

    public DailyData() {}

    public static final Creator<DailyData> CREATOR = new Creator<DailyData>() {
        @Override
        public DailyData createFromParcel(Parcel in) {
            return new DailyData(in);
        }

        @Override
        public DailyData[] newArray(int size) {
            return new DailyData[size];
        }
    };

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

    public int getFormatterTemperature(){
        return Weather.getFormatterTemperature(mTemperatureMax);
    }

    public int getIconId(){
        return  Weather.getIconId(mIcon);
    }

    public String getDayOfTheWeek() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        Date dateTime = new Date(mTime * 1000);
        return formatter.format(dateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeString(mIcon);
        dest.writeLong(mSunriseTime);
        dest.writeLong(mSunsetTime);
        dest.writeDouble(mMoonPhase);
        dest.writeDouble(mTemperatureMax);
        dest.writeDouble(mTemperatureMin);
    }

    private DailyData(Parcel in){
        mTime = in.readLong();
        mSummary = in.readString();
        mIcon = in.readString();
        mSunriseTime = in.readLong();
        mSunsetTime = in.readLong();
        mMoonPhase = in.readDouble();
        mTemperatureMax = in.readDouble();
        mTemperatureMin = in.readDouble();
    }
}
