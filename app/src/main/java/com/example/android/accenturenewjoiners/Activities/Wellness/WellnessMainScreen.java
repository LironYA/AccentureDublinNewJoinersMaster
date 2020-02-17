package com.example.android.accenturenewjoiners.Activities.Wellness;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class WellnessMainScreen extends AppCompatActivity {
    String TextFileURL = "http://neverinsameplace.com/accenture/login/newfile.txt";
    TextView textView;
    URL url;
    String WellnessText = "";
    String TextHolder = "", TextHolder2 = "";
    BufferedReader bufferReader;
    TextView wellnessTextView;
    Context context;
    Button buttonTest;
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_wellness);
        setTitle("Accenture Wellness Updates");

        wellnessTextView = (TextView) findViewById(R.id.wellnessTextView);
        buttonTest = (Button) findViewById(R.id.button);

        new GetNotePadFileFromServer().execute();
        //Toolbar and back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //notifications
    }

    public class GetNotePadFileFromServer extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                url = new URL(TextFileURL);

                bufferReader = new BufferedReader(new InputStreamReader(url.openStream()));

                while ((TextHolder2 = bufferReader.readLine()) != null) {

                    TextHolder += TextHolder2 + "\n";
                }
                bufferReader.close();

            } catch (MalformedURLException malformedURLException) {

                malformedURLException.printStackTrace();
                TextHolder = malformedURLException.toString();

            } catch (IOException iOException) {

                iOException.printStackTrace();

                TextHolder = iOException.toString();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void finalTextHolder) {
            //Text View
            wellnessTextView.setText("Accenture's Wellness updates: \n" + TextHolder);
            wellnessTextView.setTextColor(Color.parseColor("#066e8a"));
            wellnessTextView.setTextSize(16);
            wellnessTextView.setGravity(Gravity.CENTER);
            super.onPostExecute(finalTextHolder);
        }
    }
}


