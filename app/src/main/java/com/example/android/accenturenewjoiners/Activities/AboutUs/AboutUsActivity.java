package com.example.android.accenturenewjoiners.Activities.AboutUs;

import android.content.Intent;
import android.net.Uri;
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
        //Toolbar and back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        final ArrayList<AboutUsSelector> about = new ArrayList<>();
        about.add(new AboutUsSelector("WhatsApp", "Contact us via WhatsApp", R.drawable.whatsapp));
        about.add(new AboutUsSelector("Slack", "Contact us via Slack's App", R.drawable.slack));
        about.add(new AboutUsSelector("Email the developer", "Contact Liron via Email", R.drawable.mail));

        AboutUsAdapter adapter = new AboutUsAdapter(this, about, R.color.transparent);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Uri whatsappURL = Uri.parse("https://chat.whatsapp.com/E60jiZjtOZb2R8GHByJ1VZ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, whatsappURL);
                    startActivity(intent);
                }
                if (position == 1) {
                    Uri slackURL = Uri.parse("https://accenture-app.slack.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, slackURL);
                    startActivity(intent);
                }
                //Email Liron
                if(position == 2) {
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    emailIntent.setType("vnd.android.cursor.item/email");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"korkinazor@gmail.com"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "App Contact");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hi Liron, \n");
                    startActivity(emailIntent);
                }
            }
        });

    }

}
