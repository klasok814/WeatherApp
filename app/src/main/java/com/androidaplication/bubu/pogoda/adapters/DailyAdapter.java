package com.androidaplication.bubu.pogoda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidaplication.bubu.pogoda.R;
import com.androidaplication.bubu.pogoda.data.DailyData;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

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
        final ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_elemnt, parent, false);
            holder = new ViewHolder(convertView, position);
            convertView.setTag(holder);
        }else{
           holder = (ViewHolder) convertView.getTag();
        }

        final DailyData dailyData = mDailyDataList.get(position);
        holder.mTemperatureValue.setText(dailyData.getFormatterTemperature() + "");
        if(position == 0)
            holder.mWeekdayValue.setText(R.string.today_string);
        else if(position == 1)
            holder.mWeekdayValue.setText(R.string.tomorrow_string);
        else holder.mWeekdayValue.setText(dailyData.getDayOfTheWeek());

        holder.mShowDailyDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.mShowDailyDetailsButton.getText().toString().equals("+")){
                    holder.mStubeDetails.setVisibility(View.VISIBLE);
                    holder.mShowDailyDetailsButton.setText("-");
                } else if(holder.mShowDailyDetailsButton.getText().toString().equals("-")){
                    holder.mStubeDetails.setVisibility(View.GONE);
                    holder.mShowDailyDetailsButton.setText("+");
                }
            }
        });

        return convertView;
    }

    protected class ViewHolder{
        @Bind(R.id.dailyTemperatureLabel) TextView mTemperatureValue;
        @Bind(R.id.weekDayLabel) TextView mWeekdayValue;
        @Bind(R.id.showDailyDetails) Button mShowDailyDetailsButton;
        @Bind(R.id.stub_details) ViewStub mStubeDetails;

        private DailyData mDailyData;

        public ViewHolder(View view, int position ){
            ButterKnife.bind(this, view );

            mDailyData = (DailyData) DailyAdapter.this.getItem(position);
            updateView();
        }

        private void updateView(){
            View inflater = mStubeDetails.inflate();
            LinearLayout sunriseLayout = (LinearLayout) inflater.findViewById(R.id.sunriseLayout);
            updateLayout(sunriseLayout, mContext.getString(R.string.sunrise_stube_view),
                    R.drawable.sunrise, mDailyData.getFormatterSunriseTime());

            LinearLayout sunsetLayout = (LinearLayout) inflater.findViewById(R.id.sunsetLayout);
            updateLayout(sunsetLayout, mContext.getString(R.string.sunset_stube_view),
                    R.drawable.sunrise, mDailyData.getFormatterSunsetTime());

            LinearLayout moonPhraseLayout = (LinearLayout) inflater.findViewById(R.id.moonPhraseLayout);
            updateLayout(moonPhraseLayout, mContext.getString(R.string.moon_phrase_stube_view),
                    R.drawable.moon_phrase, mDailyData.getMoonPhase() + "");

            LinearLayout maxTemperatureLayout = (LinearLayout) inflater.findViewById(R.id.temperatureMaxLayout);
            String formMaxTemperature = mDailyData.getFormatterMaxTemperature() + mContext.getString(R.string.symbol_celciusza);
            updateLayout(maxTemperatureLayout, mContext.getString(R.string.temperature_max_stube_view),
                    R.drawable.hot_termometr, formMaxTemperature);

            LinearLayout mintemperatureLayout = (LinearLayout) inflater.findViewById(R.id.temperatureMinLayout);
            String formMinTemperature = mDailyData.getFormatterMinTemperature() + mContext.getString(R.string.symbol_celciusza);
            updateLayout(mintemperatureLayout, mContext.getString(R.string.temperature_min_stube_view),
                    R.drawable.cold_termometr, formMinTemperature);

            mStubeDetails.setVisibility(View.GONE);
        }

        private void updateLayout(LinearLayout layout, String updateText, int iconId, String updateData){
            TextView parameterLabel = (TextView) layout.getChildAt(0);
            parameterLabel.setText(updateText);
            ImageView iconImage = (ImageView) layout.getChildAt(1);
            iconImage.setImageResource(iconId);
            TextView characterLabel = (TextView) layout.getChildAt(2);
            characterLabel.setText(updateData);
        }
    }
}
