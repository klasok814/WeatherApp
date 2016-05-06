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
public class HourlyData implements Parcelable{
    @SerializedName("time")private Long mTime;
    @SerializedName("icon") private String mIcon;
    @SerializedName("summary")private String mSummary;
    @SerializedName("temperature")private double mTemperature;

    public HourlyData() {}

    public static final Creator<HourlyData> CREATOR = new Creator<HourlyData>() {
        @Override
        public HourlyData createFromParcel(Parcel in) {
            return new HourlyData(in);
        }

        @Override
        public HourlyData[] newArray(int size) {
            return new HourlyData[size];
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

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getFormatterTemperature() {
       return Weather.getFormatterTemperature(mTemperature);
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
        dest.writeDouble(mTemperature);
    }

    private HourlyData(Parcel in){
        mTime = in.readLong();
        mSummary = in.readString();
        mIcon = in.readString();
        mTemperature = in.readDouble();
    }

    public String getFormatterTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("kk");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        Date dateTime = new Date(mTime *1000);
        String timeFormat = formatter.format(dateTime);

        return timeFormat;
    }


    public int getIconId() {
        return Weather.getIconId(mIcon);
    }

    public String getTranslateSummary() {
        return Weather.getTranslateSummary(mSummary);
    }
}
