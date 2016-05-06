package com.androidaplication.bubu.pogoda.ui;

import android.app.ListActivity;
import android.os.Bundle;

import com.androidaplication.bubu.pogoda.R;

public class HourlyActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly);
    }
}
