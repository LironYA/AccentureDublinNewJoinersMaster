package com.example.android.accenturenewjoiners.Activities.Wellness;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BlockPDublin extends AppCompatActivity {
    TextView wellnessTextView;
    String TextFileURL = "http://25.io/toau/audio/sample.txt";
    URL url;
    String WellnessText = "";
    String TextHolder = "", TextHolder2 = "";
    BufferedReader bufferReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_wellness);
        setTitle("Accenture Wellness - Block P");
        wellnessTextView = (TextView) findViewById(R.id.wellnessTextView);

        new BlockPDublin.GetNotePadFileFromServer().execute();
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
