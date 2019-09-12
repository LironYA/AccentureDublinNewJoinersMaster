package com.example.android.accenturenewjoiners.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupWindow;

import com.example.android.accenturenewjoiners.Activities.Lisbon.LisbonMainScreen;
import com.example.android.accenturenewjoiners.R;

public class MainActivity extends Activity {

    Button log_in, help;
    EditText user_name, password;
    TextView reset;
    CheckBox remember_me;
    private ProgressBar progressBar;
    SharedPreferences sp;
    Prefrences prefs;
    private LinearLayout mLinearLayout;

    boolean key = false;
    private int LOADER_ID = 1;
    private PopupWindow PopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar

        sp = getSharedPreferences("logged",MODE_PRIVATE);
        sp = getSharedPreferences("country",MODE_PRIVATE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_main);
        mLinearLayout = (LinearLayout) findViewById(R.id.rl);

        final Context context = getApplicationContext();

        // Prefrences (confirm login)
        prefs = new Prefrences(getApplicationContext());
        //final SharedPreferences sharedPrefsButton = PreferenceManager.getDefaultSharedPreferences(this);
        log_in = (Button) findViewById(R.id.login);
        help = (Button) findViewById(R.id.help);
        user_name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        remember_me = (CheckBox) findViewById(R.id.remember_me);

        reset = (TextView) findViewById(R.id.reset);
        if(sp.getBoolean("logged",false) && sp.getBoolean("country", true) ){
           // if (sp.getBoolean("country", true)) {
            Intent i = new Intent(this, MainScreen.class);
            this.startActivity(i);
        }
             //           else {
            //        Intent i = new Intent(this, News.class);
            //        this.startActivity(i);
        if(sp.getBoolean("logged", false) && sp.getBoolean("country", false)) {
            Intent i = new Intent(this, LisbonMainScreen.class);
            this.startActivity(i);
        }

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check the credentials and login data (not case sensitive) and open the main screen
                if (user_name.getText().toString().equalsIgnoreCase("welcome") && password.getText().toString().equalsIgnoreCase("accenture")) {
                    Toast.makeText(getApplicationContext(), "Let's get started!", Toast.LENGTH_SHORT).show();
                    //Intent to open the Main Screen
                   // Intent intent = new Intent(MainActivity.this, SelectCountryScreen.class);
                  //  startActivity(intent);
                    if (remember_me.isChecked()) {
                        sp.edit().putBoolean("logged",true).apply();
                    }
                           LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                           // Inflate the custom layout/view
                           View customView = inflater.inflate(R.layout.popup_activity,null);
                           // Initialize a new instance of popup window
                           PopupWindow = new PopupWindow(
                                   customView,
                                   ViewGroup.LayoutParams.WRAP_CONTENT,
                                   ViewGroup.LayoutParams.WRAP_CONTENT
                           );
                           if(Build.VERSION.SDK_INT>=21){
                               PopupWindow.setElevation(5.0f);
                           }

                           // Get a reference for the custom view close button
                           Button dublinButton = (Button) customView.findViewById(R.id.dublin);
                           // Set a click listener for the popup window close button
                           dublinButton.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   //Intent to open the Main Screen

                                   // Dismiss the popup window
                                   PopupWindow.dismiss();
                                   sp.edit().remove("country").apply();

                                   Intent intent = new Intent(MainActivity.this, MainScreen.class);
                                   startActivity(intent);
                               }
                           });
                    Button closeButton = (Button) customView.findViewById(R.id.close_button_popup);
                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Dismiss the popup window
                            PopupWindow.dismiss();
                            Intent intent = new Intent(MainActivity.this, MainScreen.class);
                            startActivity(intent);
                        }
                    });
                    Button lisbonButton = (Button) customView.findViewById(R.id.lisbon);
                    lisbonButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Dismiss the popup window
                            PopupWindow.dismiss();
                            sp.edit().putBoolean("country",true).apply();
                            Intent intent = new Intent(MainActivity.this, LisbonMainScreen.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    prefs.notLoggedIn();
                    Toast.makeText(getApplicationContext(), "Wrong credentials, please try again", Toast.LENGTH_SHORT).show();
                }
                PopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);

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
