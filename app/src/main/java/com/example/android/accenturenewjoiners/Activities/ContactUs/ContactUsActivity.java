package com.example.android.accenturenewjoiners.Activities.ContactUs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.Activities.AboutUs.AboutUsActivity;
import com.example.android.accenturenewjoiners.Activities.AboutUs.AboutUsAdapter;
import com.example.android.accenturenewjoiners.Activities.AboutUs.AboutUsSelector;
import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;

public class ContactUsActivity extends AppCompatActivity {
    private RelativeLayout cLayout;
    private PopupWindow PopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contect_us_activity);
        setTitle("Contact Us");
        //Toolbar and back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Action Bar
        cLayout = (RelativeLayout) findViewById(R.id.rl);
        final Context context = getApplicationContext();
        final FloatingActionsMenu main = (FloatingActionsMenu) findViewById(R.id.main);
        final FloatingActionButton info = (FloatingActionButton) findViewById(R.id.info);
        //Pressing on the info icon
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                // Inflate the custom layout/view
                final View customView = inflater.inflate(R.layout.popup_info, null);
                main.collapse();
                // Initialize a new instance of popup window
                PopupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                if (Build.VERSION.SDK_INT >= 21) {
                    PopupWindow.setElevation(5.0f);
                }
                TextView info_text = (TextView) customView.findViewById(R.id.info_text);
                info_text.setText("Find ways to contact us, Whatsapp and Slack apps download may be required.");
                Button closeButton = (Button) customView.findViewById(R.id.close_button_popup);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        PopupWindow.dismiss();
                    }

                });
                Button close = (Button) customView.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        PopupWindow.dismiss();
                    }
                });
                PopupWindow.showAtLocation(cLayout, Gravity.CENTER, 0, 0);
            }
        });

        final FloatingActionButton contact = (FloatingActionButton) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ContactUsActivity.class);
                startActivity(intent);

            }
        });
        final FloatingActionButton home = (FloatingActionButton) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainScreen.class);
                startActivity(intent);
            }
        });
        final ArrayList<AboutUsSelector> contactUs = new ArrayList<>();
        contactUs.add(new AboutUsSelector("WhatsApp", "Contact us via WhatsApp", R.drawable.whatsapp));
        contactUs.add(new AboutUsSelector("Slack", "Contact us via Slack's App", R.drawable.slack));
        contactUs.add(new AboutUsSelector("Email (General Questions)", "Any questions? We are here to help", R.drawable.mail));
        contactUs.add(new AboutUsSelector("Email (Report an Incident)", "Report us about any incident", R.drawable.mail));
        contactUs.add(new AboutUsSelector("About Us", "Find information about the team behind the app", R.drawable.qmark));
        AboutUsAdapter adapter = new AboutUsAdapter(this, contactUs, R.color.transparent);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Whatsapp group
                if (position == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/E60jiZjtOZb2R8GHByJ1VZ"));
                    startActivity(intent);
                }
                //Slack
                if (position == 1) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accenture-app.slack.com"));
                    startActivity(intent);
                }
                //Email General
                if (position == 2) {
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    emailIntent.setType("vnd.android.cursor.item/email");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"korkinazor@gmail.com"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "General Question");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hi,\n I have a question about ");
                    startActivity(emailIntent);

                }
                //Email Incident
                if (position == 3) {
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    emailIntent.setType("vnd.android.cursor.item/email");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"korkinazor@gmail.com"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Incident Report");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hi,\n I would like to report about ");
                    startActivity(emailIntent);

                }
                //About us
                if (position == 4) {
                    startActivity(new Intent(ContactUsActivity.this, AboutUsActivity.class));
                }
            }
        });

    }

}

