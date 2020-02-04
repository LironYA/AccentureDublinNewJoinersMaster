package com.example.android.accenturenewjoiners.Activities.AboutUs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;
import java.util.Objects;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ArrayList<AboutUsSelector> about = new ArrayList<>();
        about.add(new AboutUsSelector("WhatsApp", "Contact us via WhatsApp", R.drawable.whatsapp));
        about.add(new AboutUsSelector("Slack", "Contact us via Slack's App", R.drawable.slack));
        AboutUsAdapter adapter = new AboutUsAdapter(this, about, R.color.accentureBlue);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // if (indexOf(Selection) == 0) {
                if (position == 0) {
                    Intent myIntent = new Intent(AboutUsActivity.this, MainScreen.class);
                    AboutUsActivity.this.startActivity(myIntent);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(AboutUsActivity.this, AboutUsActivity.class);
                    AboutUsActivity.this.startActivity(myIntent);
                }
            }
        });

    }

}
