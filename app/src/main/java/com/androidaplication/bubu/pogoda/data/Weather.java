package com.androidaplication.bubu.pogoda.data;

import com.androidaplication.bubu.pogoda.R;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Klaudia on 2016-05-03.
 */
public class Weather {
    @SerializedName("currently") private Currently mCurrently;
    @SerializedName("hourly") private Hourly mHourly;
    @SerializedName("daily") private Daily mDaily;

    public Currently getCurrently(){
        return mCurrently;
    }

    public Hourly getHourly() {
        return mHourly;
    }

    public Daily getDaily(){
        return mDaily;
    }

    public static int getIconId(String stringIcon){
        if (stringIcon.equals("clear-day")) {
            return R.drawable.clear_day_icon;
        }
        else if (stringIcon.equals("clear-night")) {
            return R.drawable.clear_night_icon;
        }
        else if (stringIcon.equals("rain")) {
            return R.drawable.rain_icon;
        }
        else if (stringIcon.equals("snow")) {
            return R.drawable.snow_icon;
        }
        else if (stringIcon.equals("sleet")) {
            return R.drawable.sleet_icon;
        }
        else if (stringIcon.equals("wind")) {
            return R.drawable.wind_icon;
        }
        else if (stringIcon.equals("fog")) {
            return  R.drawable.fog_icon;
        }
        else if (stringIcon.equals("cloudy")) {
            return R.drawable.cloudy_icon;
        }
        else if (stringIcon.equals("partly-cloudy-day")) {
            return R.drawable.partly_cloudy_icon;
        }
        else if (stringIcon.equals("partly-cloudy-night")) {
            return R.drawable.cloudy_night_icon;
        }

        return R.drawable.clear_day;
    }

    public static int getFormatterTemperature(double dataTemperature){
        int temperature = (int) dataTemperature;
        temperature = (temperature - 32) * 5/9 ;
        return temperature;
    }

    public static String getFormatterTime(Long dataTime){
        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        Date dateTime = new Date(dataTime *1000);
        String timeFormat = formatter.format(dateTime);

        return timeFormat;
    }

    public static String getTranslateSummary(String dataSummary){
        if(dataSummary.equals("Clear"))
            return "Bezchmurnie";
        if(dataSummary.equals("Partly Cloudy"))
            return "Częściowe zachmurzenia";
        if(dataSummary.equals("Drizzle"))
            return "Mżawka";
        if(dataSummary.equals("Mostly Cloudy"))
            return "Pochmurnie";

        if(dataSummary.equals("Clear throughout the day."))
            return "Bezchmurnie cały dzień";
        if(dataSummary.equals("Partly cloudy until evening."))
            return "Częściowe zachmurzenia aż do wieczora";
        if(dataSummary.equals("Light rain starting in the afternoon."))
            return "Lekki deszcz po południu";
        if(dataSummary.equals("Light rain until evening."))
            return "Lekki deszcze aż do wieczora";
        if(dataSummary.equals("Mostly cloudy starting in the evening."))
            return "Wieczorem duże zachmurzenie";
        if(dataSummary.equals("Mostly cloudy until evening."))
            return "Pochmurnie aż do wieczora";

        return dataSummary;
    }

}
