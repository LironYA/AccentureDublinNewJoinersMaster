package com.example.android.accenturenewjoiners.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.android.accenturenewjoiners.R;

public class SelectCountryScreen extends AppCompatActivity {
    SharedPreferences sp;
    Prefrences prefs;
    ImageButton dublin, lisbon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.select_country);
        sp = getSharedPreferences("country", MODE_PRIVATE);
        prefs = new Prefrences(getApplicationContext());
        dublin = (ImageButton) findViewById(R.id.imageButtondublin);
        lisbon = (ImageButton) findViewById(R.id.imageButtonLisbon);
        dublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.edit().putBoolean("country",true).apply();
            }
        });
        //If Lisbon is selected
        lisbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.edit().putBoolean("country",false).apply();
            }
        });
    }
}
