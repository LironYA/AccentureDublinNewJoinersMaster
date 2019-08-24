package com.example.android.accenturenewjoiners.Activities.Transportation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.accenturenewjoiners.Activities.Bills.BillsMain;
import com.example.android.accenturenewjoiners.Activities.FindHouse.FindHouseMain;
import com.example.android.accenturenewjoiners.Activities.Immigration.ImmigrationMain;
import com.example.android.accenturenewjoiners.Activities.Locations;
import com.example.android.accenturenewjoiners.Activities.MainActivity;

import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.Activities.News;
import com.example.android.accenturenewjoiners.Activities.Revenue.RevenueMain;
import com.example.android.accenturenewjoiners.Activities.StartingOut.StartingOut;
import com.example.android.accenturenewjoiners.Activities.Welfare.WelfareMain;
import com.example.android.accenturenewjoiners.Activities.Wellness.WellnessMain;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class LuasFragment extends Fragment {

    public LuasFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);
        ListView listView;


        final ArrayList<ArrayListFragments> luas = new ArrayList<ArrayListFragments>();

        luas.add(new ArrayListFragments("https://www.google.com","Luas Green Line", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", "Get information for Luas green line. \n Stop Map, Tickets, Operating Hours and Frequency"));
        luas.add(new ArrayListFragments("https://google.com","Luas Red Line", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", "Get information for Luas red line. \n Stop Map, Tickets, Operating Hours and Frequency"));
        luas.add(new ArrayListFragments("https://google.com","Luas Ticket Types", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", "Get information for all Luas's Ticket Types"));
        luas.add(new ArrayListFragments("https://google.com","Luas Times", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", ""));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), luas);
        listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);
        // Add event listener so we can handle clicks
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
ArrayListFragments luas_sites = luas.get(position);
                    Uri siteURL = Uri.parse(luas_sites.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                    getActivity().startActivity(intent);
                    Log.i("Test", "Test");

                }

        });
                    return rootView;

    }

}


        //OnClickListener



//getApplicationContext



