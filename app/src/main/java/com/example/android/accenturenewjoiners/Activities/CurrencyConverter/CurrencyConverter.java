package com.example.android.accenturenewjoiners.Activities.CurrencyConverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.accenturenewjoiners.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class CurrencyConverter extends AppCompatActivity {

    public static BreakIterator data;
    List<String> keysList;
    Spinner toCurrency;
    TextView totalInEuro;
    TextView equelsTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_converter);
        toCurrency = (Spinner)findViewById(R.id.planets_spinner);
        final EditText edtEuroValue = (EditText)findViewById(R.id.editText4);
        final Button btnConvert = (Button)findViewById(R.id.button);
        totalInEuro =(TextView) findViewById(R.id.totalInEuro);
        equelsTo = (TextView)findViewById(R.id.equelsTo);
        try {
            loadConvTypes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtEuroValue.getText().toString().isEmpty())
                {
                    String toCurr = toCurrency.getSelectedItem().toString();
                    double euroValue = Double.valueOf(edtEuroValue.getText().toString());
                    Integer euroValueInt = (int) Math.round(euroValue);
                    totalInEuro.setText(euroValueInt + "€ equals to");
                    try {
                        convertCurrency(toCurr, euroValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(CurrencyConverter.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(CurrencyConverter.this, "Please enter a value in Euro to convert..", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void loadConvTypes() throws IOException {

        String url = "https://api.exchangeratesapi.io/latest";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                Toast.makeText(CurrencyConverter.this, mMessage, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String mMessage = response.body().string();


                CurrencyConverter.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(MainActivity.this, mMessage, Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject obj = new JSONObject(mMessage);
                            JSONObject  b = obj.getJSONObject("rates");

                            Iterator keysToCopyIterator = b.keys();
                            keysList = new ArrayList<String>();

                            while(keysToCopyIterator.hasNext()) {

                                String key = (String) keysToCopyIterator.next();

                                keysList.add(key);
                            }
                            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, keysList);
                            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            toCurrency.setAdapter(spinnerArrayAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public void convertCurrency(final String toCurr, final double euroValue) throws IOException {

        String url = "https://api.exchangeratesapi.io/latest";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .build();



        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                Toast.makeText(CurrencyConverter.this, mMessage, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String mMessage = response.body().string();
                CurrencyConverter.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(MainActivity.this, mMessage, Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject obj = new JSONObject(mMessage);
                            JSONObject  b = obj.getJSONObject("rates");
                            String val = b.getString(toCurr);
                            double output = euroValue*Double.valueOf(val);
                            String currencyValue = toCurrency.getSelectedItem().toString();
                            equelsTo.setText(String.valueOf(output + " " + currencyValue));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}