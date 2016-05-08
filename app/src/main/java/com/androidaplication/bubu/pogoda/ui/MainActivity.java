package com.androidaplication.bubu.pogoda.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidaplication.bubu.pogoda.R;
import com.androidaplication.bubu.pogoda.data.Currently;
import com.androidaplication.bubu.pogoda.data.Daily;
import com.androidaplication.bubu.pogoda.data.Hourly;
import com.androidaplication.bubu.pogoda.data.Weather;
import com.androidaplication.bubu.pogoda.service.Service;
import com.androidaplication.bubu.pogoda.service.ServiceMenager;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.weatherLayout) RelativeLayout mWeatherLayout;
    @Bind(R.id.summaryLabel)TextView mSummary;
    @Bind(R.id.temperatureValue) TextView mTemperature;
    @Bind(R.id.timeValue) TextView mTime;
    @Bind(R.id.townLabel) TextView mTown;
    @Bind(R.id.celciuszLabel) TextView mCelciusz;

    private Weather mWeather;
    private Currently mCurrently;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);

        String latitude = "50.259";
        String longitude = "19.02";
        Service service = ServiceMenager.getService();
        Call<Weather> weatherCall = service.getWeather(latitude, longitude);
        weatherCall.enqueue(weatherCallback());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private Callback<Weather> weatherCallback() {
        return new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful()) {
                    mWeather = response.body();
                    updateDisplay();
                }
                else Log.d("MainActivity: ", "onResponse failed");
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("MainActivity: ", "onFailure");
            }
        };
    }

    private void updateDisplay(){
        mCurrently = mWeather.getCurrently();

        mSummary.setText(mCurrently.getTranslateSummary());
        mTemperature.setText(mCurrently.getFormatterTemperature()+ "");
        mTime.setText(mCurrently.getFormatterTime());
        mWeatherLayout.setBackgroundResource(mCurrently.getBackgroundIconId());
        changeTextColor(mCurrently.getIcon());
    }

    private void changeTextColor(String iconId){
        if(iconId.equals("clear-day")){
            mSummary.setTextColor(Color.GRAY);
            mTemperature.setTextColor(Color.GRAY);
            mTime.setTextColor(Color.GRAY);
            mTown.setTextColor(Color.GRAY);
            mCelciusz.setTextColor(Color.GRAY);
        }else if(iconId.equals("Partly Cloudy")){
            mSummary.setTextColor(Color.BLACK);
            mTemperature.setTextColor(Color.BLACK);
            mTime.setTextColor(Color.BLACK);
            mTown.setTextColor(Color.BLACK);
            mCelciusz.setTextColor(Color.BLACK);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.detailsWeather) {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra(KeyClass.WEATHER_DETAILS,mCurrently);
            startActivity(intent);
        } else if (id == R.id.hourlyWeather) {
            Hourly hourly = mWeather.getHourly();
            Intent intent = new Intent(MainActivity.this, HourlyActivity.class);
            intent.putExtra(KeyClass.HOURLY, hourly);
            startActivity(intent);
        } else if (id == R.id.dailyWeather) {
            Daily daily = mWeather.getDaily();
            Intent intent = new Intent(MainActivity.this, DailyActivity.class);
            intent.putExtra(KeyClass.DAILY, daily);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
