package com.example.android.accenturenewjoiners.Activities.Wellness;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.android.accenturenewjoiners.Activities.Locations;
import com.example.android.accenturenewjoiners.Activities.News;
import com.example.android.accenturenewjoiners.Activities.RecyclerItemClickListener;
import com.example.android.accenturenewjoiners.Activities.RecyclerViewDataAdapter;
import com.example.android.accenturenewjoiners.Activities.RecyclerViewItem;
import com.example.android.accenturenewjoiners.R;

import com.example.android.accenturenewjoiners.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WellnessMainScreen extends AppCompatActivity {
    String TextFileURL = "http://25.io/toau/audio/sample.txt";
    TextView textView;
    URL url;
    String WellnessText = "";
    String TextHolder = "", TextHolder2 = "";
    BufferedReader bufferReader;
    TextView wellnessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_wellness);
        setTitle("Accenture Wellness");

        wellnessTextView = (TextView) findViewById(R.id.wellnessTextView);
        final ArrayList<ListViewSelector> options = new ArrayList<>();
        options.add(new ListViewSelector("Find Wellness Activity", "By Location or Building", R.drawable.accenture));
        options.add(new ListViewSelector("Eilat", "South", R.drawable.accenture));
        options.add(new ListViewSelector("Jerusalem", "Area", R.drawable.accenture));
        options.add(new ListViewSelector("Ashdod", "Area", R.drawable.accenture));
        WellnessAdapter adapter = new WellnessAdapter(this, options, R.color.accentureBlue);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // if (indexOf(Selection) == 0) {
                if (position == 0) {
                    Intent myIntent = new Intent(WellnessMainScreen.this, FindWellnessActivityDublinMenu.class);
                    WellnessMainScreen.this.startActivity(myIntent);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(WellnessMainScreen.this, News.class);
                    WellnessMainScreen.this.startActivity(myIntent);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(WellnessMainScreen.this, News.class);
                    WellnessMainScreen.this.startActivity(myIntent);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(WellnessMainScreen.this, News.class);
                    WellnessMainScreen.this.startActivity(myIntent);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(WellnessMainScreen.this, News.class);
                    WellnessMainScreen.this.startActivity(myIntent);
                }
            }
        });
        new GetNotePadFileFromServer().execute();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
            //
            wellnessTextView.setText(TextHolder);
            //  WellnessText = String.valueOf(getFileStreamPath(TextHolder));
            Log.i("Wellness", WellnessText);
            super.onPostExecute(finalTextHolder);
        }
        }}


