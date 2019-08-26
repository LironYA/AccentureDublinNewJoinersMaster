package com.example.android.accenturenewjoiners.Activities.Transportation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BusFragment extends Fragment {


    public BusFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> bus = new ArrayList<ArrayListFragments>();
        bus.add(new ArrayListFragments("https://about.leapcard.ie/about","Leap Card", "https://www.nationaltransport.ie/wp-content/uploads/2011/12/tfi_logo1.png", "TFI Leap Card is a convenient way to pay for public transport services."));
        bus.add(new ArrayListFragments("https://hittheroad.ie","Hit The Road", "https://hittheroad.ie/assets/packaging/facebook-icon-4391ca57e38cfe112ef66c3734866fc4.png", "Public Transport Directions for Dublin. \n Enter you location and get direction by bus number, train (Dart) or Luas"));
        bus.add(new ArrayListFragments("https://www.dublinbus.ie","Dublin Bus", "https://www.dublinbus.ie/Global/LogoTypes/logo.gif","Dublin Bus is a bus operator providing services in Dublin.\n Get real time information, Timetables, Routh Planner and Fare calculator."));
        bus.add(new ArrayListFragments("http://www.a-b.ie/cp3/XSLT_TRIP_REQUEST2?language=en", "Journey Planner", "https://www.nationaltransport.ie/wp-content/uploads/2011/12/tfi_logo1.png", "Journey planning and timetable information."));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), bus);
        //http://www.a-b.ie/cp3/XSLT_TRIP_REQUEST2?language=en -- that's a journey planner
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments luas_sites = bus.get(position);
                Uri siteURL = Uri.parse(luas_sites.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
