package com.androidaplication.bubu.pogoda.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidaplication.bubu.pogoda.R;
import com.androidaplication.bubu.pogoda.data.Currently;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WeatherDetails extends AppCompatActivity {
    @Bind(R.id.percipIntenceLayout) LinearLayout mPercipIntensityLayout;
    @Bind(R.id.percipProbabilityLayout) LinearLayout mPercipProbabilityLayout;
    @Bind(R.id.temperatureLayout) LinearLayout mTemperatureLayout;
    @Bind(R.id.humidityLayout)LinearLayout mHumidityLayout;
    @Bind(R.id.windSpeedLayout)LinearLayout mWindSpeedLayout;
    @Bind(R.id.visibilityLayout)LinearLayout mVisibilityLayout;
    @Bind(R.id.cloudCoverLayout)LinearLayout mCloudCoverLayout;
    @Bind(R.id.pressureLayout)LinearLayout mPressureLayout;


    private Currently mCurrently;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(R.string.weather_details_actionbar_title);

        mCurrently = getIntent().getParcelableExtra(KeyClass.WEATHER_DETAILS);
        updateDisplay();
    }

    private void updateDisplay(){
        updateLayout(mPercipIntensityLayout, getString(R.string.precipIntencity_description),
                mCurrently.getPrecipIntensity() + "",getString(R.string.symbol_mm));
        updateLayout(mPercipProbabilityLayout, getString(R.string.percipIntensity_description),
                (mCurrently.getPrecipProbability()*100) + "",getString(R.string.symbol_percent));
        updateLayout(mHumidityLayout, getString(R.string.humidity_description),
                (mCurrently.getHumidity()*100) + "",getString(R.string.symbol_percent));
        updateLayout(mPressureLayout, getString(R.string.pressure_description),
                mCurrently.getPressure() + "",getString(R.string.symbol_hPa));
        updateLayout(mTemperatureLayout, getString(R.string.temperature_description),
                mCurrently.getFormatterTemperature() + "",getString(R.string.symbol_celciusza));
        updateLayout(mCloudCoverLayout, getString(R.string.cloudCover_description),
                (mCurrently.getCloudCover()*100) + "",getString(R.string.symbol_percent));
        updateLayout(mWindSpeedLayout, getString(R.string.windSpeed_description),
                mCurrently.getWindSpeed() + "",getString(R.string.symbol_km_h));
        updateLayout(mVisibilityLayout, getString(R.string.visibility_description),
                mCurrently.getVisibility() + "",getString(R.string.symbol_percent));
    }

    private void updateLayout(LinearLayout layout, String updateText, String updateData, String updateCharacter){
        TextView parameterLabel = (TextView) layout.getChildAt(0);
        parameterLabel.setText(updateText);
        TextView dataLabel = (TextView) layout.getChildAt(1);
        dataLabel.setText(updateData);
        TextView characterLabel = (TextView) layout.getChildAt(2);
        characterLabel.setText(updateCharacter);
    }
}
