package com.example.android.accenturenewjoiners.Activities.Lisbon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.accenturenewjoiners.Activities.Accenture.AccentureMain;
import com.example.android.accenturenewjoiners.Activities.Bills.BillsMain;
import com.example.android.accenturenewjoiners.Activities.FindHouse.FindHouseMain;
import com.example.android.accenturenewjoiners.Activities.Lisbon.GridViewCustomAdapterLisbon;
import com.example.android.accenturenewjoiners.Activities.Immigration.ImmigrationMain;
import com.example.android.accenturenewjoiners.Activities.Locations;
import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.Activities.News;
import com.example.android.accenturenewjoiners.Activities.Revenue.RevenueMain;
import com.example.android.accenturenewjoiners.Activities.StartingOut.StartingOut;
import com.example.android.accenturenewjoiners.Activities.Transportation.TransportationMainActivity;
import com.example.android.accenturenewjoiners.Activities.Weather.WeatherMain;
import com.example.android.accenturenewjoiners.Activities.Welfare.WelfareMain;
import com.example.android.accenturenewjoiners.Activities.Wellness.WellnessMain;
import com.example.android.accenturenewjoiners.Activities.Wellness.WellnessMainScreen;
import com.example.android.accenturenewjoiners.R;

public class GridViewCustomAdapterLisbon extends BaseAdapter {
    String[] result;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public GridViewCustomAdapterLisbon(LisbonMainScreen mainScreen, String[] osNameList, int[] osImages) {
        this.context = context;
        result = osNameList;
        context = mainScreen;
        imageId = osImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView os_text;
        ImageView os_img;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        GridViewCustomAdapterLisbon.Holder holder = new GridViewCustomAdapterLisbon.Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.gridlayout, null);
        holder.os_text = (TextView) rowView.findViewById(R.id.os_texts);
        holder.os_img = (ImageView) rowView.findViewById(R.id.os_images);
        holder.os_text.setText(result[position]);
        holder.os_img.setImageResource(imageId[position]);
        //holder.os_img.setImageResource(R.drawable.circle);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO ??Possibly change to case?? an intent will open a new activity when clicked. Maybe use extra here
                //About Accenture
                if (position == 0) {
                    Intent intent = new Intent(context, AccentureMain.class);
                    v.getContext().startActivity(intent);
                }
                //Locations
                if (position == 1) {
                    Intent intent = new Intent(context, LocationsLisbon.class);

                    v.getContext().startActivity(intent);
                }
                //News
                if (position == 2) {
                    Intent intent = new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                //Starting out
                if (position == 3) {
                    Intent intent = new Intent(context, StartingOut.class);
                    v.getContext().startActivity(intent);
                }
                //find a house
                if (position == 4) {
                    Intent intent = new Intent(context, FindHouseMain.class);
                    v.getContext().startActivity(intent);
                }
                //Transportation
                if (position == 5) {
                    Intent intent = new Intent(context, TransportationMainActivity.class);
                    v.getContext().startActivity(intent);
                }
                //Bills
                if (position == 6) {
                    Intent intent = new Intent(context, BillsMain.class);
                    v.getContext().startActivity(intent);
                }
                //Immigration
                if (position == 7) {
                    Intent intent = new Intent(context, ImmigrationMain.class);
                    v.getContext().startActivity(intent);
                }
                //Revenue
                if (position == 8) {
                    Intent intent = new Intent(context, RevenueMain.class);
                    v.getContext().startActivity(intent);
                }
                //Welfare
                if (position == 9) {
                    Intent intent = new Intent(context, WelfareMain.class);
                    v.getContext().startActivity(intent);
                }
                //Health Care
                if (position == 10) {
                    Intent intent = new Intent(context, WellnessMainScreen.class);
                    v.getContext().startActivity(intent);
                }
                //Emergency Information
                if (position == 11) {
                    Intent intent = new Intent(context, WellnessMainScreen.class);
                    v.getContext().startActivity(intent);
                }
                //Accenture Wellness
                if (position == 12) {
                    Intent intent = new Intent(context, WellnessMainScreen.class);
                    v.getContext().startActivity(intent);
                }
                // HR Information
                if (position == 13) {
                    Intent intent = new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                //Report Incident
                if (position == 14) {
                    Intent intent = new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                //Benefits
                if (position == 15) {
                    Intent intent = new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                //Weather forecast
                if (position == 16) {
                    Intent intent = new Intent(context, WeatherMain.class);
                    v.getContext().startActivity(intent);
                }
                //Things to see
                if (position == 17) {
                    Intent intent = new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                //Relocating with kids
                if (position == 18) {
                    Intent intent = new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                //contact us
                if (position == 19) {
                    Intent intent = new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                Toast.makeText(context, "You Clicked On " + result[position], Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }
}


