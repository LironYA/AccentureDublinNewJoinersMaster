package com.example.android.accenturenewjoiners.Activities.ContactUs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.Activities.AboutUs.AboutUsActivity;
import com.example.android.accenturenewjoiners.Activities.AboutUs.AboutUsAdapter;
import com.example.android.accenturenewjoiners.Activities.AboutUs.AboutUsSelector;
import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class ContactUsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contect_us_activity);
        setTitle("Contact Us");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ArrayList<AboutUsSelector> contact = new ArrayList<>();
        contact.add(new AboutUsSelector("WhatsApp", "Contact us via WhatsApp", R.drawable.whatsapp));
        contact.add(new AboutUsSelector("Slack", "Contact us via Slack's App", R.drawable.slack));
        contact.add(new AboutUsSelector("Email (General Questions)", "Any questions? We are here to help", R.drawable.slack));
        contact.add(new AboutUsSelector("Email (Report an Incident)", "Report us about any incident", R.drawable.slack));
        contact.add(new AboutUsSelector("Email (New Joiners)", "Please specify your work location and manager name", R.drawable.slack));
        contact.add(new AboutUsSelector("About Us", "Find information about the team behind the app", R.drawable.slack));
        AboutUsAdapter adapter = new AboutUsAdapter(this, contact, R.color.transparent);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // if (indexOf(Selection) == 0) {
                if (position == 0) {
                    Intent myIntent = new Intent(ContactUsActivity.this, MainScreen.class);
                    ContactUsActivity.this.startActivity(myIntent);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(ContactUsActivity.this, AboutUsActivity.class);
                    ContactUsActivity.this.startActivity(myIntent);
                }
            }
        });

    }

}

