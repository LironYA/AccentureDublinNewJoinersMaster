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

        luas.add(new ArrayListFragments("https://luas.ie/luas-green-line-stops","Luas Green Line", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", "Get information for Luas green line. \n Stop Map, Tickets, Operating Hours and Frequency"));
        luas.add(new ArrayListFragments("https://luas.ie/luas-red-line-stops","Luas Red Line", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", "Get information for Luas red line. \n Stop Map, Tickets, Operating Hours and Frequency"));
        luas.add(new ArrayListFragments("https://luas.ie/ticket-types.html","Luas Ticket Types", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", "Get information for all Luas's Ticket Types"));
        luas.add(new ArrayListFragments("https://luas.ie/operating-hours.html","Luas Times", "https://www.luas.ie/assets/theme/images/Luas-og-img.png", "Get information for Luas's times"));
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



