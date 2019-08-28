package com.example.android.accenturenewjoiners.Activities.Accenture;

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

public class InformationFragment extends Fragment {
    public InformationFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> generalInformation = new ArrayList<ArrayListFragments>();
        generalInformation.add(new ArrayListFragments("https://portal.accenture.com","Personal Information", "https://www.accenture.com/t20190513t185056z__w__/us-en/_acnmedia/accenture/redesign-assets/dotcom/images/global/hero/4/accenture-digital-consulting-marquee-610x425.png", "Get your personal information in Accenture's Portal\nSign in required."));
        generalInformation.add(new ArrayListFragments("https://myte.accenture.com/OGTE/dashboard/DashboardPage.aspx","Time and Expences", "https://www.accenture.com/t20190513t185056z__w__/us-en/_acnmedia/accenture/redesign-assets/dotcom/images/global/hero/4/accenture-digital-consulting-marquee-610x425.png", "Get your personal information in Accenture's Portal\nSign in required."));

        generalInformation.add(new ArrayListFragments("https://google.com","Chat with HR Peopleline", "https://www.accenture.com/t20190513t185056z__w__/us-en/_acnmedia/accenture/redesign-assets/dotcom/images/global/hero/4/accenture-digital-consulting-marquee-610x425.png", "The Peopleline team is available between 08:30 am to 05:30 pm Monday to Friday.\nSign in required."));
        generalInformation.add(new ArrayListFragments("https://pages.goview.accenture.com/page.aspx?QS=38dfbe491fab00eace450ee73709cb0d5e801954bd27905d757db40c3dea91fa","Subscribe to Accenture's Newsletter", "https://www.accenture.com/t20190513t185056z__w__/us-en/_acnmedia/accenture/redesign-assets/dotcom/images/global/hero/4/accenture-digital-consulting-marquee-610x425.png", "Get the latest insights and research\n" +
                "delivered straight to your inbox."));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), generalInformation);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = generalInformation.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;
    }
}
