package com.example.android.accenturenewjoiners.Activities.FindHouse;

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

import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class HouseFBGroups extends Fragment {
    public HouseFBGroups() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> fb_groups = new ArrayList<ArrayListFragments>();
        fb_groups.add(new ArrayListFragments("https://www.facebook.com/groups/Rentdublin/","Rent in Dublin group", "https://princetontx.gov/wp-content/uploads/2019/03/facebook-logo-transparent.png", "Find a house, apartment or room to rent/to share in Dublin."));
        fb_groups.add(new ArrayListFragments("https://www.facebook.com/groups/DublinRoomRent/","Dublin Rent", "https://princetontx.gov/wp-content/uploads/2019/03/facebook-logo-transparent.png", "Find a house, apartment or room to rent/to share in Dublin."));
        fb_groups.add(new ArrayListFragments("https://www.facebook.com/DublinRoommates/","Dublin Rooms For Rent", "https://princetontx.gov/wp-content/uploads/2019/03/facebook-logo-transparent.png", "Find a house, apartment or room to rent/to share in Dublin."));
        fb_groups.add(new ArrayListFragments("https://www.facebook.com/DublinRoomforRent/","Dublin Rooms For Rent", "https://princetontx.gov/wp-content/uploads/2019/03/facebook-logo-transparent.png", "Find a house, apartment or room to rent/to share in Dublin."));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), fb_groups);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = fb_groups.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}

