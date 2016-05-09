package com.androidaplication.bubu.pogoda.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DailyData implements Parcelable{
    @SerializedName("time")private Long mTime;
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

    public String getDayOfTheWeek() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        Date dateTime = new Date(mTime * 1000);
        return formatter.format(dateTime);
    }

    public String getFormatterSunriseTime(){
        return Weather.getFormatterTime(mSunriseTime);
    }

    public String getFormatterSunsetTime(){
        return Weather.getFormatterTime(mSunsetTime);
    }

    public int getFormatterMaxTemperature(){
        return Weather.getFormatterTemperature(mTemperatureMax);
    }

    public int getFormatterMinTemperature(){
        return Weather.getFormatterTemperature(mTemperatureMin);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeLong(mSunriseTime);
        dest.writeLong(mSunsetTime);
        dest.writeDouble(mMoonPhase);
        dest.writeDouble(mTemperatureMax);
        dest.writeDouble(mTemperatureMin);
    }

    private DailyData(Parcel in){
        mTime = in.readLong();
        mSunriseTime = in.readLong();
        mSunsetTime = in.readLong();
        mMoonPhase = in.readDouble();
        mTemperatureMax = in.readDouble();
        mTemperatureMin = in.readDouble();
    }
}
