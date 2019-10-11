package com.example.android.accenturenewjoiners.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;
import java.util.List;


public class Locations extends AppCompatActivity {
    private List<RecyclerViewItem> itemList = null;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        setTitle("Accenture Locations");
        // Item list - card view
        initializeItemList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_view_recycler_list);

        // Create the grid layout manager with 1 column.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        // Set layout manager.
        recyclerView.setLayoutManager(gridLayoutManager);
        // Create car recycler view data adapter with car item list.
        RecyclerViewDataAdapter DataAdapter = new RecyclerViewDataAdapter(itemList);
        // Set data adapter.
        recyclerView.setAdapter(DataAdapter);
        Context context = null;
        recyclerView.addOnItemTouchListener (
                new RecyclerItemClickListener(context,recyclerView, new RecyclerItemClickListener.OnItemClickListener () {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (position == 0) {
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                    Uri.parse("https://www.google.com/maps?daddr=53.343981, -6.233636"));
                            startActivity(intent);
                        }
                    if (position == 1) {
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                Uri.parse("https://www.google.com/maps?daddr=53.343594, -6.239228"));
                        startActivity(intent);
                    }
                    //East Point
                        if (position == 2) {
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                    Uri.parse("https://www.google.com/maps?daddr=53.358356, -6.225790"));
                            startActivity(intent);
                        }
                        //SOBO
                        if (position == 3) {
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                    Uri.parse("https://www.google.com/maps?daddr=53.345924, -6.244830"));
                            startActivity(intent);
                        }
                        //Sandyford
                        if (position == 4) {
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                    Uri.parse("https://www.google.com/maps?daddr=53.267332, -6.197447"));
                            startActivity(intent);
                        }
                        //The Academy
                        if (position == 5) {
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                    Uri.parse("https://www.google.com/maps?daddr=53.344569, -6.250235"));
                            startActivity(intent);
                        }
                        //Grand Canal 3
                        if (position == 6) {
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                    Uri.parse("https://www.google.com/maps?daddr=53.339275, -6.238778"));
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    }
    /* Initialise items in list. */
    private void initializeItemList() {
        if (itemList == null) {
            itemList = new ArrayList<RecyclerViewItem>();
            itemList.add(new RecyclerViewItem("Accenture The Dock\n7 Hanover Quay, Grand Canal Dock, Dublin 4", R.drawable.hanoverq));
            itemList.add(new RecyclerViewItem("Accenture Grand Canal\n 1 Grand Canal Square, Grand Canal Quay, Grand Canal Dock, Dublin 2", R.drawable.grandcanal));
            itemList.add(new RecyclerViewItem("Accenture SOBO\n 2 Windmill Ln, Sir John Rogerson's Quay, Dublin 2", R.drawable.sobo));
            itemList.add(new RecyclerViewItem("Accenture Eastpoint Business Park\n Alfie Byrne Rd, Dublin 3", R.drawable.eastpoint));
            itemList.add(new RecyclerViewItem("Accenture South County Business Park (Sandyford)\n South County Business Park, Carmanhall and Leopardstown, Dublin 18", R.drawable.sandyford));
            itemList.add(new RecyclerViewItem("Accenture The Academy\n Pearse Street, Dublin 2", R.drawable.academy));
            itemList.add(new RecyclerViewItem("Accenture Grand Canal\n 3 Grand Canal Plaza, Grand Canal Street Upper, Dublin 4", R.drawable.plaza));
        }
    }
}
