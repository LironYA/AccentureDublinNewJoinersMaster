package com.example.android.accenturenewjoiners.Activities.Accenture;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.accenturenewjoiners.Activities.Revenue.PageFragmentRevenue;
import com.example.android.accenturenewjoiners.R;

public class AccentureMain extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main_fragments.xml layout file
        setContentView(R.layout.activity_main_fragments);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new PageFragmentAccenture(getSupportFragmentManager(),
                AccentureMain.this));


        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}
