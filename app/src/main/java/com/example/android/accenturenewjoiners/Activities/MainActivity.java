package com.example.android.accenturenewjoiners.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.accenturenewjoiners.R;

public class MainActivity extends Activity {

    Button log_in, help;
    EditText user_name, password;
    TextView reset;
    CheckBox remember_me;
    private ProgressBar progressBar;
    Prefrences prefs;
    boolean key = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_main);
        // Prefrences (confirm login)
        prefs = new Prefrences(getApplicationContext());
        prefs.checkLogin();
        log_in = (Button) findViewById(R.id.login);
        help = (Button) findViewById(R.id.help);
        user_name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        remember_me = (CheckBox) findViewById(R.id.remember_me);
        reset = (TextView) findViewById(R.id.reset);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check the credentials and login data (not case sensitive) and open the main screen
                if (user_name.getText().toString().equalsIgnoreCase("welcome") && password.getText().toString().equalsIgnoreCase("accenture")) {
                    Toast.makeText(getApplicationContext(), "Let's get started!", Toast.LENGTH_SHORT).show();
                    //Intent to open the Main Screen
                    Intent intent = new Intent(MainActivity.this, MainScreen.class);
                    startActivity(intent);
                    if (remember_me.isChecked()) {
                        prefs.createLoginSession("user", "test");
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong credentials, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name.setText(null);
                password.setText(null);
            }
        });

    }
}
