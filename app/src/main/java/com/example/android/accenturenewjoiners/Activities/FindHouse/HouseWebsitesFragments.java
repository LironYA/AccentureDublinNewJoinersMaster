package com.example.android.accenturenewjoiners.Activities.FindHouse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class HouseWebsitesFragments extends Fragment {
    public HouseWebsitesFragments() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> house_websites = new ArrayList<ArrayListFragments>();
        house_websites.add(new ArrayListFragments("https://www.daft.ie/","daft.ie", "https://c1.dmstatic.com/572d0d4dc09fa2f1b0801/frontend/images/logo@2x.png", "View Houses To Rent or Share in Dublin, the Largest Property Listings Website in Ireland."));
        house_websites.add(new ArrayListFragments("https://www.myhome.ie/rentals/dublin/property-to-rent","myhome.ie", "https://www.myhome.ie/assets/images/new_logo_v2.png", "Find Dublin property to rent or share."));
        house_websites.add(new ArrayListFragments("https://www.rent.ie/","rent.ie", "https://pngriver.com/wp-content/uploads/2018/03/Download-Rent-PNG-Pic-366.png", "Rent / Share Houses & Apartments in Ireland."));
        house_websites.add(new ArrayListFragments("https://www.rent.ie/","rent.ie", "https://pngriver.com/wp-content/uploads/2018/03/Download-Rent-PNG-Pic-366.png", "Rent / Share Houses & Apartments in Ireland."));
        house_websites.add(new ArrayListFragments("https://www.rent.ie/","rent.ie", "https://pngriver.com/wp-content/uploads/2018/03/Download-Rent-PNG-Pic-366.png", "Rent / Share Houses & Apartments in Ireland."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), house_websites);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;

    }
}
