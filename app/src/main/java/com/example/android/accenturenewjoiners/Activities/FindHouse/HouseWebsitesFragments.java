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

public class HouseWebsitesFragments extends Fragment {
    public HouseWebsitesFragments() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> house_websites = new ArrayList<ArrayListFragments>();
        house_websites.add(new ArrayListFragments("https://www.citizensinformation.ie/en/housing/renting_a_home/","Home rent information", "https://www.highstreetashbourne.ie/cms-admin/resources/citizens-1.png", "Information for people looking for somewhere to rent: what questions to ask and information on your rights."));
        house_websites.add(new ArrayListFragments("https://onestopshop.rtb.ie/rent-pressure-zones/","Rent Pressure Zones", "https://onestopshop.rtb.ie/img-new/RTBlogo.png", "Rent Pressure Zones (RPZ) - is a designated area where rents cannot be increased by more than 4% per annum."));
        house_websites.add(new ArrayListFragments("https://www.daft.ie/","daft.ie", "https://c1.dmstatic.com/572d0d4dc09fa2f1b0801/frontend/images/logo@2x.png", "View Houses To Rent or Share in Dublin, the Largest Property Listings Website in Ireland."));
        house_websites.add(new ArrayListFragments("https://www.myhome.ie/rentals/dublin/property-to-rent","myhome.ie", "https://www.bergins.ie/wp-content/uploads/2017/03/MyHome-2.png", "Find Dublin property to rent or share."));
        house_websites.add(new ArrayListFragments("https://www.rent.ie/","rent.ie", "https://pngriver.com/wp-content/uploads/2018/03/Download-Rent-PNG-Pic-366.png", "Rent / Share Houses & Apartments in Ireland."));
        house_websites.add(new ArrayListFragments("https://www.spotahome.com/dublin","spotahome.com", "https://d26q4asbryw2nm.cloudfront.net/1911de2/bundles/sahapp/favicon/apple-touch-icon-60x60.png", "Rent / Share Houses & Apartments in Ireland."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), house_websites);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = house_websites.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
