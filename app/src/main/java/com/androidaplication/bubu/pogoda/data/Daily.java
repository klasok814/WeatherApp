package com.androidaplication.bubu.pogoda.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Klaudia on 2016-05-06.
 */
public class Daily {
    @SerializedName("summary")private String mSummary;
    @SerializedName("data")private List<DailyData> mDailyDatas;

    public Daily() {}

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
}
