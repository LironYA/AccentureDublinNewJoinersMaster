package com.example.android.accenturenewjoiners.Activities.Lisbon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.android.accenturenewjoiners.Activities.RecyclerItemClickListener;
import com.example.android.accenturenewjoiners.Activities.RecyclerViewDataAdapter;
import com.example.android.accenturenewjoiners.Activities.RecyclerViewItem;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;
import java.util.List;

public class LocationsLisbon extends AppCompatActivity {
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

                                        Uri.parse("https://www.google.com/maps?daddr=38.723995, -9.161711"));
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
                itemList.add(new RecyclerViewItem("Accenture Lisbon\nAmoreiras, Torre 1, Av. Eng. Duarte Pacheco 16 piso, Lisboa", R.drawable.acc_lis));

            }
        }
    }

