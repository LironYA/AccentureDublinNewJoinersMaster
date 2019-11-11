package com.example.android.accenturenewjoiners.Activities.Wellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.Activities.News;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class FindWellnessActivityDublinMenu extends AppCompatActivity {
    TextView textView;
    TextView wellnessTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_wellness);
        setTitle("Accenture Wellness");

        wellnessTextView = (TextView) findViewById(R.id.wellnessTextView);
        final ArrayList<ListViewSelector> options = new ArrayList<>();
        options.add(new ListViewSelector("Block P", "East Point", R.drawable.accenture));
        options.add(new ListViewSelector("Block R", "East Point", R.drawable.accenture));
        options.add(new ListViewSelector("Freeman House", "East Point", R.drawable.accenture));
        options.add(new ListViewSelector("Block N", "East Point", R.drawable.accenture));
        options.add(new ListViewSelector("Sandyford", "Sandyford", R.drawable.accenture));
        options.add(new ListViewSelector("SOBO", "Dublin 2", R.drawable.accenture));
        WellnessAdapter adapter = new WellnessAdapter(this, options, R.color.accentureBlue);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // if (indexOf(Selection) == 0) {
                if (position == 0) {
                    Intent myIntent = new Intent(FindWellnessActivityDublinMenu.this, BlockPDublin.class);
                    FindWellnessActivityDublinMenu.this.startActivity(myIntent);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(FindWellnessActivityDublinMenu.this, News.class);
                    FindWellnessActivityDublinMenu.this.startActivity(myIntent);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(FindWellnessActivityDublinMenu.this, News.class);
                    FindWellnessActivityDublinMenu.this.startActivity(myIntent);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(FindWellnessActivityDublinMenu.this, News.class);
                    FindWellnessActivityDublinMenu.this.startActivity(myIntent);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(FindWellnessActivityDublinMenu.this, News.class);
                    FindWellnessActivityDublinMenu.this.startActivity(myIntent);
                }
            }
        });
    }
}

