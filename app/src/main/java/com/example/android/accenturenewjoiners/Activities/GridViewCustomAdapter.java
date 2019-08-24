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

import com.example.android.accenturenewjoiners.Activities.Bills.BillsMain;
import com.example.android.accenturenewjoiners.Activities.FindHouse.FindHouseMain;
import com.example.android.accenturenewjoiners.Activities.Immigration.ImmigrationMain;
import com.example.android.accenturenewjoiners.Activities.Revenue.RevenueMain;
import com.example.android.accenturenewjoiners.Activities.StartingOut.StartingOut;
import com.example.android.accenturenewjoiners.Activities.Transportation.TransportationMainActivity;
import com.example.android.accenturenewjoiners.Activities.Welfare.WelfareMain;
import com.example.android.accenturenewjoiners.Activities.Wellness.WellnessMain;
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
                // TODO ??Possibly change to case?? an intent will open a new activity when clicked. Maybe use extra here
                if(position == 0) {
                    Intent intent= new Intent(context, Locations.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 1) {
                    Intent intent= new Intent(context, TransportationMainActivity.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 2) {
                    Intent intent= new Intent(context, StartingOut.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 3) {
                    Intent intent= new Intent(context, FindHouseMain.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 4)
                {
                    Intent intent= new Intent(context, BillsMain.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 5)
                {
                    Intent intent= new Intent(context, ImmigrationMain.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 6)
                {
                    Intent intent= new Intent(context, RevenueMain.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 7)
                {
                    Intent intent= new Intent(context, WelfareMain.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 10) {
                        Intent intent= new Intent(context, WellnessMain.class);
                        v.getContext().startActivity(intent);
                }
                if(position == 15) {
                    Intent intent= new Intent(context, News.class);
                    v.getContext().startActivity(intent);
                }
                Toast.makeText(context, "You Clicked On "+result[position], Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }

}