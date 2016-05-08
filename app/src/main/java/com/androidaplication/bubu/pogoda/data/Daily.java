package com.androidaplication.bubu.pogoda.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Klaudia on 2016-05-06.
 */
public class Daily implements Parcelable{
    @SerializedName("summary")private String mSummary;
    @SerializedName("data")private List<DailyData> mDailyDatas = new ArrayList<>();

    public Daily() {}

    public static final Creator<Daily> CREATOR = new Creator<Daily>() {
        @Override
        public Daily createFromParcel(Parcel in) {
            return new Daily(in);
        }

        @Override
        public Daily[] newArray(int size) {
            return new Daily[size];
        }
    };

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public List<DailyData> getDailyDatas() {
        return mDailyDatas;
    }

    public void setDailyDatas(List<DailyData> dailyDatas) {
        mDailyDatas = dailyDatas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSummary);
        dest.writeList(mDailyDatas);
    }

    private Daily(Parcel in){
        mSummary = in.readString();
        mDailyDatas = in.readArrayList(DailyData.class.getClassLoader());
    }
}
