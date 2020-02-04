package com.example.android.accenturenewjoiners.Activities.AboutUs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class AboutUsAdapter extends ArrayAdapter<AboutUsSelector> {
        private int colorResource;

        public AboutUsAdapter(@NonNull Context context, ArrayList<AboutUsSelector> about, int colorResourceId) {
            super(context, 0, about);
            colorResource = colorResourceId;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItemView = convertView;
            // Check if the existing view is being reused, otherwise inflate the view
            if (listItemView == null) {
                //We inflate the view meaning we create a new list item layout
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_about_us, parent, false);
            }
            // Get the object located at this position in the list
            AboutUsSelector currentSelection = getItem(position);
            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView CityText = (TextView) listItemView.findViewById(R.id.contact_list);
            // Get the English word from the current Word object and set this text on the name TextView
            CityText.setText(currentSelection.getContacts());

            TextView areaTextView = (TextView) listItemView.findViewById(R.id.desc_list);
            areaTextView.setText(currentSelection.getDescription());
            //Return the whole list item layout so that it can be shown in the ListView
            ImageView city_image = (ImageView) listItemView.findViewById(R.id.contact_image);
            city_image.setImageResource(currentSelection.getImage());
            city_image.setVisibility(View.VISIBLE);
            //Set the theme color for the list item
            View textContainer = listItemView.findViewById(R.id.text_container);
            //find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), colorResource);
            //Set the GB color of the text container view
            textContainer.setBackgroundColor(color);
            return listItemView;
        }
    }

