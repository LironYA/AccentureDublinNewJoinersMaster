package com.example.android.accenturenewjoiners.Activities.EmergencyInformation;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.accenturenewjoiners.Activities.RecyclerItemClickListener;
import com.example.android.accenturenewjoiners.Activities.RecyclerViewDataAdapter;
import com.example.android.accenturenewjoiners.Activities.RecyclerViewItem;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;
import java.util.List;

public class EmergencyVideos extends Fragment {

    public EmergencyVideos() {
        // Required empty public constructor
    }
    private List<RecyclerViewItem> itemList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_card_view, container, false);

        initializeItemList();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.card_view_recycler_list);


    // Create the grid layout manager with 1 column.
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
    // Set layout manager.
        recyclerView.setLayoutManager(gridLayoutManager);


    // Create car recycler view data adapter with item list.
    RecyclerViewDataAdapter DataAdapter = new RecyclerViewDataAdapter(itemList);
    // Set data adapter.
        recyclerView.setAdapter(DataAdapter);
    Context context = null;
        recyclerView.addOnItemTouchListener (
                new RecyclerItemClickListener(context, recyclerView, new RecyclerItemClickListener.OnItemClickListener () {
        @Override
        public void onItemClick(View view, int position) {
            //CPR
            if (position == 0) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                        Uri.parse("https://www.youtube.com/watch?v=XpEvQuOWME0"));
                startActivity(intent);
            }
            //Asthma
            if (position == 1) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                        Uri.parse("https://www.youtube.com/watch?v=JEnG7TH2Txk"));
                startActivity(intent);
            }
            //Fainting
            if (position == 2) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                        Uri.parse("https://www.youtube.com/watch?v=umQ6rJRzY3E"));
                startActivity(intent);
            }
            //Seizure
            if (position == 3) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                        Uri.parse("https://www.youtube.com/watch?v=dv3agW-DZ5I"));
                startActivity(intent);
            }
            //Heimlich Maneuver
            if (position == 4) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                        Uri.parse("https://www.google.com/maps?daddr=53.267332, -6.197447"));
                startActivity(intent);
            }
        }

        @Override
        public void onLongItemClick(View view, int position) {

        }
    }));
/*
        Button Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                startActivity(intent);
            }
        });
        */
return rootView;
}
    /* Initialise items in list. */
    private void initializeItemList() {
        if (itemList == null) {
            itemList = new ArrayList<RecyclerViewItem>();
            itemList.add(new RecyclerViewItem("Cardiopulmonary resuscitation (CPR)\nLearn how to do CPR until help arrives", R.drawable.youtube));
            itemList.add(new RecyclerViewItem("Emergency Asthma Treatment\nWhen a person is having an asthma attack, the best treatment is to make sure that they stay calm as the attack will only last for a few minutes", R.drawable.youtube));
            itemList.add(new RecyclerViewItem("Fainting\nFainting is a momentary episode of unconsciousness caused by a sudden drop in blood pressure. Common causes include heat, pain or distress. If you feel faint, lie down and elevate your feet", R.drawable.youtube));
            itemList.add(new RecyclerViewItem("Recovery Position - For Seizure or Epilepsy\nStep-by-step guide to putting someone in the recovery position", R.drawable.youtube));
            itemList.add(new RecyclerViewItem("How to Give the Heimlich Maneuver\nFirst aid procedure used to treat upper airway obstructions (or choking) by foreign objects", R.drawable.youtube));
        }

    }


}
