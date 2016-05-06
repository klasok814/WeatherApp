package com.androidaplication.bubu.pogoda.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Klaudia on 2016-05-03.
 */
public class Weather {
    @SerializedName("timezone") private static String mTimezone;
    @SerializedName("currently") private Currently mCurrently;

    public Currently getCurrently(){
        return mCurrently;
    }

    public static String getTimezone(){
        return mTimezone;
    }

}
