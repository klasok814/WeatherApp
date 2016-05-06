package com.androidaplication.bubu.pogoda.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.androidaplication.bubu.pogoda.R;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Klaudia on 2016-05-03.
 */
public class Currently implements Parcelable {
    @SerializedName("time") private Long mTime;
    @SerializedName("summary") private String mSummary;
    @SerializedName("icon") private String mIcon;

    @SerializedName("precipIntensity") private double mPrecipIntensity; //intensywnosc opadow
    @SerializedName("precipProbability") private double mPrecipProbability; //prawdopodobienstwo opadow
    @SerializedName("temperature") private double mTemperature;
    @SerializedName("humidity") private double mHumidity;
    @SerializedName("windSpeed") private double mWindSpeed;
    @SerializedName("visibility") private double mVisibility;
    @SerializedName("cloudCover") private double mCloudCover; //zachmurzenie
    @SerializedName("pressure") private double mPressure;

    public Currently(){}

    public static final Creator<Currently> CREATOR = new Creator<Currently>() {
        @Override
        public Currently createFromParcel(Parcel in) {
            return new Currently(in);
        }

        @Override
        public Currently[] newArray(int size) {
            return new Currently[size];
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

    public double getPrecipIntensity() {
        return mPrecipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        mPrecipIntensity = precipIntensity;
    }

    public double getPrecipProbability() {
        return mPrecipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        mPrecipProbability = precipProbability;
    }

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }

    public double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        mWindSpeed = windSpeed;
    }

    public double getVisibility() {
        return mVisibility;
    }

    public void setVisibility(double visibility) {
        mVisibility = visibility;
    }

    public double getCloudCover() {
        return mCloudCover;
    }

    public void setCloudCover(double cloudCover) {
        mCloudCover = cloudCover;
    }

    public double getPressure() {
        return mPressure;
    }

    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    public String getTranslateSummary(){
        if(mSummary.equals("Clear"))
            return "Słoneczny dzień";
        if(mSummary.equals("Partly Cloudy"))
            return "Częściowe zachmurzenia";
        if(mSummary.equals("Drizzle"))
            return "Mżawka";
        return mSummary;
    }

    public int getBackgroundIconId(){
        if(mIcon.equals("clear-day"))
            return R.drawable.clear_day;
        else if(mIcon.equals("clear-night"))
            return R.drawable.clear_night;
        else if(mIcon.equals("partly-cloudy-day"))
            return  R.drawable.partly_cloudly;

        return R.drawable.clear_night;
    }

    public String getFormatterTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        Date dateTime = new Date(getTime() *1000);
        String timeFormat = formatter.format(dateTime);

        return timeFormat;
    }

    public int getFormatterTemperature(){
        int temperature = (int) getTemperature();
        temperature = (temperature - 32) * 5/9 ;
        return temperature;
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
        dest.writeDouble(mPrecipIntensity);
        dest.writeDouble(mPrecipProbability);
        dest.writeDouble(mTemperature);
        dest.writeDouble(mHumidity);
        dest.writeDouble(mWindSpeed);
        dest.writeDouble(mVisibility);
        dest.writeDouble(mCloudCover);
        dest.writeDouble(mPressure);
    }

    private Currently(Parcel in){
        mTime = in.readLong();
        mSummary = in.readString();
        mIcon = in.readString();
        mPrecipIntensity = in.readDouble();
        mPrecipProbability = in.readDouble();
        mTemperature = in.readDouble();
        mHumidity = in.readDouble();
        mWindSpeed = in.readDouble();
        mVisibility = in.readDouble();
        mCloudCover = in.readDouble();
        mPressure = in.readDouble();
    }
}
