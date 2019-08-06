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
                    Intent intent= new Intent(context, PrivacyPolicyActivity.class);
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