package com.androidaplication.bubu.pogoda.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.androidaplication.bubu.pogoda.R;
import com.androidaplication.bubu.pogoda.adapters.DailyAdapter;
import com.androidaplication.bubu.pogoda.data.Daily;

public class DailyActivity extends ListActivity {
    private DailyAdapter mDailyAdapter;
    private Daily mDaily;

    private ViewStub mViewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        mDaily = getIntent().getParcelableExtra(KeyClass.DAILY);

        TextView listHeader = (TextView) getLayoutInflater().inflate(R.layout.dialy_list_header, null);
        getListView().addHeaderView(listHeader, null, false);
        mDailyAdapter = new DailyAdapter(mDaily.getDailyDatas(), this);
        setListAdapter(mDailyAdapter);
    }

    public void showDetails(View view){
         mViewStub = (ViewStub) findViewById(R.id.stub_details);
     }
}
