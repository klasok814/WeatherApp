package com.androidaplication.bubu.pogoda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidaplication.bubu.pogoda.R;
import com.androidaplication.bubu.pogoda.data.DailyData;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Klaudia on 2016-05-08.
 */
public class DailyAdapter extends BaseAdapter {
    private List<DailyData> mDailyDataList;
    private Context mContext;

    public DailyAdapter(List<DailyData> dailyDatas, Context context){
        mDailyDataList = dailyDatas;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mDailyDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDailyDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_elemnt, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
           holder = (ViewHolder) convertView.getTag();
        }

        DailyData dailyData = mDailyDataList.get(position);
        holder.mTemperatureValue.setText(dailyData.getFormatterTemperature() + "");
        if(position == 0)
            holder.mWeekdayValue.setText("dzisiaj");
        else if(position == 1)
            holder.mWeekdayValue.setText("jutro");
        else holder.mWeekdayValue.setText(dailyData.getDayOfTheWeek());

        return convertView;
    }

    protected class ViewHolder{
        @Bind(R.id.dailyTemperatureLabel) TextView mTemperatureValue;
        @Bind(R.id.weekDayLabel) TextView mWeekdayValue;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
