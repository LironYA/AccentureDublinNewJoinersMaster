package com.example.android.accenturenewjoiners.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Prefrences {
    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    Editor editor;

    // Context
    Context context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AccenturePrefs";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String USER = "user";

    //  (make variable public to access from outside)
    public static final String NAME = "name";
    // Constructor
    public Prefrences(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String user, String name){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // Storing name in pref
        editor.putString(USER, user);

        // Storing email in pref
        editor.putString(NAME, name);
        // commit changes
        editor.commit();
    }

    public void checkLogin() {
        if(this.isLoggedIn()) {
            Intent i = new Intent(context, MainScreen.class);
            context.startActivity(i);
        }

}
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}