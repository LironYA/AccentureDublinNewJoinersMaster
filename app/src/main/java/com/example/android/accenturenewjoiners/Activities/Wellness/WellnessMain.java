package com.example.android.accenturenewjoiners.Activities.Wellness;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.AsyncTask;

import com.example.android.accenturenewjoiners.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

    public class WellnessMain extends AppCompatActivity {

        String TextFileURL = "https://www.w3.org/TR/PNG/iso_8859-1.txt" ;
        TextView textView ;
        URL url ;
        String TextHolder = "" , TextHolder2 = "";
        BufferedReader bufferReader ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.wellness_activity);

            textView = (TextView)findViewById(R.id.textView);

                    new GetNotePadFileFromServer().execute();
        }

        public class GetNotePadFileFromServer extends AsyncTask<Void, Void, Void>{

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

                    // TODO Auto-generated catch block
                    malformedURLException.printStackTrace();
                    TextHolder = malformedURLException.toString();

                } catch (IOException iOException) {

                    // TODO Auto-generated catch block
                    iOException.printStackTrace();

                    TextHolder = iOException.toString();
                }

                return null;

            }

            @Override
            protected void onPostExecute(Void finalTextHolder) {

                textView.setText(TextHolder);

                super.onPostExecute(finalTextHolder);
            }

        }

}
