package com.example.android.accenturenewjoiners.Activities.Bills;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

public class InternetFragment extends Fragment {

    public InternetFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> internet = new ArrayList<ArrayListFragments>();
        internet.add(new ArrayListFragments("https://www.eir.ie/broadband","eir broadband", "https://upload.wikimedia.org/wikipedia/en/6/63/Eir-telecom-logo.png", "Get the latest plan for Fiber Internet and TV."));
        internet.add(new ArrayListFragments("https://www.virginmedia.ie/broadband/buy-a-broadband-package","Virgin Media Broadband", "https://www.virginmedia.ie/etc/designs/virginmedia-ie/media/logos/virgin_media.png", "Get the latest plan for Fiber Internet and TV."));
        internet.add(new ArrayListFragments("https://n.vodafone.ie/shop/broadband.html","VodafoneBroadband", "https://www.vodafone.ie/images/vf-logo.png", "Get the latest plan for Fiber Internet and TV."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), internet);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = internet.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
