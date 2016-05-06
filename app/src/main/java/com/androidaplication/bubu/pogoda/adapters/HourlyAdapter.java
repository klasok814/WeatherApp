package com.androidaplication.bubu.pogoda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidaplication.bubu.pogoda.R;
import com.androidaplication.bubu.pogoda.data.HourlyData;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Klaudia on 2016-05-06.
 */
public class HourlyAdapter extends BaseAdapter {
    private List<HourlyData> mHourlyDataList;
    private Context mContext;

    public HourlyAdapter(List<HourlyData> hourlyDataList, Context context){
        mHourlyDataList = hourlyDataList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mHourlyDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mHourlyDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.hourly_list_element, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        HourlyData hourlyData = mHourlyDataList.get(position);
        holder.mHourlyTime.setText(hourlyData.getFormatterTime());
        holder.mHourlyIcon.setImageResource(hourlyData.getIconId());
        holder.mHourlySummary.setText(hourlyData.getTranslateSummary());
        holder.mHourlyTemperature.setText(hourlyData.getFormatterTemperature() + "");

        return convertView;
    }

    protected static class ViewHolder{
        @Bind(R.id.hourly_time_label) TextView mHourlyTime;
        @Bind(R.id.hourly_icon) ImageView mHourlyIcon;
        @Bind(R.id.hourly_summary_label) TextView mHourlySummary;
        @Bind(R.id.hourly_temperature_label) TextView mHourlyTemperature;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
