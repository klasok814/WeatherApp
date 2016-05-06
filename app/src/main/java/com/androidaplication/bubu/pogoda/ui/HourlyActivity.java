package com.androidaplication.bubu.pogoda.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.androidaplication.bubu.pogoda.R;
import com.androidaplication.bubu.pogoda.adapters.HourlyAdapter;
import com.androidaplication.bubu.pogoda.data.Hourly;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HourlyActivity extends ListActivity {
    @Bind(R.id.listHeader) TextView mListHeaderLabel;

    private Hourly mHourly;
    private HourlyAdapter mHourlyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly);
        ButterKnife.bind(this);


        mHourly = getIntent().getParcelableExtra(KeyClass.HOURLY);
        mListHeaderLabel.setText(mHourly.getTranslateSummary());
        mHourlyAdapter = new HourlyAdapter(mHourly.getHourlyDatas(), this);
        setListAdapter(mHourlyAdapter);
    }
}
