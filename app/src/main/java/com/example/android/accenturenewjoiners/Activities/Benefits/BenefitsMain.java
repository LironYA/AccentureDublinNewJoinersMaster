package com.example.android.accenturenewjoiners.Activities.Benefits;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class BenefitsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_activity);
        setTitle("Accenture Wellness");

        final ArrayList<ArrayListFragments> benefits = new ArrayList<ArrayListFragments>();
        benefits.add(new ArrayListFragments("https://in.accenture.com/careers/totalrewards", "Total Rewards", "pic", " Get information for your total rewards consist of cash compensation, opportunities to acquire equity and a wide range of benefits\n Log in required"));
        benefits.add(new ArrayListFragments("https://mytotalrewards.accenture.com/Benefits", "Benefits", "pic", "Find the schemes and benefits you are entitled to\n Log in required"));

        final ArrayListAdapter adapter = new ArrayListAdapter(this, benefits);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = benefits.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                startActivity(intent);
                Log.i("Test", "Test");

            }

        });

    }
}
