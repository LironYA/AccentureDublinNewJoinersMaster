package com.example.android.accenturenewjoiners.Activities.Revenue;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
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

public class GeneralRevenueFragment extends Fragment {
    public GeneralRevenueFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> generalRevenue = new ArrayList<ArrayListFragments>();
        generalRevenue.add(new ArrayListFragments("https://in.accenture.com/aboutaccenture/","List of Revenue services", "https://www.revenue.ie/SiteElements/Images/revenue-Logo.png", "Full list of services provided by the revenue office."));
        generalRevenue.add(new ArrayListFragments("https://www.revenue.ie/en/online-services/services/register-for-an-online-service/register-for-myaccount.aspx","myAccount", "https://www.revenue.ie/SiteElements/Images/revenue-Logo.png", "myAccount is a single access point for secure online services."));
        generalRevenue.add(new ArrayListFragments("https://www.mygovid.ie/","MyGovID", "https://www.fetchcourses.ie/content/img/signin-mygovid.png", "Your single login for government services in Ireland."));
        generalRevenue.add(new ArrayListFragments("https://www.revenue.ie/en/contact-us/index.aspx","Contact Revenue", "https://www.fetchcourses.ie/content/img/signin-mygovid.png", "Find the correct contact details for your query./n Revenue office phone: +353-17023011/n Log in to myAccount for sending online requests"));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), generalRevenue);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = generalRevenue.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}

