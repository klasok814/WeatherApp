package com.androidaplication.bubu.pogoda.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Klaudia on 2016-05-06.
 */
public class Hourly implements Parcelable {
    @SerializedName("summary") private String mSummary;
    @SerializedName("data") private List<HourlyData> mHourlyDatas = new ArrayList<>();


    public Hourly() {}

    public static final Creator<Hourly> CREATOR = new Creator<Hourly>() {
        @Override
        public Hourly createFromParcel(Parcel in) {
            return new Hourly(in);
        }

        @Override
        public Hourly[] newArray(int size) {
            return new Hourly[size];
        }
    };

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public List<HourlyData> getHourlyDatas() {
        return mHourlyDatas;
    }

    public void setHourlyDatas(List<HourlyData> hourlyDatas) {
        mHourlyDatas = hourlyDatas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSummary);
        dest.writeList(mHourlyDatas);
    }

    private Hourly(Parcel in){
        mSummary = in.readString();
        mHourlyDatas = in.readArrayList(HourlyData.class.getClassLoader());
     }

    public String getTranslateSummary(){
        return Weather.getTranslateSummary(mSummary);
    }
}
