package com.example.android.accenturenewjoiners.Activities.Revenue;

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

public class RevenueDetailsFragment extends Fragment {
    public RevenueDetailsFragment () {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> revenueDetails = new ArrayList<ArrayListFragments>();
        revenueDetails.add(new ArrayListFragments("https://www.ros.ie/myaccount-web/sign_in.html?execution=e1s1","Accenture's Revenue Details", "https://www.fetchcourses.ie/content/img/signin-mygovid.png", "For tax purpose, you are required to update revenue with your job details\n Log into myAccount and register Accenture’s details:\n Company name: Accenture Limited\n Employer provider's number: 6360745Q\n and your start date. It is recommended to update the information as soon as possible to avoid the emergency tax."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), revenueDetails);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = revenueDetails.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}