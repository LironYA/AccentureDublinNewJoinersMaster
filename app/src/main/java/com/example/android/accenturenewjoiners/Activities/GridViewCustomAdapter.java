package com.example.android.accenturenewjoiners.Activities;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.accenturenewjoiners.Activities.Accenture.AccentureMain;
import com.example.android.accenturenewjoiners.Activities.Benefits.BenefitsMain;
import com.example.android.accenturenewjoiners.Activities.Bills.BillsMain;
import com.example.android.accenturenewjoiners.Activities.ContactUs.ContactUsActivity;
import com.example.android.accenturenewjoiners.Activities.CurrencyConverter.CurrencyConverter;
import com.example.android.accenturenewjoiners.Activities.EmergencyInformation.EmergencyInformationMain;
import com.example.android.accenturenewjoiners.Activities.FindHouse.FindHouseMain;
import com.example.android.accenturenewjoiners.Activities.HealthCare.HealthCareIreland;
import com.example.android.accenturenewjoiners.Activities.Immigration.ImmigrationMain;
import com.example.android.accenturenewjoiners.Activities.Kids.KidsMain;
import com.example.android.accenturenewjoiners.Activities.Revenue.RevenueMain;
import com.example.android.accenturenewjoiners.Activities.StartingOut.StartingOut;
import com.example.android.accenturenewjoiners.Activities.ThingsToSee.ThingsToSeeMain;
import com.example.android.accenturenewjoiners.Activities.Transportation.TransportationMainActivity;
import com.example.android.accenturenewjoiners.Activities.Weather.WeatherMain;
import com.example.android.accenturenewjoiners.Activities.Welfare.WelfareMain;
import com.example.android.accenturenewjoiners.Activities.Wellness.WellnessMainScreen;
import com.example.android.accenturenewjoiners.R;


public class GridViewCustomAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public GridViewCustomAdapter(MainScreen mainScreen, String[] osNameList, int[] osImages) {
        this.context = context;
        result=osNameList;
        context=mainScreen;
        imageId=osImages;
        inflater = ( LayoutInflater )context.
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

    public class Holder
    {
        TextView os_text;
        ImageView os_img;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.gridlayout, null);
        holder.os_text =(TextView) rowView.findViewById(R.id.os_texts);
        holder.os_img =(ImageView) rowView.findViewById(R.id.os_images);
        holder.os_text.setText(result[position]);
        holder.os_img.setImageResource(imageId[position]);
        //holder.os_img.setImageResource(R.drawable.circle);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //About Accenture
                if(position == 0) {
                    Intent intent= new Intent(context, AccentureMain.class);
                    v.getContext().startActivity(intent);
                }
                //Locations
                if(position == 1) {
                    Intent intent= new Intent(context, Locations.class);

                    v.getContext().startActivity(intent);
                }
                //News
                if(position == 2) {
                    Intent intent= new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                //Starting out
                if(position == 3) {
                    Intent intent= new Intent(context, StartingOut.class);
                    v.getContext().startActivity(intent);
                }
                //find a house
                if(position == 4)
                {
                    Intent intent= new Intent(context, FindHouseMain.class);
                    v.getContext().startActivity(intent);
                }
                //Transportation
                if(position == 5)
                {
                    Intent intent= new Intent(context, TransportationMainActivity.class);
                    v.getContext().startActivity(intent);
                }
                //Bills
                if(position == 6)
                {
                    Intent intent= new Intent(context, BillsMain.class);
                    v.getContext().startActivity(intent);
                }
                //Immigration
                if(position == 7)
                {
                    Intent intent= new Intent(context, ImmigrationMain.class);
                    v.getContext().startActivity(intent);
                }
                //Revenue
                if(position == 8) {
                    Intent intent= new Intent(context, RevenueMain.class);
                        v.getContext().startActivity(intent);
                }
                //Welfare
                if(position == 9) {
                    Intent intent= new Intent(context, WelfareMain.class);
                    v.getContext().startActivity(intent);
                }
                //Health Care
                if(position == 10) {
                    Intent intent= new Intent(context, HealthCareIreland.class);
                    v.getContext().startActivity(intent);
                }
                //Emergency Information
                if(position == 11) {
                    Intent intent= new Intent(context, EmergencyInformationMain.class);
                    v.getContext().startActivity(intent);
                }
                //Accenture Wellness
                if(position == 12) {
                    Intent intent= new Intent(context, WellnessMainScreen.class);
                    v.getContext().startActivity(intent);
                }
                // HR Information
                if(position == 13) {
                    Intent intent= new Intent(context, CurrencyConverter.class);
                    v.getContext().startActivity(intent);
                }
                //Report an Incident
                if(position == 14) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "report@accenture.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "Incident report");
                    email.putExtra(Intent.EXTRA_TEXT, "Dear team, \nI would like to report the following issue:\n");
                    email.setType("vnd.android.cursor.item/email");
                    v.getContext().startActivity(Intent.createChooser(email, "Please choose an Email app"));
                }
                //Benefits
                if(position == 15) {
                    Intent intent= new Intent(context, BenefitsMain.class);
                    v.getContext().startActivity(intent);
                }
                //Relocating with kids
                if(position == 16) {
                    Intent intent= new Intent(context, KidsMain.class);
                    v.getContext().startActivity(intent);
                }
                //Things to see
                if(position == 17) {
                    Intent intent= new Intent(context, ThingsToSeeMain.class);
                    v.getContext().startActivity(intent);
                }
                //Weather
                if(position == 18) {
                    Intent intent= new Intent(context, WeatherMain.class);
                    v.getContext().startActivity(intent);
                }
                //contact us
                if(position == 19) {
                    Intent intent= new Intent(context, ContactUsActivity.class);
                    v.getContext().startActivity(intent);
                }
                Toast.makeText(context, "You Clicked On "+result[position], Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }

}